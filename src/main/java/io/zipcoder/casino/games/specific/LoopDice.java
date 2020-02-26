package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.players.LoopDicePlayer;
import io.zipcoder.casino.utilities.persistence.StatTracker;

public class LoopDice extends Game implements DiceGame {

    private int playerNumDice;
    private int opponentNumDice;

    @Override
    public void runGame() {
        App.updatePlayer(this);
        LoopDicePlayer currentPlayer = (LoopDicePlayer) App.getCurrentPlayer();
        Boolean playerWon = false;


        // print starting dice situation
        // print instructions ("enter roll to roll the next round")
        // print next round
        // repeat until winner is decided


        StatTracker.finishGame(this, playerWon);
    }
}
