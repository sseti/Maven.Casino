package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.PlayingCard;

import java.util.ArrayList;

public class BlackJackPlayer extends CardPlayer {

    private ArrayList<PlayingCard> splitHand;
    private int handValue;
    private int splitValue;

    public int hit(Player p) {
        return 0;
    }

    public void doubleDown() {

    }

    public boolean split() {
        return false;
    }
}
