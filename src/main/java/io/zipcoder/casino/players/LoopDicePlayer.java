package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class LoopDicePlayer extends DicePlayer  {

    private int bustValue;
    private int score;

    public LoopDicePlayer(String name, String password, int age, Wallet wallet) {
        super(name, password, age, wallet);
    }

    public LoopDicePlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getAge(), player.getWallet());
    }

    public void incrementDice() {

    }

    public void incrementScore() {

    }

    public void resetDice() {

    }

    public void setBustValue(int newBust) {

    }

}
