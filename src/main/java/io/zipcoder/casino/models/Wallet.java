package io.zipcoder.casino.models;

import io.zipcoder.casino.players.Player;

import java.util.Map;

public class Wallet {

    private int dollars;
    private Map<Chip, Integer> chips;
    private Player owner;

    public boolean addDollar(int amt) {
        return false;
    }

    public boolean addChip(Chip chip) {
        return false;
    }

    public boolean subDollar(int amt) {
        return false;
    }

    public boolean subChip(Chip chip) {
        return false;
    }

    public boolean subChip(int dollarAmt) {
        return false;
    }

    public int getDollars() {
        return dollars;
    }

    public Map<Chip, Integer> getChips() {
        return chips;
    }

    public Player getOwner() {
        return owner;
    }
}
