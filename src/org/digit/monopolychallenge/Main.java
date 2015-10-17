package org.digit.monopolychallenge;

import org.digit.monopolychallenge.players.SimpleAIPlayer;
import org.digit.monopolychallenge.players.TerminalPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gussoh on 18/10/15.
 */
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        players.add(new SimpleAIPlayer());
        players.add(new TerminalPlayer());
        Game game = new Game(players);
        game.play();
    }
}
