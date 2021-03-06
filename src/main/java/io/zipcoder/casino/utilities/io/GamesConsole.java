package io.zipcoder.casino.utilities.io;

import io.zipcoder.casino.App;
import io.zipcoder.casino.games.specific.BlackJack;
import io.zipcoder.casino.games.specific.Craps;
import io.zipcoder.casino.games.specific.GoFish;
import io.zipcoder.casino.games.specific.LoopyDice;

import java.util.ArrayList;

public class GamesConsole extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("loopy", Command.LOOPY_DICE);
        consoleCommands.put("gofish", Command.GOFISH);
        consoleCommands.put("blackjack", Command.BLACKJACK);
        consoleCommands.put("craps", Command.CRAPS);
        consoleCommands.put("help", Command.HELP);
        consoleCommands.put("1", Command.BLACKJACK);
        consoleCommands.put("2", Command.GOFISH);
        consoleCommands.put("3", Command.LOOPY_DICE);
        consoleCommands.put("4", Command.CRAPS);
        consoleCommands.put("0", Command.MAIN_MENU);
    }

    @Override
    public void processCommand(Command cmd, ArrayList<String> args) {
        switch (cmd) {
            case BLACKJACK:
                BlackJack blackJackGame = new BlackJack();
                blackJackGame.runGame();
                printPrompt(PromptMessage.GAMES_MENU, true);
                return;
            case GOFISH:
                GoFish goFishGame = new GoFish();
                goFishGame.runGame();
                printPrompt(PromptMessage.GAMES_MENU, true);
                return;
            case LOOPY_DICE:
                LoopyDice loopyDiceGame = new LoopyDice(3);
                loopyDiceGame.runGame();
                printPrompt(PromptMessage.GAMES_MENU, true);
                return;
            case CRAPS:
                Craps crapsGame = new Craps();
                crapsGame.runGame();
                printPrompt(PromptMessage.GAMES_MENU, true);
                return;
            default:
                MainConsole console = new MainConsole();
                console.printPrompt(PromptMessage.STANDARD, true);
                return;
        }

    }
}

