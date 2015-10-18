package org.digit.monopolychallenge.players;

import org.digit.monopolychallenge.Board;
import org.digit.monopolychallenge.Game;
import org.digit.monopolychallenge.Player;
import org.digit.monopolychallenge.Tile;

/**
 * Created by gussoh on 18/10/15.
 */
public class DumbAIPlayer extends Player {
    public DumbAIPlayer(Game game) {
        super(game, "Dumb AI Player");
    }

    @Override
    public void yourTurn(Game game, Board board, Tile tile) {
		// TODO Auto-generated method stub
    }

	@Override
	public void onBroke(Game game, Board board) {
		// TODO Auto-generated method stub
	}

	@Override
	public int onBidding(Game game, Tile tile, int currentPrice) {
		// Always bid one more, even if we don't have the money
		return currentPrice + 1;
	}
}
