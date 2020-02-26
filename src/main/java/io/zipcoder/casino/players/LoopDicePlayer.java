package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class LoopDicePlayer extends DicePlayer  {

    private int bustValue;
    private int score;

    // For tests
    public LoopDicePlayer(String name) {
        super(name);
    }

    public LoopDicePlayer(String name, String password, Wallet wallet) {
        super(name, password, wallet);
    }

    public LoopDicePlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getWallet());
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
