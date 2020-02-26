package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;
import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.utilities.builders.PlayerBuilder;
import io.zipcoder.casino.utilities.persistence.Database;
import io.zipcoder.casino.utilities.persistence.SaveLoadServices;

import java.util.ArrayList;

public class LoginConsole extends AbstractConsole {

    private boolean loggedIn = false;

    @Override
    protected void initializeCommands() {
        consoleCommands.put("help", Command.HELP);
        consoleCommands.put("register", Command.REGISTER);
        consoleCommands.put("logout", Command.LOGOUT);
    }

    @Override
    public void runOnInvalidCommand(ArrayList<String> originalArgs) {
        processCommand(Command.BAD_COMMAND, originalArgs);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {
            case HELP:
                printHelpCommand(this);
                return;
            case REGISTER:
                if (attemptRegister(args)) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.WELCOME, true);
                }
                return;
            case BAD_COMMAND:
                ConsoleServices.print("Bad command! Please enter a valid command, or enter 'Help'.");
                if (this.loggedIn) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.WELCOME, true);
                }
                return;
            case LOGOUT:
                if (loggedIn) {
                    SaveLoadServices.saveJSON(SaveLoadServices.SAVE_FILE_NAME);
                }
                return;
            default:
                if (attemptLogin(args)) {
                    printPrompt(PromptMessage.STANDARD, true);
                } else {
                    printPrompt(PromptMessage.BAD_LOGIN, true);
                }
                return;
        }
    }

    public Boolean attemptLogin(ArrayList<String> args) {
        String user = getUserFromInput(args);
        Boolean loggedIn = Database.canLogin(user, getPasswordFromInput(args));
        if (loggedIn) {
           App.logPlayerIn(Database.getPlayer(user));
           this.loggedIn = true;
        }
        return loggedIn;
    }

    public Boolean attemptRegister(ArrayList<String> args) {
        String user = getUserFromInput(args);
        String pass = getPasswordFromInput(args);
        if (!Database.isUser(user)) {
            Player newUser = new PlayerBuilder()
                    .setName(user)
                    .setPassword(pass)
                    .setWallet(new Wallet())
                    .createPlayer();
            Database.addUser(newUser);
            App.logPlayerIn(Database.getPlayer(user));
            loggedIn = true;
            return true;
        }
        return false;
    }

    private String getUserFromInput(ArrayList<String> args) {
        for (String arg : args) {
            if (Database.isUser(arg)) {
                return arg;
            }
        }
        return "";
    }

    private String getPasswordFromInput(ArrayList<String> args) {
        for (String arg : args) {
            if (!Database.isUser(arg)) {
                return arg;
            }
        }
        return "";
    }
}

