package io.zipcoder.casino.utilities.io;

import java.util.ArrayList;

public class CurrencyConsole extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("Help", Command.HELP);
    }

    @Override
    public void runOnInvalidCommand(ArrayList<String> originalArgs) {

    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {

    }
}
