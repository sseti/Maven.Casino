package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;

import java.util.ArrayList;

public class CurrencyConsole extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("help", Command.HELP);
        consoleCommands.put("0", Command.MAIN_MENU);
        consoleCommands.put("1", Command.BUY_CHIPS);
        consoleCommands.put("2", Command.CASHOUT);
        consoleCommands.put("3", Command.DEPOSIT);
        consoleCommands.put("4", Command.VIEW_CHIPS);
    }


    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {
            case HELP:
                printHelpCommand(this);
                if (App.isLoggedIn()) {
                    printPrompt(PromptMessage.CURRENCY_MENU, true);
                } else {
                    printPrompt(PromptMessage.LOGIN, true);
                }
                return;
            case MAIN_MENU:
                MainConsole console = new MainConsole();
                console.printPrompt(PromptMessage.STANDARD, true);
                return;
            default:
                printPrompt(PromptMessage.CURRENCY_MENU, true);
                return;
        }
    }
}
