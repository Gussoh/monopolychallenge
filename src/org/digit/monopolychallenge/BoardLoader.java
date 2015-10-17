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
				parseProperty();
			}
			String group;
			String name;
			int rent;
			int price;
			if(!sc.hasNext()){
				return null;
			}
			group = sc.next();
			if(!sc.hasNext()){
				return null;
			}
			name = sc.next();
			if(!sc.hasNextInt()){
				return null;
			}
			price = sc.nextInt();
			if(!sc.hasNextInt()){
				return null;
			}
			rent = sc.nextInt();
			return 
		}
		
	}
	
}
