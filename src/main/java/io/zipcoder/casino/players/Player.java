package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private int age;
    private Wallet wallet;

    public Player(String name, int age) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Player(String name, int age, Wallet wallet) {
        this.name = name;
        this.age = age;
        this.wallet = wallet;
    }
}
