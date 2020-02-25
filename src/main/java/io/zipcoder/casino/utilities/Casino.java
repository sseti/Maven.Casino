package io.zipcoder.casino.utilities;


import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.players.Player;

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

}
