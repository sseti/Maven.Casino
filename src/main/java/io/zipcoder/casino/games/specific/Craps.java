package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.BettingArea;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.CrapsTable;
import io.zipcoder.casino.models.Dice;
import io.zipcoder.casino.players.DicePlayer;

import java.util.Map;

public class Craps extends Game implements DiceGame {

    private CrapsTable table;
    private Map<Chip, BettingArea> crapsMap;

}

//    // public void sumOfDice(numberOfDice(2));
//    public enum Status {Continue, Won, Lost};
//    public final int[] craps = {2, 3, 12};
//    public final int[] winningFirstRoll = {7, 11};
//    public int pointNumber;
//
//
//    public Craps(DicePlayer player) {
//
//    }
//
//    public Dice[] createDice() {
//        Dice[] crapsDice = new Dice[2];
//        for (int i = 0; i < crapsDice.length; i++) {
//            crapsDice[i] = new Dice();
//        }
//        return crapsDice;
//    }
//}
//
//
//
//    public Bet comebet() {
//        if (sumOfDice == 7 || sumOfDice == 11) {
//            return (Won);
//        } else if (sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12) {
//            return (Lost);
//        } else if (sumOfDice == 12) {
//            return (Continue);
//        }
//
//    }
    /*Craps logic
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




    @Override
    public void runGame() {

    }
}
