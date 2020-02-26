package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.players.GoFishPlayer;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import javax.smartcardio.Card;

public class GoFish extends Game implements CardGame {


    public boolean pollCard(Card card, Player playerToPoll) {
        return false;
    }

    public boolean getCardFromPlayer(Card card, Player playerToPullFrom) {
        return false;
    }


    @Override
    public void runGame() {
        App.updatePlayer(this);
        GoFishPlayer currentPlayer = (GoFishPlayer) App.getCurrentPlayer();
        Boolean playerWon = false;

        // game logic

        StatTracker.finishGame(this, playerWon);
    }
}
