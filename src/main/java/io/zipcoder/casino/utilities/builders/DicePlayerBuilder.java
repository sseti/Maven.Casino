package io.zipcoder.casino.utilities.builders;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.DicePlayer;

public class DicePlayerBuilder {
    private String name;
    private String password;
    private Wallet wallet;

    public DicePlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DicePlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public DicePlayerBuilder setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public DicePlayer createDicePlayer() {
        return new DicePlayer(name, password, wallet);
    }
}