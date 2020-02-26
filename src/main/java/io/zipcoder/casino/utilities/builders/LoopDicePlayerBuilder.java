package io.zipcoder.casino.utilities.builders;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.LoopyDicePlayer;

public class LoopDicePlayerBuilder {
    private String name;
    private String password;
    private Wallet wallet;

    public LoopDicePlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public LoopDicePlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public LoopDicePlayerBuilder setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public LoopyDicePlayer createLoopDicePlayer() {
        return new LoopyDicePlayer(name, password, wallet);
    }
}