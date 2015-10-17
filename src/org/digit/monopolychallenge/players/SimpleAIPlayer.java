package org.digit.monopolychallenge.players;

import org.digit.monopolychallenge.*;

/**
 * Created by gussoh on 18/10/15.
 */
public class SimpleAIPlayer extends Player {


    public SimpleAIPlayer() {
        super("Simple AI player");
    }

    @Override
    public void yourTurn(Game game, Board board, Tile tile) {
        if (tile instanceof PropertyTile) {
            try {
                ((PropertyTile) tile).buy();
            } catch (IllegalActionException e) {
                // failed to buy
            }
        }
    }
}
