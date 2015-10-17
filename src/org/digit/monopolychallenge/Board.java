package org.digit.monopolychallenge;

import java.util.List;

/**
 * Created by gussoh on 17/10/15.
 */
public class Board {

    private Game game;
	private List<Tile> tiles;
	
	protected Board(Game game){
		this.game = game;
	}
	
	public List<Tile> getTiles(){
		return this.tiles;
	}

    public Game getGame() {
        return game;
    }
}