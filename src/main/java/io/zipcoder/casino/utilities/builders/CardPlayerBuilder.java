package io.zipcoder.casino.utilities.builders;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.CardPlayer;

public class CardPlayerBuilder {
    private String name;
    private String password;
    private int age;
    private Wallet wallet;

    public CardPlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CardPlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public CardPlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public CardPlayerBuilder setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public CardPlayer createCardPlayer() {
        return new CardPlayer(name, password, age, wallet);
    }
}