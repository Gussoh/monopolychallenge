package org.digit.monopolychallenge;

import java.util.Arrays;

/**
 * Created by gussoh on 17/10/15.
 */
public class PropertyTile extends Tile {
	
    private String group;
    private String name;
    private int houseLevel; // 0-5 0=no house, 5=hotel
    private int propertyPrice;
    private int housePrice;
    private int[] houseRents;
    private Player owner;
    
    protected PropertyTile(Board board, String group, String name, int propertyPrice, int housePrice, int[] houseRents){
    	super(board, name);
    	this.group = group;
    	this.name = name;
    	this.propertyPrice = propertyPrice;
    	this.housePrice = housePrice;
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
	public int getHousePrice(){
		return housePrice;
	}
	
	protected void buy(Player buyer) throws IllegalActionException {
		getBoard().getGame().buy(buyer, this);
	}
	
	public void buy() throws IllegalActionException {
        buy(getBoard().getGame().getCurrentPlayer());
    }
	
	protected void sell(Player seller) throws IllegalActionException {
		getBoard().getGame().sell(seller, this);
	}
	
	public void sell() throws IllegalActionException {
		 sell(getBoard().getGame().getCurrentPlayer());
	}

    public Player getOwner() {
        return owner;
    }

    protected void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
    	return "PropertyTile{" +
    			"owner=" + owner + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", houseLevel=" + houseLevel +
                ", propertyPrice=" + propertyPrice +
                ", houseRents=" + Arrays.toString(houseRents) +
                '}';
    }
}