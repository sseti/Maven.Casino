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
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Craps extends Game implements DiceGame {

    private DicePlayer currentPlayer;


    public Craps() {

    }


    @Override
    public void runGame() {

        int amount = 200;

        ConsoleServices.print("Welcome to the craps table, you have $200 to bet");
        //Integer input = ConsoleServices.getIntegerInput("Please input the amount you want to bet, or bet 0 to exit");
        Random g = new Random();
        int startAmount = 200;
        int dice1;
        int dice2;
        int totalRoll;
        int keyNum;
        int win;
        int bet;
        //int input = 5;
        bet = getBet(startAmount);

        while (bet > 0) {
            dice1 = rollDie(g);                        // roll both die and store sum in roll
            dice2 = rollDie(g);
            totalRoll = dice1 + dice2;
            keyNum = totalRoll;
            output(dice1, dice2, totalRoll);                // output result of roll

            win = didYouWin(totalRoll, keyNum, 1);            // didYouWin returns 1 if you won, -1 if you lost, 0 if neither
            while (win != 1 && win != -1)                // if you didn't win or lose, roll is your mark, continue
            {                                        //    until you win or lose (get mark or 7)
                //keyNum = totalRoll;                        // remember your first roll
                dice1 = rollDie(g);
                dice2 = rollDie(g);
                totalRoll = dice1 + dice2;
                output(dice1, dice2, totalRoll);                // output result of roll
                win = didYouWin(totalRoll, keyNum, 2);        // test for win (did you roll a mark or 7?)
            }
            amount = updateAmount(win, bet, amount);    // update amount based on your bet and whether you won or lost
            if (amount > 0) {

                bet = getBet(amount);        // if you still have money to gamble, get next bet
            }
            else                                        // but if amount is 0, you have to leave
            {
                System.out.println("You lost all your money, sorry but you can't play any more");
                bet = 0;
            }
        }
        outputResult(amount);
    }



    // get user's bet between 0 (quit) or 1..amount (legal bet) and data verify - don't let user enter a negative or a value > amount
    public static int getBet(int totalAmount)
    {
        int bet;
        do{

            System.out.print("How much do you want to bet?  It can't be more than " + totalAmount + " or less than 1. ");
            Integer input = ConsoleServices.getIntegerInput("Enter 0 to exit ");
            bet = input;
        }while(bet<0||bet>totalAmount);
        return bet;
    }

    // output result of the current roll
    public static void output(int dice1, int dice2, int totalRoll)
    {
        System.out.println("Your roll is " + dice1 + " and " + dice2 + " for a total of " + totalRoll);
    }

    // generate a random 6-sided die roll using the Random number generator
    public static int rollDie(Random r)
    {
        return r.nextInt(6)+1;
    }

    // if first roll, did the user win (7/11) then return 1 or lose (2/3/12) then return -1 otherwise return 0 to indicate
    //   neither a winning or losing roll
    // if not first roll, did the user win (roll==mark) then return 1 or lose (roll==7) then -1 else 0 to continue
    public static int didYouWin(int roll, int keyNum, int turn)
    {
        if(turn==1)				// first turn, check, for 7/11 for a winning first roll
            if(roll==7||roll==11)
            {
                System.out.println("First roll winner!");
                return 1;
            }
            else if(roll==2||roll==3||roll==12)	// or craps for a losing first roll
            {
                System.out.println("Craps, you lose");
                return -1;
            }
            else {
                //keyNum = roll;
                System.out.println("The number you need to roll again is a " + keyNum);
                return 0;
            }// otherwise if first roll then continue playing, roll becomes the mark
        else				// else not first roll
            //System.out.println("keynum" + keyNum);
            //System.out.println("roll" + roll);
            if(roll==keyNum)			// was the new roll the mark? if so user wins
            {
                System.out.println("You hit your mark!");
                return 1;
            }
            else if(roll==7)		// else if new roll was 7, user loses
            {
                System.out.println("You lost you rolled a 7");
                return -1;
            }
            else return 0;			// otherwise new roll was neither mark nor 7, continue rolling
    }

    public static int updateAmount(int win, int bet, int amount)	// based on bet and win/loss, update amount
    {
        if(win==1)
        {
            amount+=bet;
            System.out.println("You won $" + bet + " and now have $" + amount);
        }
        else
        {
            amount-=bet;
            System.out.println("You lost $" + bet + " and now have $" + amount);
        }
        return amount;
    }

    public static void outputResult(int amount)		// output the results of the game
    {
        if(amount>200) System.out.println("You have $" + amount + " so you won $" + (amount - 200));
        else if(amount==200) System.out.println("You broke even, thanks for playing");
        else if(amount>0) System.out.println("You lost money, sorry, but you still walk away with $" + amount);
        else System.out.println("Wow, you lost it all, maybe you shouldn't gamble!");
    }

}



