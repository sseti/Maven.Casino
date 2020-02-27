package io.zipcoder.casino;

import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.games.specific.GoFish;
import io.zipcoder.casino.games.specific.LoopyDice;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.models.Casino;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.LoginConsole;
import io.zipcoder.casino.utilities.persistence.SaveLoadServices;
import io.zipcoder.casino.utilities.persistence.StatTracker;

public class App {

    private static Casino casino;

    public static void main(String[] args) {
        App application = new App();
        application.initialize();

        // Example print
        //ConsoleServices.print("My cool message");

    }

    public void initialize() {
        casino = new Casino();
        StatTracker st = new StatTracker();
        SaveLoadServices.loadJSONData(SaveLoadServices.SAVE_FILE_NAME);
        LoginConsole login = new LoginConsole();
        login.printPrompt(AbstractConsole.PromptMessage.WELCOME, true);

        /* Test games */
        // Run LoopyDice
            //LoopyDice game = new LoopyDice();
            //game.runGame();

        // Run Go Fish
            //GoFish game = new GoFish();
            //game.runGame();
    }


    // If you are getting weird null pointers (or something like that) in tests, try running this func before any other code
    public static void TestingInit() {
        casino = new Casino();
        StatTracker st = new StatTracker();
        SaveLoadServices.loadJSONData(SaveLoadServices.SAVE_FILE_NAME);
    }

    public static void updatePlayer(Game currentGame) {
        casino.updateCurrentPlayer(currentGame);
    }

    public static Casino getCasino() {
        return casino;
    }

    public static void logPlayerIn(Player p) {
        casino.setCurrentPlayer(p);
    }

    public static Player getCurrentPlayer() {
        return casino.getCurrentPlayer();
    }

}
