package io.zipcoder.casino.models;

import io.zipcoder.casino.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private int dollars;
    private Map<Chip, Integer> chips = new HashMap<>();
    private Player owner;

    public Wallet() {
        this(0);
    }

    public Wallet(int dollars) {
        this.dollars = dollars;
    }

    public boolean addDollar(int amt) {
        dollars += amt;
        return false;
    }
    public boolean addAllChips(ArrayList<Chip> chips1){
        return false;
    }

    public boolean addChip(Chip chip) {
        if (!chips.containsKey(chip)){
            chips.put(chip, 1);
        }
        else if (chips.containsKey(chip)) {
            chips.put(chip,chips.get(chip)+1);
                    }

        return false;
    }

    public boolean subDollar(int amt) {
        dollars -= amt;
        return false;
    }

    public boolean subChip(Chip chip) {
        if (chips.containsKey(chip)){
            chips.put(chip,chips.get(chip)-1);
        }

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
