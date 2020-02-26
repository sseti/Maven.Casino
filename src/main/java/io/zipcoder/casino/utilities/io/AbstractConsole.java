package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.utilities.MenuStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConsole {

    protected Map<String, Command> consoleCommands;

    public enum Command {
        GAMES,
        CURRENCY,
        STATS,
        HELP,
        LOGOUT,
        CASHOUT,
        CONVERT,
        MONEY_STATS,
        LEADERBOARD,
        INDIVIDUAL_STATS,
        BLACKJACK,
        GOFISH,
        LOOPY_DICE,
        CRAPS,
        BAD_COMMAND,
        REGISTER
    }

    public enum PromptMessage {
        STANDARD,
        GAMES_MENU,
        CURRENCY_MENU,
        STATS_MENU,
        LOGIN,
        WELCOME,
        BAD_LOGIN
    }

    public AbstractConsole() {
        consoleCommands = new HashMap<>();
        initializeCommands();
    }

    protected void printHelpCommand(AbstractConsole consoleType) {
        if (consoleType instanceof LoginConsole) {
           ConsoleServices.print(MenuStrings.loginMenuCommands);
        } else if (consoleType instanceof MainConsole) {
            ConsoleServices.print(MenuStrings.mainMenuCommands);
        }
        else if (consoleType instanceof CurrencyConsole) {
            ConsoleServices.print(MenuStrings.currencyMenuCommands);
        } else if (consoleType instanceof GamesConsole) {
            ConsoleServices.print(MenuStrings.gamesMenuCommands);
        } else if (consoleType instanceof StatsConsole) {
            ConsoleServices.print(MenuStrings.statsMenuCommands);
        }
    }

    private ArrayList<String> generateUserInput() {
        String input = ConsoleServices.getStringInput("");
        String[] splice = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        for (String s : splice) {
            argus.add(s);
        }
        return argus;
    }

    public boolean commandExists(String cmd) {
        if (this.consoleCommands != null && this.consoleCommands.containsKey(cmd.toLowerCase())) {
            return true;
        }
        return false;
    }

    protected void getUserInput() {
        String input = ConsoleServices.getStringInput("");
        String[] splited = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        for (String s : splited) {
            argus.add(s);
        }
        while (argus.size() < 1) {
            argus = generateUserInput();
        }
        findAndProcessCommand(argus);
    }

    public void findAndProcessCommand(ArrayList<String> args) {
        String fullCommand = "";
        for (String s : args) {
            fullCommand += s + " ";
        }
        String command = args.remove(0).toLowerCase();
        String hiddenCmd = "";
        boolean allowOtherConsoles = false;
        AbstractConsole consoleToExecuteFrom = null;

        if (isValidCommandInAnyConsole(command)) {
            consoleToExecuteFrom = whichConsoleHasThisCommand(command);
            allowOtherConsoles = true;
        }
        if (commandExists(command)) {
            this.processCommand(this.consoleCommands.get(command), args);
        }
        else if (allowOtherConsoles) {
            consoleToExecuteFrom.processCommand(consoleToExecuteFrom.consoleCommands.get(command), args);
        }
        else if (command.equals("best") && hiddenCmd.toLowerCase().equals("programmer")) {
            ConsoleServices.print("Nobles");
            printPrompt(PromptMessage.STANDARD, true);
        }
        else {
            runOnInvalidCommand(args);
        }
    }

    public void printPrompt(PromptMessage message, boolean promptForInput) {
        MenuStrings.loadStrings();
        String promptString = MenuStrings.getStringFromPromptType(message);
        ConsoleServices.print(promptString);
        if (promptForInput) {
            getUserInput();
        }
    }

    private static boolean isValidCommandInAnyConsole(String cmd) {
        CurrencyConsole currencyConsole = new CurrencyConsole();
        GamesConsole gamesConsole = new GamesConsole();
        LoginConsole loginConsole = new LoginConsole();
        StatsConsole statsConsole = new StatsConsole();
        if (currencyConsole.commandExists(cmd)) { return true; }
        else if (gamesConsole.commandExists(cmd)) { return true; }
        else if (loginConsole.commandExists(cmd)) { return true; }
        else if (statsConsole.commandExists(cmd)) { return true; }
        return false;
    }

    private static AbstractConsole whichConsoleHasThisCommand(String cmd) {
        CurrencyConsole currencyConsole = new CurrencyConsole();
        GamesConsole gamesConsole = new GamesConsole();
        LoginConsole loginConsole = new LoginConsole();
        StatsConsole statsConsole = new StatsConsole();
        if (currencyConsole.commandExists(cmd)) { return currencyConsole; }
        else if (gamesConsole.commandExists(cmd)) { return gamesConsole; }
        else if (loginConsole.commandExists(cmd)) { return loginConsole; }
        else if (statsConsole.commandExists(cmd)) { return statsConsole; }
        return null;
    }

    protected abstract void initializeCommands();

    public abstract void runOnInvalidCommand(ArrayList<String> originalArgs);

    public abstract void processCommand(Command cmd, ArrayList<String> args);

}
