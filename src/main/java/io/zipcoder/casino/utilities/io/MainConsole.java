package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.games.Game;

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
    public void runOnInvalidCommand(ArrayList<String> originalArgs) {
        processCommand(Command.BAD_COMMAND, originalArgs);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {

            case GAMES:
                boolean isPlaying = false;
                int gameChoice = -1;

                for (String arg : args) {
                    try {
                        Integer val = Integer.parseInt(arg);
                        if (val > 0 && val < 5) {
                            gameChoice = val;
                        }
                    } catch(NumberFormatException ex) {

                    }
                }

                if (gameChoice != -1) {
                    isPlaying = true;
                    // printPrompt(PromptMessage.___, true);
                } else {
                    printPrompt(PromptMessage.STANDARD, true);
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
            default:
                return;
        }
    }
}
