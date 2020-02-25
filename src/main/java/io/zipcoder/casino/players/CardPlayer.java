package io.zipcoder.casino.players;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class CardPlayer extends Player {

    private ArrayList<Card> hand;

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public void removeCard(Card card) {
        this.hand.remove(card);
    }
}
