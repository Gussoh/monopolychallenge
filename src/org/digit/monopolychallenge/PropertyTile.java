package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public class PropertyTile extends Tile {

    private String group;
    private String name;
    private int houseLevel; // 0-5 0=no house, 5=hotel
    private int propertyPrice;
    private int[] houseRents;
    
    protected PropertyTile(String group, String name, int propertyPrice, int[] houseRents){
    	super(name);
    	this.group = group;
    	this.name = name;
    	this.propertyPrice = propertyPrice;
    	this.houseRents = houseRents;
    }

    public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public int getRent() {
		return houseRents[houseLevel];
	}

	public int getPrice() {
		return propertyPrice;
	}
	
	public void buy() throws IllegalActionException {
		// TODO
    }
}
