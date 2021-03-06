package org.digit.monopolychallenge.players;

import org.digit.monopolychallenge.*;

import java.util.Scanner;

/**
 * Created by gussoh on 18/10/15.
 */
public class TerminalPlayer extends Player {

    public TerminalPlayer(Game game) {
    	super(game, "Terminal player");
    }

    @Override
    public void yourTurn(Game game, Board board, Tile tile) {
        System.out.println("It is your turn.");
        System.out.println("Board: " + board + ", tile: " + tile);

        if (tile instanceof PropertyTile) {
            System.out.println("Would you like to buy this property?");
            Scanner s = new Scanner(System.in);
            String yesno = s.nextLine();
            if (yesno.equalsIgnoreCase("yes") || yesno.equalsIgnoreCase("y")) {
                try {
                    ((PropertyTile) tile).buy();
                } catch (IllegalActionException e) {
                    System.out.println(e.getMessage());
                }
            }
            s.close();
        }

        System.out.println("No other actions impemented. End of turn.");
    }

	@Override
	public void onBroke(Game game, Board board) {
		// TODO Auto-generated method stub
	}

	@Override
	public int onBidding(Game game, Tile tile, int currentPrice) {
		// TODO Auto-generated method stub
		return 0;
	}
}
