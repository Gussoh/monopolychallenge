package org.digit.monopolychallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gussoh on 17/10/15.
 */
public class Game {

	private Board board;
	private List<Player> players;
	private List<Player> bidders;
	private Player currentPlayer;

	public Game(List<Player> players) {
		this.players = players;
		this.bidders = new ArrayList<Player>();
	}

	protected void play() {
		boolean gameEnded = false;

		while (!gameEnded) {
			int playersAlive = 0;
			for (Player p : players) {
				currentPlayer = p;
				System.out.println(p+"'s turn");
				if (p.isAlive()) {
					playersAlive++;
					int newPosition = p.getPosition() + rollDice();

					// check if player went past start and give money if so.
					if (newPosition >= board.getTiles().size()) {
						// user passed GO! - give money!
						p.setMoney(p.getMoney() + 100);
						newPosition %= board.getTiles().size();
					}

					p.setPosition(newPosition);
					Tile currentTile = board.getTiles().get(p.getPosition());

					if (currentTile instanceof PropertyTile) {

						PropertyTile property = ((PropertyTile)currentTile);

						// check if the player have to pay to another player
						Player tileOwner = property.getOwner();
						if (tileOwner != null && tileOwner != p) { // make money transaction
							tileOwner.setMoney(tileOwner.getMoney() + property.getRent());
							p.setMoney(p.getMoney() - property.getRent());
							System.out.println(currentPlayer + " stepped on " + currentTile + " and had to pay rent.");
						}
						p.yourTurn(this, board, currentTile);

						// check if the player did not choose to buy this property
						if(property.getOwner() == null){
							startBidding(property);
						}
					}

					if (!p.isAlive()) { // if the player is dead, remove all owned properties
						for (Tile t : board.getTiles()) {
							if (t instanceof PropertyTile) {
								if (((PropertyTile) t).getOwner() == p) {
									((PropertyTile) t).setOwner(null);
								}
							}
						}
					}
				}
			}
			if (playersAlive < 2) {
				gameEnded = true;
			}
			System.out.println("Current players: " + players);
		}
		Player winner = null;
		for (Player p : players) {
			if (p.isAlive()) {
				winner = p;
			}
		}
		System.out.println("Game ended, " + winner + " won.");
	}

	// Starts a bidding
	private void startBidding(PropertyTile property) {
		bidders.clear();
		bidders.addAll(players);
		// Exclude the player that did't want to buy the property from the bidding
		// TODO Should the player be able to change his/her mind and bid?
		bidders.remove(getCurrentPlayer());
		if(bidders.isEmpty()){
			return;
		}
		System.out.println("Bidding started");
		int currentPrice = property.getPrice() - 1;
		Player topBidder = null;

		while(!bidders.isEmpty()){
			boolean noOneWantsIt = true;
			Iterator<Player> i = bidders.iterator();
			while (i.hasNext()) {
				Player bidder = i.next(); // must be called before you can call i.remove()
				if(bidder.getMoney() < currentPrice){
					i.remove();
				}
				if(bidder == topBidder){
					System.out.println("The bid was won by: " + topBidder);
					try {
						property.buy(topBidder);
					} catch (IllegalActionException e) {
						e.printStackTrace();
					}
					bidders.clear();
					noOneWantsIt = false;
					break;
				}
				int bid = bidder.onBidding(this, property, currentPrice);
				if(bid <= bidder.getMoney() && bid > currentPrice){
					noOneWantsIt = false;
					currentPrice = bid;
					topBidder = bidder;
				}
			}
			if(noOneWantsIt){
				System.out.println("No one wanted to bid");
				break;
			}
		}
		bidders.clear();
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

	protected void setBoard(Board board) {
		this.board = board;
	}

	// Return all players in a new array
	public List<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}

	// Returns all bidders in a new array
	public List<Player> getBidders() {
		return new ArrayList<Player>(bidders);
	}
}
