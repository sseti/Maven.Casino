package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.players.BlackJackPlayer;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.ArrayList;

public class BlackJack extends Game implements CardGame {

    private ArrayList<Chip> bets;
    private boolean isPlayerBust;

    public void newDeal() {

    }

    @Override
    public void runGame() {
        App.updatePlayer(this);
        BlackJackPlayer currentPlayer = (BlackJackPlayer) App.getCurrentPlayer();
        Boolean playerWon = false;

        // game logic

        StatTracker.finishGame(this, playerWon);
    }
}
