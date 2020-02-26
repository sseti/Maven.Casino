package io.zipcoder.casino;

import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.games.specific.LoopyDice;
import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.models.Casino;
import io.zipcoder.casino.utilities.builders.PlayerBuilder;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.ConsoleServices;
import io.zipcoder.casino.utilities.io.LoginConsole;
import io.zipcoder.casino.utilities.persistence.SaveLoadServices;
import io.zipcoder.casino.utilities.persistence.StatTracker;

public class App {

    private static Casino casino;

    public static void main(String[] args) {
        App application = new App();
        application.initialize();

        // A way to use builders
        Player playTest = new PlayerBuilder().setName("").setPassword("").setWallet(new Wallet()).createPlayer();

        // Example print
        //ConsoleServices.print("My cool message");

    }

    public void initialize() {
        casino = new Casino();
        StatTracker st = new StatTracker();
        SaveLoadServices.loadJSONData(SaveLoadServices.SAVE_FILE_NAME);
        LoginConsole login = new LoginConsole();
        login.printPrompt(AbstractConsole.PromptMessage.WELCOME, true);
    }

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
