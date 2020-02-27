package io.zipcoder.casino.models;


import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.games.specific.BlackJack;
import io.zipcoder.casino.games.specific.Craps;
import io.zipcoder.casino.games.specific.GoFish;
import io.zipcoder.casino.games.specific.LoopyDice;
import io.zipcoder.casino.players.*;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.GamesConsole;
import io.zipcoder.casino.utilities.io.MainConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Casino {

    private Map<String, Game> games;
    private Player currentPlayer;

    public void startGame(int gameNum) {
        GamesConsole main = new GamesConsole();
        switch (gameNum) {
            case 1:
                main.processCommand(AbstractConsole.Command.BLACKJACK, new ArrayList<>());
                return;
            case 2:
                main.processCommand(AbstractConsole.Command.GOFISH, new ArrayList<>());
                return;
            case 3:
                main.processCommand(AbstractConsole.Command.LOOPY_DICE, new ArrayList<>());
                return;
            case 4:
                main.processCommand(AbstractConsole.Command.CRAPS, new ArrayList<>());
                return;
            default:
                main.printPrompt(AbstractConsole.PromptMessage.STANDARD, true);
                return;
        }
    }


    public Casino() {
        currentPlayer = new Player("temp");
        games = new HashMap<>();
        games.put("blackjack", new BlackJack());
        games.put("go fish", new GoFish());
        games.put("gofish", new GoFish());
        games.put("loopy", new LoopyDice());
        games.put("loop", new LoopyDice());
        games.put("loopydice", new LoopyDice());
        games.put("craps", new Craps());
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
        } else if (currentGame instanceof LoopyDice) {
            this.currentPlayer = new LoopyDicePlayer(this.currentPlayer);
        }
    }

}
