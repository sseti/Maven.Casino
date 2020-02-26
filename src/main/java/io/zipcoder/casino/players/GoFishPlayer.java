package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

import javax.smartcardio.Card;

public class GoFishPlayer extends CardPlayer {

    private int pairs;

    // For tests
    public GoFishPlayer(String name) {
        super(name);
    }

    public GoFishPlayer(String name, String password, Wallet wallet) {
        super(name, password, wallet);
    }

    public GoFishPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getWallet());
    }

    public boolean hasCard(Card card) {
        return false;
    }

    public void goFish() {

    }

}
