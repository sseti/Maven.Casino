package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

import javax.smartcardio.Card;

public class GoFishPlayer extends CardPlayer {

    private int pairs;

    public GoFishPlayer(String name, String password, int age, Wallet wallet) {
        super(name, password, age, wallet);
    }

    public GoFishPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getAge(), player.getWallet());
    }

    public boolean hasCard(Card card) {
        return false;
    }

    public void goFish() {

    }

}
