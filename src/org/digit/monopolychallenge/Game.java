package org.digit.monopolychallenge;

import java.util.List;

/**
 * Created by gussoh on 17/10/15.
 */
public class Game {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players) {
        this.players = players;

    }

    protected void play() {
        boolean gameEnded = false;

        while (!gameEnded) {
            for (Player p : players) {
                currentPlayer = p;
                int playersAlive = 0;
                if (p.isAlive()) {
                    playersAlive++;
                    int newPosition = p.getPosition() + rollDice();
                    if (newPosition > board.getTiles().size()) {
                        // user passed GO! - give money!
                        p.setMoney(p.getMoney() + 100);
                        newPosition %= board.getTiles().size();
                    }
                    p.setPosition(newPosition);
                    // check if player went past start and give money if so.
                    Tile currentTile = board.getTiles().get(p.getPosition());

                    // calculate if the player have to pay to another player
                    if (currentTile instanceof PropertyTile) {
                        Player tileOwner = ((PropertyTile) currentTile).getOwner();
                        if (tileOwner != null && tileOwner != p) { // make money transaction
                            tileOwner.setMoney(tileOwner.getMoney() + ((PropertyTile) currentTile).getRent());
                            p.setMoney(p.getMoney() - ((PropertyTile) currentTile).getRent());
                        }
                        p.yourTurn(this, board, currentTile);
                    }
                }
                if (playersAlive < 2) {
                    gameEnded = true;
                }
            }
        }
        Player winner = null;
        for (Player p : players) {
            if (p.isAlive()) {
                winner = p;
            }
        }
        System.out.println("Game ended, " + winner + " won.");
    }

    public static int rollDice() {
        return (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", players=" + players +
                ", currentPlayer=" + currentPlayer +
                '}';
    }
}
