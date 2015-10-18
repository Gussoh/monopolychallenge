package org.digit.monopolychallenge;

import org.digit.monopolychallenge.players.DumbAIPlayer;
import org.digit.monopolychallenge.players.SimpleAIPlayer;

import java.io.FileNotFoundException;

/**
 * Created by gussoh on 18/10/15.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    	Game game = new Game();
        game.addPlayer(new SimpleAIPlayer(game));
        game.addPlayer(new DumbAIPlayer(game));
        game.setBoard(BoardLoader.load(game, "res/chalmers.text"));
        game.play();
    }
}
