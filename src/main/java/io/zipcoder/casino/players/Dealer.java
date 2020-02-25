package io.zipcoder.casino.players;

import javax.smartcardio.Card;

public class Dealer {

    private int handValue;
    private Card unknownValue;

    public int hit() {
        return 0;
    }

    public boolean isHitting() {
        return false;
    }

    public int getHandValue() {
        return handValue;
    }

    public Card getUnknownValue() {
        return unknownValue;
    }
}
