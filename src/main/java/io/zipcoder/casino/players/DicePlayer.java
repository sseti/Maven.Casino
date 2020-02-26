package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Dice;
import io.zipcoder.casino.models.Wallet;

import java.util.ArrayList;

public class DicePlayer extends Player {
    private ArrayList<Dice> dice = new ArrayList<>();

    public DicePlayer(String name, String password, int age, Wallet wallet) {
        super(name, password, age, wallet);
    }

    public DicePlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getAge(), player.getWallet());
    }

    public int rollDice() {
        return 0;
    }

}
