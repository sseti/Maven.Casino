package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.BettingArea;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.CrapsTable;
import io.zipcoder.casino.players.DicePlayer;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.Map;

public class Craps extends Game implements DiceGame {

    private CrapsTable table;
    private Map<Chip, BettingArea> crapsMap;

    /*
    Craps logic
      roll dice(2)
      bets
      (before first roll)
      PassLine
      7 or 11; win (reset)
      2 or 3; lose (rest
      12; push
      Don't Pass
      2 or 3; win (reset)
      12; push
      7 or 11; lose
      (come-out roll)
      first roll = set point;
      Second roll =
      Come bet
      if roll = point; win
      if roll = 7; lose
      Don't Come
      if roll = 2 or 3; win
      if roll = 12; push
      if roll = 7; win
      if roll = point; lose
     */

    @Override
    public void runGame() {
        App.updatePlayer(this);
        DicePlayer currentPlayer = (DicePlayer) App.getCurrentPlayer();
        Boolean playerWon = false;

        // game logic

        StatTracker.finishGame(this, playerWon);
    }
}
