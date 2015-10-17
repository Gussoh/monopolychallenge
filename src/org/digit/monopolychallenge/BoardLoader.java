package org.digit.monopolychallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardLoader {

	public static Board load(Game game, String fileName){
		
		Scanner sc = new Scanner(fileName);
		
		List<Tile> tiles = new ArrayList<Tile>(); 
		
		Board board = new Board(game);
		
		while(sc.hasNextLine()){
			if(sc.next().equals("Property")){
				tiles.add(parseProperty(board, sc.nextLine()));
			}
		}
		
		sc.close();
		
		return tiles.size() == 0 ? null : new Board(tiles);
		
	}
	
	public static PropertyTile parseProperty(Board board, String line){
		String[] splitted = line.split("\t");
		if(splitted.length != 8){
			return null;
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
