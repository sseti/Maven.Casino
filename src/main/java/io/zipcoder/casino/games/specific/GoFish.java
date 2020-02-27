package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.CardPlayer;
import io.zipcoder.casino.players.GoFishNPC;
import io.zipcoder.casino.players.GoFishPlayer;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.ConsoleServices;
import io.zipcoder.casino.utilities.io.MainConsole;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GoFish extends Game implements CardGame {

    private GoFishPlayer currentPlayer;
    private GoFishNPC opponent;
    private Deck gameDeck;
    private boolean playerTurn;
    private int playerPairs;
    private int opponentPairs;
    private int gameDrawAmt;

    public GoFish() {
        this(0, true, 1);
    }

    public GoFish(int drawAmt) {
        this(0, true, drawAmt);
    }

    public GoFish(boolean playerGoesFirst) {
        this(0, playerGoesFirst, 1);
    }

    public GoFish(boolean playerGoesFirst, int drawAmt) {
        this(0, playerGoesFirst, drawAmt);
    }

    public GoFish(int handicap, boolean playerGoesFirst, int drawAmt) {
        this.gameDeck = new Deck();
        this.playerTurn = playerGoesFirst;
        this.playerPairs = handicap;
        this.opponentPairs = 0;
        this.gameDrawAmt = drawAmt;
    }


    public boolean pollCard(PlayingCard card, CardPlayer playerToPoll) {
        return (playerToPoll.getHand().size() > 0) ? playerToPoll.getHand().contains(card) : false;
    }

    public PlayingCard getCardFromPlayer(PlayingCard card, CardPlayer playerToPullFrom) {
        for (PlayingCard p : playerToPullFrom.getHand()) {
            if (p.equals(card)) {
                playerToPullFrom.getHand().remove(p);
                return card;
            }
        }
        return null;
    }

    @Override
    public void runGame() {
        App.updatePlayer(this);
        this.currentPlayer = (GoFishPlayer) App.getCurrentPlayer();
        this.opponent = new GoFishNPC();
        this.currentPlayer.setGameDrawAmt(this.gameDrawAmt);
        this.opponent.setGameDrawAmt(this.gameDrawAmt);
        boolean playerWon = false;
        boolean gameOver = false;

        for (int i = 0; i < 10; i++) {
            if (i%2==0) {
                this.currentPlayer.
                        getHand().
                        addAll(
                                this.gameDeck.draw(1)); }
            else { this.opponent.getHand().addAll(this.gameDeck.draw(1)); }
        }

        ConsoleServices.print("Go Fish!");
        ConsoleServices.print(this.opponent.generateWelcomeMessage());

        // Game loop
        while (!gameOver) {

            // Player turn
            if (this.playerTurn)
            {
                ConsoleServices.print("Cards in hand: " + this.currentPlayer.printHand());
                String input = ConsoleServices.getStringInput("Enter the Rank value of the card you wish to fish for: ");
                Integer guessedNum = -1;
                try {
                    guessedNum = Integer.parseInt(input);
                } catch (NumberFormatException ex) { ConsoleServices.print("Please enter a card to fish for by number!"); continue; }

                if (guessedNum > -1 && guessedNum < 14) {
                    PlayingCard polledCard = new PlayingCard(guessedNum);
                    boolean poll = pollCard(polledCard, this.opponent);
                    if (poll) {
                        ConsoleServices.print("Your opponent did have a " + polledCard.getValue() + "!");
                        this.currentPlayer.getHand().add(getCardFromPlayer(polledCard, this.opponent));
                    }
                    else { ConsoleServices.print("Go Fish!"); this.currentPlayer.goFish(this.gameDeck); }
                    this.playerTurn = false;
                } else { ConsoleServices.print("Please enter a card to fish for by number!"); }
            }

            // Opponent turn
            else
            {
                PlayingCard askCard = this.opponent.generateCardToAsk();
                ConsoleServices.print(this.opponent.getName() + ": Fishing for " + askCard.getValue());
                boolean poll = pollCard(askCard, this.currentPlayer);
                if (poll) {
                    ConsoleServices.print("You had that card! Your opponent has now taken it from you.");
                    this.opponent.getHand().add(getCardFromPlayer(askCard, this.opponent));
                }
                else { ConsoleServices.print("Go Fish!"); this.opponent.goFish(this.gameDeck); }
                this.playerTurn = true;
            }

            // PLACEHOLDER TO MAKE PLAYABLE - REMOVE
            if (this.currentPlayer.getHand().size() > 10 || this.opponent.getHand().size() > 10) {
                playerWon = this.currentPlayer.getHand().size() > this.opponent.getHand().size();
                gameOver = true;
            }
            // END PLACEHOLDER

            // tally up pairs for both players, see if somebody won, if not just let gameloop continue
            // if there is a winner, set gameOver = true, set playerWon to the correct value
        }


        if (playerWon) { ConsoleServices.print("You won!"); } else { ConsoleServices.print("You lost!"); }
        StatTracker.finishGame(this, playerWon);
        MainConsole console = new MainConsole();
        console.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
    }

}

// game logic
//       dealers deal players 7 cards
//       deal cards to 7 method


//        public static void main(String args[]){
//            int hand = 0;
//            CardPlayer player[] = new CardPlayer[];
//            for(int i = 0; i < 7; i++) {
//                for (int j = 0; j < 2; j++) {
//                    ArrayList<PlayingCard> c = new ArrayList<PlayingCard>();
//                    c = deck.draw(i);
//                    player[j].getHand();
//
//                }
//
//            }
//}



//       put remaining deck in center of playing field method


//       players put down matchingPairs dealt method

//       currentPlayer ==  activePlayer method

//                activePlayer asks opponent if have askedCard that matches in remaining hand
//                if activePlayer has opponent gives to activePlayer
//                    activePlayer puts matchingPairs down and continues
//                     activePlayer asks for another askedCard to match in hand
//                else if opponent doesnt have askedCard
//                        tells activePlayer  "go fish"
//                        activePlayer must draw card from deck
//                        if pulledCard matches askedCard, activePlayer can put
//                            down matchingPairs and say "got what i asked" and
//                            continue to be activePlayer
//                        else if pulledCard matches another card in hand activePlayer
//                                puts down matchingPairs and loses turn
//                else play goes to opponent
//         Once a player has 0 cards game over players count matchingPairs most wins



