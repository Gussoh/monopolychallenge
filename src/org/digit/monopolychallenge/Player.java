package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public abstract class Player {

    int money;
    String name;
    int position;

   abstract void youTurn(Board board, Tile tile);
}
