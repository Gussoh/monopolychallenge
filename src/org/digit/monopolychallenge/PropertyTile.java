package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public class PropertyTile extends Tile {

    private String group;
    private String name;
    private int rent;
    private int price;
    private int houseLevel; // 0-5 0=no house, 5=hotel
    
    protected PropertyTile(String group, String name, int rent, int price){
    	super(name);
    	this.group = group;
    	this.name = name;
    	this.rent = rent;
    	this.price = price;
    }

    public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public int getRent() {
		return rent;
	}

	public int getPrice() {
		return price;
	}
	
	public void buy() throws IllegalActionException {
		// TODO
    }
}
