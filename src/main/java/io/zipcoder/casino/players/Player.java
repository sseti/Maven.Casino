package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private String password;
    private int age;
    private Wallet wallet;

    public Player(String name, String password, int age, Wallet wallet) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.wallet = wallet;
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

    public String getPassword() { return password; }
}
