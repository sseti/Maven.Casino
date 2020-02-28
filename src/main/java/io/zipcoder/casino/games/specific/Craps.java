package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.BettingArea;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.CrapsTable;
import io.zipcoder.casino.players.DicePlayer;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.ConsoleServices;
import io.zipcoder.casino.utilities.io.MainConsole;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Craps implements Game, DiceGame {

    private CrapsTable table;
    private Map<Chip, BettingArea> crapsMap;
    private ArrayList<String> dontPassInputs;
    private DicePlayer currentPlayer;

    public Craps() {
        this.table = new CrapsTable();
        this.crapsMap = new HashMap<>();
        this.dontPassInputs = new ArrayList<>();
        this.dontPassInputs.add("dont");
        this.dontPassInputs.add("don't");
        this.dontPassInputs.add("dont pass");
        this.dontPassInputs.add("don't pass");
        this.dontPassInputs.add("dont pass line");
        this.dontPassInputs.add("don't pass line");
    }

    public Boolean gameOver() {
        return false;
    }

    public Boolean playerIsWinner() {
        return false;
    }

    public void runRound() {

    }

    @Override
    public void runGame() {
        App.updatePlayer(this);
        this.currentPlayer = (DicePlayer) App.getCurrentPlayer();
        Boolean playerWon = false;
        currentPlayer.addDice(2);

        ConsoleServices.print("Welcome to the craps table");
        while (!gameOver()) {
            String input = ConsoleServices.getStringInput("Place bet. Choose Pass Line or Don't Pass Line");
            if (input.toLowerCase().equals("pass line") || input.toLowerCase().equals("pass")) {
                if (crapsLogic()) {
                    return;
                }
            } else if (this.dontPassInputs.contains(input.toLowerCase())) {
                if (crapsLogic()) {
                    return;
                }
            } else {
                ConsoleServices.getStringInput("Bad command!\nEnter 'Pass Line' to place a Pass Line bet, or enter 'Don't Pass' to place a Don't Pass Line bet.");
            }
        }
    }

    public boolean crapsLogic() {
        runRound();
        if (gameOver() && playerIsWinner()) {
            ConsoleServices.print("You won!");
            StatTracker.finishGame(this, true);
            MainConsole console = new MainConsole();
            console.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
            return true;
        } else if (gameOver()) {
            ConsoleServices.print("You lost!");
            StatTracker.finishGame(this, false);
            MainConsole console = new MainConsole();
            console.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
            return true;
        }
        return false;
    }

}

// initiate console
// create dice
// create craps player
// check player balance (wallet)
// get user input (What bet?)
// evaluate bet
// roll dice
// evaluate dice value


//    public int sumOfDice;
//    public enum gameStatus {Continue, Won, Lost};
//    public final int[] craps = {2, 3, 12};
//    public final int[] winningFirstRoll = {7, 11};
//    public int pointNumber = 0;
//
//// craps player constructor
//    public Craps(DicePlayer player) {
//    this.DicePlayer = new DicePlayer;
//    }
//// craps dice creator
//    public Dice[] createDice() {
//        Dice[] crapsDice = new Dice[2];
//        for (int i = 0; i < crapsDice.length; i++) {
//            crapsDice[i] = new Dice();
//        }
//        return crapsDice;
//    }
//
//
//    // before first roll
//    // get balance
//    // get String input (what bet?)
//    // evaluate bet (pass/dontPass)
//    // roll dice
//    // evaluate sumOfDice
//
//    public void passLine() {
//        if (sumOfDice == 7 || sumOfDice == 11) {
//            return gameStatus(Won);
//        } else if (sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12) {
//            return gameStatus(Lost);
//        } else if (sumOfDice == 12) {
//            return gameStatus(Continue);
//        }  else (sumOfDice == pointNumber) {
//              return Continue;
//        }
//        return Continue;
//    }
//
//    public void dontPassLine() {
//        if (sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12) {
//            return gameStatus(Won);
//        } else if (sumOfDice == 7 || sumOfDice == 11) {
//            return gameStatus(Lost);
//        } else (sumOfDice == pointNumber);
//        return gameStatus(Continue);
//    }
//
//    //after first roll
//
//    public void comeBet() {
//            if (sumOfDice == pointNumber) {
//                return gameStatus(Won);
//            } else if (sumOfDice == 7) {
//                return gameStatus(Lost);
//            }
//            return gameStatus(Continue);
//
//    }
//
//    public void dontCome() {
//            if (sumOfDice == 2 || sumOfDice == 3) {
//                return gameStatus(Won);
//            } else if (sumOfDice == 12) {
//                return gameStatus(Continue);
//            } else if (sumOfDice == 7) {
//                return gameStatus(Won);
//            } else if (sumOfDice == pointNumber) {
//                return gameStatus(Lost);
//            }
//            return gameStatus(Continue);
//    }
//}



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
      */


