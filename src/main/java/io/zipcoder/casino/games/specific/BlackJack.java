package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.BlackJackPlayer;
import io.zipcoder.casino.players.Dealer;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.ArrayList;

public class BlackJack extends Game implements CardGame {

    private ArrayList<Chip> bets;
    private boolean isPlayerBust;
    private int value;
    private Deck deck;
    Dealer dealer;
    BlackJackPlayer player;

    public void newDeal() {

        deck.draw(2);
        //asks player to place bet;
        //deal 2 cards to each player
        //1 face up, 1 face down to dealer

    }
   /* public int getValue(){
        for (int i =0; i < hand.size(); i++;{
            if (value1 >10){
                value = 10;
        }
            else if (value == 1){
                 value = 11;
        }
            else {
                 value = Rank;
        }}
        return value;
    }*/

    @Override
    public void runGame() {
        App.updatePlayer(this);
        BlackJackPlayer currentPlayer = (BlackJackPlayer) App.getCurrentPlayer();
        Boolean playerWon = false;

        // game logic
        //newDeal
        newDeal();
       // player.getHandValue;
        //get value of players hand
        //while(player.handValue < 21){
        // if(player.getHand[0] == player.getHand[1]{
        // does player want to split?}
       // if(player.getHandValue > 21){
            //does player want to hit || stand
       // }}
        //

        //reveal dealers hand, if dealer is < 16 hit, if dealer is >=17 stand
        //if dealer isbust || player hand > dealer, Player wins

        StatTracker.finishGame(this, playerWon);
    }
}
