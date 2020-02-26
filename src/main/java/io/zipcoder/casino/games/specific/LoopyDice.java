package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.LoopyDicePlayer;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.ConsoleServices;
import io.zipcoder.casino.utilities.io.MainConsole;
import io.zipcoder.casino.utilities.persistence.StatTracker;

public class LoopyDice extends Game implements DiceGame {

    private int playerScore = 0;
    private int opponentScore = 0;
    private int par = 3;
    private LoopyDicePlayer player;
    private LoopyDicePlayer opponent;

    public LoopyDice() {
        this(3);
    }

    public LoopyDice(int par) {
        this.par = par;
    }

    @Override
    public void runGame() {
        ConsoleServices.print("Let's get Loopy!");
        App.updatePlayer(this);
        this.player = (LoopyDicePlayer) App.getCurrentPlayer();
        this.opponent = new LoopyDicePlayer("Looper");
        this.player.addDice(3);
        this.opponent.addDice(3);

        ConsoleServices.print("Each player has 3 dice. Enter 'Roll' to calculate the next turn, or enter 'AutoRoll' to simulate the entire game.");
        while (!gameOver()) {
            String input = ConsoleServices.getStringInput("Enter 'Roll' to calculate the next turn, or enter 'AutoRoll' to simulate the entire game.");
            if (input.toLowerCase().equals("roll")) {
                if (loopyDiceTurnLogic()) {
                    return;
                }
            } else if (input.toLowerCase().equals("autoroll")) {
               while (!gameOver()) {
                   if (loopyDiceTurnLogic()) {
                       return;
                   }
               }
            } else {
                input = ConsoleServices.getStringInput("Bad command!\nEnter 'Roll' to calculate the next turn, or enter 'AutoRoll' to simulate the entire game.");
            }
        }

    }

    private boolean loopyDiceTurnLogic() {
        Boolean playerWon;
        runRound();
        if (gameOver() && playerIsWinner()) {
            playerWon = true;
            ConsoleServices.print("You won!");
            StatTracker.finishGame(this, playerWon);
            MainConsole console = new MainConsole();
            console.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
            return true;
        } else if (gameOver()) {
            playerWon = false;
            ConsoleServices.print("You lost!");
            StatTracker.finishGame(this, playerWon);
            MainConsole console = new MainConsole();
            console.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
            return true;
        }
        return false;
    }

    public Boolean playerIsWinner() {
        return (this.playerScore < this.par && this.opponentScore >= this.par) ? true : false;
    }

    public Boolean gameOver() {
        if (this.playerScore >= this.par || this.opponentScore >= this.par) {
            return true;
        }
        return false;
    }

    public void runRound() {
        int playerSum = player.rollDice();
        int oppSum = opponent.rollDice();
        int playerBustVal = 15 + (2 * (player.getNumDice() - 3));
        int oppBustVal = 15 + (2 * (opponent.getNumDice() - 3));
        if (playerSum > playerBustVal || oppSum > oppBustVal) {
            if (playerSum > playerBustVal) {
                player.emptyDice();
                player.addDice(3);
                this.playerScore++;
                int neededToLose = this.par - this.playerScore;
                ConsoleServices.print("You busted with a roll of " + playerSum + "!\nYou have scored 1 point. Score " + neededToLose + " more points and you lose!");
            }

            if (oppSum > oppBustVal) {
                opponent.emptyDice();
                opponent.addDice(3);
                this.opponentScore++;
                int neededToLose = this.par - this.opponentScore;
                ConsoleServices.print("You busted with a roll of " + playerSum + "!\nYou have scored 1 point. Score " + neededToLose + " more points and you lose!");
            }
        } else {
            if (playerSum > oppSum) {
                player.addDice(1);
                ConsoleServices.print("You rolled a higher number than the opponent (" + playerSum + ")!\nYou have gained 1 additional die.");
            } else if (oppSum > playerSum) {
                opponent.addDice(1);
                ConsoleServices.print("The opponent rolled a higher number than you (" + oppSum + ")!\nThey have gained 1 additional die.");
            } else {
                ConsoleServices.print("Both players rolled the same result! Tie! No dice added.");
            }
        }
    }

}
