package io.zipcoder.casino.utilities.builders;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.Player;

public class PlayerBuilder {
    private String name;
    private String password;
    private int age;
    private Wallet wallet;

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public PlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public Player createPlayer() {
        return new Player(name, password, age, wallet);
    }
}