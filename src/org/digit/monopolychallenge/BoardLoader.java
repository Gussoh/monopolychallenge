package org.digit.monopolychallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BoardLoader {

	public static Board load(Game game, String fileName) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(fileName));
		
		List<Tile> tiles = new ArrayList<Tile>(); 
		
		Board board = new Board(game);
		
		while(sc.hasNextLine()){
			if(sc.next().equals("Property")){
				tiles.add(parseProperty(board, sc.nextLine()));
			}
		}
		
		board.setTiles(tiles);
		
		sc.close();
		
		if(tiles.size() == 0){
			throw new RuntimeException("Could not load tiles");
		}
		
		return board;
		
	}
	
	public static PropertyTile parseProperty(Board board, String line){
		line = line.trim();
		String[] splitted = line.split("\t");
		if(splitted.length != 9){
			throw new RuntimeException("Not enough tabs: " + splitted.length+", splitted: "+Arrays.toString(splitted));
		}
		// TODO catch numberformatexception
		String group = splitted[0];
		String name = splitted[1];
		int propertyPrice = Integer.parseInt(splitted[2]);
		int housePrice = Integer.parseInt(splitted[3]);
		int[] houseRents = new int[5];
		for(int i = 0; i < 5; i++){
			houseRents[i] = Integer.parseInt(splitted[4+i]);
		}
		return new PropertyTile(board, group, name, propertyPrice, housePrice, houseRents);
	}
	
}
