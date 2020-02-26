package io.zipcoder.casino.models;


import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.games.specific.BlackJack;
import io.zipcoder.casino.games.specific.Craps;
import io.zipcoder.casino.games.specific.GoFish;
import io.zipcoder.casino.games.specific.LoopDice;
import io.zipcoder.casino.players.*;

import java.util.Map;

public class Casino {

    private Map<String, Game> games;
    private Player currentPlayer;

    public void startGame(Game game) {

    }

    public Map<String, Game> getGames() {
        return games;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) { currentPlayer = player;}

    public void updateCurrentPlayer(Game currentGame) {
        if (currentGame instanceof BlackJack) {
           this.currentPlayer = new BlackJackPlayer(this.currentPlayer);
        } else if (currentGame instanceof Craps) {
            this.currentPlayer = new DicePlayer(this.currentPlayer);
        } else if (currentGame instanceof GoFish) {
            this.currentPlayer = new GoFishPlayer(this.currentPlayer);
        } else if (currentGame instanceof LoopDice) {
            this.currentPlayer = new LoopDicePlayer(this.currentPlayer);
        }
    }

}
