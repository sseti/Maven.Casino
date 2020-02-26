package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;

import java.util.ArrayList;

public class BlackJackPlayer extends CardPlayer {

    private ArrayList<PlayingCard> splitHand;
    private int handValue;
    private int splitValue;

    public BlackJackPlayer(String name, String password, int age, Wallet wallet) {
        super(name, password, age, wallet);
    }

    public BlackJackPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getAge(), player.getWallet());
    }

    public int hit(Player p) {
        return 0;
    }

    public void doubleDown() {

    }

    public boolean split() {
        return false;
    }
}
