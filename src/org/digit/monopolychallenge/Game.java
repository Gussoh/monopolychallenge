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
        while (!gameEnded) {
            for (Player p : players) {
                int playersAlive = 0;
                if (p.isAlive()) {
                    playersAlive++;
                    int newPosition = p.getPosition() + rollDice();
                    if (newPosition > board.getTiles().size()) {
                        // user passed GO! - give money!
                        newPosition %= board.getTiles().size();
                    }
                    p.setPosition(newPosition);
                    // check if player went past start and give money if so.
                    Tile currentTile = board.getTiles().get(p.getPosition());
                    // calculate if the player have to pay to another player

                    p.youTurn(this, board, currentTile);
                }
                if (playersAlive < 2) {
                    gameEnded = true;
                }
            }
        }
    }

    public static int rollDice() {
        return (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
    }

}
