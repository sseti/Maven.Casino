package io.zipcoder.casino.games;

import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.utilities.io.ConsoleServices;

import java.util.ArrayList;

public abstract class Game {

    private boolean isGambling;
    private ArrayList<Player> players;
    private String name;
    private int numPlayers;

    public boolean isGambling() {
        return false;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public abstract void runGame();

}
