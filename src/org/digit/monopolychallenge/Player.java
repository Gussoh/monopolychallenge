package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public abstract class Player {

    private int money = 200;
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    public abstract void yourTurn(Game game, Board board, Tile tile);

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
