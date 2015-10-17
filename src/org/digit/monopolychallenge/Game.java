package org.digit.monopolychallenge;

import java.util.List;

/**
 * Created by gussoh on 17/10/15.
 */
public class Game {

    Board board;
    List<Player> players;

    protected void play() {
        boolean gameEnded = false;
        for (Player p : players) {
            int playersAlive = 0;
            if (p.isAlive()) {
                p.setPosition((p.getPosition() + rollDice()) % board.getTiles().size());
                p.youTurn(this, board, board.getTiles().get(p.getPosition()));
            }
        }
    }

    public static int rollDice() {
        return (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
    }

}
