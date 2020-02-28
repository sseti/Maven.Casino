package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;

import java.util.ArrayList;

public class StatsConsole extends AbstractConsole {
    @Override
    protected void initializeCommands() {
        consoleCommands.put("help", Command.HELP);
        consoleCommands.put("1", Command.LEADERBOARD);
        consoleCommands.put("2", Command.INDIVIDUAL_STATS);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {
            case LEADERBOARD:
                printPrompt(PromptMessage.LEADERBOARD, true);
                return;
            case INDIVIDUAL_STATS:
                printPrompt(PromptMessage.IND_STATS, true);
                return;
            case HELP:
                printHelpCommand(this);
                if (App.isLoggedIn()) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.LOGIN, true);
                }
                return;
            default:
                MainConsole console = new MainConsole();
                console.printPrompt(PromptMessage.STANDARD, true);
                return;
        }
    }
}

