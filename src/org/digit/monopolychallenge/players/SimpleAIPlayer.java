package org.digit.monopolychallenge.players;

import java.util.Collections;
import java.util.List;

import org.digit.monopolychallenge.*;

/**
 * Created by gussoh on 18/10/15.
 */
public class SimpleAIPlayer extends Player {

	public SimpleAIPlayer(Game game) {
		super(game, "Simple AI player");
	}

	@Override
	public void yourTurn(Game game, Board board, Tile tile) {
		// Strategy: Buy if you can bye (or try to even if you can't)
		if (tile instanceof PropertyTile) {
			try {
				((PropertyTile) tile).buy();
			} catch (IllegalActionException e) {
				// failed to buy
			}
		}
	}

	@Override
	public void onBroke(Game game, Board board) {
		// Strategy: Sort on rent value, to sell the one with the lowest rent if someone steps on it
		List<PropertyTile> ownedProperties = game.getProperties(this);
		if(!ownedProperties.isEmpty()){
			Collections.sort(ownedProperties, (p0, p1) -> Integer.compare(p0.getRent(), p1.getRent()));
			try {
				ownedProperties.get(0).sell();
			} catch (IllegalActionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int onBidding(Game game, Tile tile, int currentPrice) {
		// Strategy: Bid as long as you have the possibility to outbid everyone
		boolean canOutbidAllBidders = true;
		for(Player bidder : game.getBidders()){
			if(bidder.getMoney() > getMoney()){
				canOutbidAllBidders = false;
			}
		}
		return canOutbidAllBidders ? currentPrice + 1 : 0;
	}
}