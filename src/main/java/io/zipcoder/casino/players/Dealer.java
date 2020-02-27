package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.utilities.MenuStrings;

import java.util.ArrayList;


public class Dealer{

    private int handValue = 0;
    private PlayingCard unknownValue;
    private String name;
    ArrayList<PlayingCard> hand;

    public Dealer() {
        this(MenuStrings.randomIdentifier());
    }

    public Dealer(String name) {
        this.name = name;
    }

    public int hit(int amt) {
        return 0;
    }

    public boolean isHitting() {
        return false;
    }

    public int getHandValue() {
        return handValue;
    }

    public PlayingCard getUnknownValue() {
        return unknownValue;
    }
}
