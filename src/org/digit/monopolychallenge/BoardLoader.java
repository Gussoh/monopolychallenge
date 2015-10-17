package org.digit.monopolychallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardLoader {

	public static Board load(String fileName){
		
		Scanner sc = new Scanner(fileName);
		
		List<Tile> tiles = new ArrayList<Tile>(); 
		
		while(sc.hasNextLine()){
			if(sc.next().equals("Property")){
				tiles.add(parseProperty(sc.nextLine()));
			}
		}
		
		return tiles.size() == 0 ? null : new Board(tiles);
		
	}
	
	public static PropertyTile parseProperty(String line){
		String[] splitted = line.split("\t");
		if(splitted.length != 8){
			return null;
		}
		String group = splitted[0];
		String name = splitted[1];
		int propertyPrice = Integer.parseInt(splitted[2]);
		int[] housePrices = new int[5];
		for(int i = 0; i < 5; i++){
			housePrices[i] = Integer.parseInt(splitted[3+i]);
		}
		return new PropertyTile(group, name, propertyPrice, housePrices);
	}
	
}
