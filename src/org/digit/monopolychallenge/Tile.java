package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public abstract class Tile {

	private String name;

	protected Tile(String name){
		this.name = name;
	}
	
    public String getName(){
    	return this.name;
    }

}
