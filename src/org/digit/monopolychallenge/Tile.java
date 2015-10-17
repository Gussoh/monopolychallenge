package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public abstract class Tile {

    private Board board;
	private String name;

	protected Tile(Board board, String name) {
        this.board = board;
		this.name = name;
	}

    public String getName(){
    	return this.name;
    }

    public Board getBoard() {
        return board;
    }
}
