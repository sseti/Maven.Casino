package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class LoopyDicePlayer extends DicePlayer  {

    // For tests
    public LoopyDicePlayer(String name) {
        super(name);
    }

    public LoopyDicePlayer(String name, String password, Wallet wallet) {
        super(name, password, wallet);
    }

    public LoopyDicePlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getWallet());
    }

}
