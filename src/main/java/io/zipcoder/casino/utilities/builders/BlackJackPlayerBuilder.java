package io.zipcoder.casino.utilities.builders;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.BlackJackPlayer;

public class BlackJackPlayerBuilder {
    private String name;
    private String password;
    private Wallet wallet;

    public BlackJackPlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BlackJackPlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public BlackJackPlayerBuilder setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public BlackJackPlayer createBlackJackPlayer() {
        return new BlackJackPlayer(name, password, wallet);
    }
}