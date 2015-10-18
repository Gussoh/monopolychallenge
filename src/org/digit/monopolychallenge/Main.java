package org.digit.monopolychallenge;

import org.digit.monopolychallenge.players.DumbAIPlayer;
import org.digit.monopolychallenge.players.SimpleAIPlayer;
import org.digit.monopolychallenge.players.TerminalPlayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gussoh on 18/10/15.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Player> players = new ArrayList<Player>();
        players.add(new SimpleAIPlayer());
        players.add(new DumbAIPlayer());
        Game game = new Game(players);
        game.setBoard(BoardLoader.load(game, "res/chalmers.text"));
        game.play();
    }
}
