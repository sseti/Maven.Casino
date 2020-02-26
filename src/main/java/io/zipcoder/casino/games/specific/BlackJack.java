package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.BlackJackPlayer;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.ArrayList;

public class BlackJack extends Game implements CardGame {

    private ArrayList<Chip> bets;
    private boolean isPlayerBust;
    private int value;
    Deck deck = new Deck();

    public void newDeal(int placeBet) {

        int bet = placeBet;
        deck.draw(2);
        //asks player to place bet;
        //deal 2 cards to each player
        //1 face up, 1 face down to dealer

    }
   /* public int getValue(){

        if (Rank >10){
            value = 10;
        }
        else if (Rank == 1){
            value = 11;
        }
        else {
            value = Rank;
        }
        return value;
    }*/

    @Override
    public void runGame() {
        App.updatePlayer(this);
        BlackJackPlayer currentPlayer = (BlackJackPlayer) App.getCurrentPlayer();
        Boolean playerWon = false;

        // game logic
        //newDeal
        //get value of players hand
        //ask player to hit, stand, split, doubleDown
        //reveal dealers hand, if dealer is < 16 hit, if dealer is >=17 stand
        //if dealer isbust || player hand > dealer, Player wins

        StatTracker.finishGame(this, playerWon);
    }
}
