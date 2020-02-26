package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class CardPlayer extends Player {

    private ArrayList<Card> hand;

    public CardPlayer(String name, String password, int age, Wallet wallet) {
        super(name, password, age, wallet);
    }

    public CardPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getAge(), player.getWallet());
    }

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
