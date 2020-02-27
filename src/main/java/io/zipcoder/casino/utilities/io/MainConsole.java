package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.Game;

import java.util.ArrayList;
import java.util.Map;

public class MainConsole extends AbstractConsole {


    /*private static Map<String, Game> gameMap;

    static {
        gameNames.add("blackjack");
        gameNames.add("gofish");
        gameNames.add("loopy");

    }*/

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
    public void runOnInvalidCommand(ArrayList<String> originalArgs) {
        processCommand(Command.BAD_COMMAND, originalArgs);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {

            case GAMES:
                boolean playing = false;
                for (String arg : args) {
                    try {
                        Integer val = Integer.parseInt(arg);
                        if (val > 0 && val < 5) {
                            App.getCasino().startGame(val);
                            playing = true;
                        }
                    } catch(NumberFormatException ex) {}
                }
                if (!playing) {
                    printPrompt(PromptMessage.GAMES_MENU, true);
                }
                return;
            case CURRENCY:
                return;
            case STATS:
                return;
            case HELP:
                return;
            case LOGOUT:
                return;
            case BAD_COMMAND:
                ConsoleServices.print("Bad command! Please enter a valid command, or enter 'Help'.");
                if (App.isLoggedIn()) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.WELCOME, true);
                }
                return;
            default:
                return;
        }
    }
}
