package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;
import io.zipcoder.casino.utilities.persistence.SaveLoadServices;

import java.util.ArrayList;

public class MainConsole extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("games", Command.GAMES);
        consoleCommands.put("currency", Command.CURRENCY);
        consoleCommands.put("money", Command.CURRENCY);
        consoleCommands.put("stats", Command.STATS);
        consoleCommands.put("help", Command.HELP);
        consoleCommands.put("logout", Command.LOGOUT);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {

            case GAMES:
               GamesConsole games = new GamesConsole();
               games.printPrompt(PromptMessage.GAMES_MENU, true);
               return;
            case CURRENCY:
                CurrencyConsole curr = new CurrencyConsole();
                curr.printPrompt(PromptMessage.CURRENCY_MENU, true);
                return;
            case STATS:
                StatsConsole stat = new StatsConsole();
                stat.printPrompt(PromptMessage.STATS_MENU, true);
                return;
            case HELP:
                printHelpCommand(this);
                if (App.isLoggedIn()) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.LOGIN, true);
                }
                return;
            case LOGOUT:
                printPrompt(PromptMessage.GOODBYE, false);
                if (App.isLoggedIn()) {
                    SaveLoadServices.saveJSON(SaveLoadServices.SAVE_FILE_NAME);
                }
                return;
            default:
                return;
        }
    }
}
