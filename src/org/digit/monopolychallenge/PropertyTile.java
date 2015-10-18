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
		if (getOwner() != null) {
            throw new IllegalActionException("Property is already owned by " + getOwner());
        }
        if (buyer.getMoney() < getPrice()) {
            throw new IllegalActionException("Not enough money to buy property");
        }
        setOwner(buyer);
        buyer.setMoney(buyer.getMoney() - getPrice());

        System.out.println(buyer + " bought " + this);
	}
	public void buy() throws IllegalActionException {
        buy(getBoard().getGame().getCurrentPlayer());
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
                "group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", houseLevel=" + houseLevel +
                ", propertyPrice=" + propertyPrice +
                ", houseRents=" + Arrays.toString(houseRents) +
                ", owner=" + owner +
                '}';
    }
}