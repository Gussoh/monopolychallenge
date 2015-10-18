package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public abstract class Player {

    private int money = 200;
    private String name;
    private int position;

    // Constructs a player from another player
    protected Player(Player other) {
        this.name = other.name;
        this.money = other.money;
        this.position = other.position;
    }
    
    protected Player(String name) {
        this.name = name;
    }

    /**
     * You may choose to buy the property, buy houses or sell stuff if you would like.
     * @param game
     * @param board
     * @param tile
     */
    public abstract void yourTurn(Game game, Board board, Tile tile);

    /**
     * check how much money you own by looking at your money
     * @param game
     * @param board
     */
    public abstract void onBroke(Game game, Board board);

    /**
     *  You are not allowed to do anything but the bidding.
     *  // TODO: fix this
     * @param game
     * @param tile
     * @param currentPrice
     * @return your bid, any bid less or equal than the current bid means that you would not like to raise the bid
     */
    public abstract int onBidding(Game game, Tile tile, int currentPrice);

    /**
     * When someone visits your property
     * @return true if you would like to collect the rent
     */
    public boolean onPropertyVisit() {
        return true;
    }

    public boolean isAlive() {
        return money >= 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    protected void setMoney(int money) {
        this.money = money;
    }

    protected void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

}
