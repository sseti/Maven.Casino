package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;

import java.util.ArrayList;
import java.util.Collections;

public class CardPlayer extends Player {

    private ArrayList<PlayingCard> hand;

    // For tests
    public CardPlayer(String name) {
       super(name);
       this.hand = new ArrayList<>();
    }

    public CardPlayer(String name, String password, Wallet wallet) {
        super(name, password, wallet);
        this.hand = new ArrayList<>();
    }

    public CardPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getWallet());
        this.hand = new ArrayList<>();
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public void addCardToHand(PlayingCard card) {
        this.hand.add(card);
    }

    public void removeCard(PlayingCard card) {
        this.hand.remove(card);
    }

    public String printHand() {
        String toRet = "";
        Collections.sort(this.getHand());
        for (PlayingCard card : this.getHand()) {
            toRet += card.getValue() + ", ";
        }
        toRet = toRet.substring(0, toRet.length() - 2);
        return toRet;
    }
}
