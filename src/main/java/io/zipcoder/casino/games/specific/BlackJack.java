package io.zipcoder.casino.games.specific;

import com.sun.xml.internal.xsom.impl.SchemaImpl;
import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.BlackJackPlayer;
import io.zipcoder.casino.players.CardPlayer;
import io.zipcoder.casino.players.Dealer;
import io.zipcoder.casino.utilities.io.ConsoleServices;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class BlackJack extends Game implements CardGame {

    private ArrayList<Chip> bets = new ArrayList<>();
    private Deck gameDeck;
    private BlackJackPlayer currentPlayer;
    private Dealer opponent;
    private Chip placeBet;
    private int gameDrawAmt;
    private PlayingCard card;
    private int value;
    private boolean playerTurn;
    private boolean findWinner;

    public BlackJack(){

    }

    public BlackJack(int drawAmt, Chip placeBet, boolean playerGoesFirst, boolean whoWon){
        this.gameDeck = new Deck(156);
        this.gameDrawAmt = drawAmt;
        this.placeBet = placeBet;
        this.playerTurn = playerGoesFirst;
        this.findWinner = whoWon;
    }


    public void newDeal() {

        bets.add(placeBet);
        for (int i = 0; i < 2 ; i++) {
            if (i%2 == 0){
           this.currentPlayer.getHand().addAll(
                   this.gameDeck.draw(1));}
        }
        //else { this.opponent.getHand().addAll(this.gameDeck.draw(1);}
        //asks player to place bet;
        //deal 2 cards to each player


    }
    public int getValue() {
        int handTotal = 0;
        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            if (card.getValueAsInt() > 10) {
                value = 10;
            } else if (card.getValueAsInt() == 1) {
                value = 11;
            } else {
                value = card.getValueAsInt();
            }
            handTotal += value;
        }
       return handTotal;
   }

    @Override
    public void runGame() {
        App.updatePlayer(this);
        this.currentPlayer = (BlackJackPlayer) App.getCurrentPlayer();
        this.opponent = new Dealer();
        Boolean playerWon = false;
        Boolean gameOver = false;

        // game logic
        newDeal();
        getValue();
        while (!gameOver) {
            if (this.playerTurn)
            {
                ConsoleServices.print("Cards in hand: " + this.currentPlayer.printHand());
                System.out.println("Your hand value is: "+ getValue());
                System.out.println("The dealers' hand value is: "+ this.opponent.getHandValue());
                String input = ConsoleServices.getStringInput("Would you like to Hit or Stay? ");
                String hitOrStay = "";
                hitOrStay = (input.toLowerCase());
                if (hitOrStay.equals("hit")) {
                    this.gameDeck.draw(1);
                }
                if (hitOrStay.equals("Stay")){ ConsoleServices.print("It's the dealers turn now."); }
                this.playerTurn = false;
            }

            // Opponent turn
            else
            {
                if (this.opponent.isHitting()){
                    this.opponent.hit(1);
                    System.out.println("Dealers' hand value is: "+ this.opponent.getHandValue());
                }
                else {System.out.println("Lets see who won!");}
                this.findWinner = true;
            }

            // PLACEHOLDER TO MAKE PLAYABLE - REMOVE
            if (this.findWinner) {
                if(getValue() < 22 && getValue() > this.opponent.getHandValue()) {
                    playerWon = true;
                    gameOver = true;
                }
               else playerWon = false;
                System.out.println("Sorry you lost!");
                gameOver = true;
            }
        }



        //ask player to hit, stand, split, doubleDown
        //reveal dealers hand, if dealer is < 16 hit, if dealer is >=17 stand
        //if dealer isbust || player hand > dealer, Player wins

        StatTracker.finishGame(this, playerWon);
    }
}
