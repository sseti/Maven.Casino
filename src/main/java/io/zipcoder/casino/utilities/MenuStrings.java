package io.zipcoder.casino.utilities;

import io.zipcoder.casino.App;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.StatsModel;
import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.persistence.Database;
import io.zipcoder.casino.utilities.persistence.StatTracker;

import java.util.*;

public class MenuStrings {

    public static String login;
    public static String standard;
    public static String commands;
    public static String goodbye;
    public static String register;
    public static String badLogin;
    public static String gamesMenu;
    public static String currencyMenu;
    public static String statsMenu;
    public static String buyChipsMenu;
    public static String viewChipsMenu;
    public static String leaderBoard;
    public static String leaderboardPlayers;
    public static String individualStats;
    public static String loginMenuCommands;
    public static String currencyMenuCommands;
    public static String gamesMenuCommands;
    public static String statsMenuCommands;
    public static String mainMenuCommands;

    public static int dollars = 0;
    public static int blackChips = 0;
    public static int blueChips = 0;
    public static int greenChips = 0;
    public static int whiteChips = 0;
    public static StatsModel playerStats;

    public static void updateValues() {
        if (App.getCurrentPlayer() != null && App.isLoggedIn()) {
            Wallet playerWallet = App.getCurrentPlayer().getWallet();
            dollars = playerWallet.getDollars();

            Map<Chip, Integer> playerChips = playerWallet.getChips();
            for (Map.Entry<Chip, Integer> entry : playerChips.entrySet()) {
                int dollVal = entry.getKey().getDollarVal();
                int chipAmt = entry.getValue();
                if (dollVal == 100) {
                    blackChips += chipAmt;
                } else if (dollVal == 25) {
                    greenChips += chipAmt;
                } else if (dollVal == 5) {
                    blueChips += chipAmt;
                } else {
                    whiteChips += chipAmt;
                }
            }
            Database.processStats(App.getCurrentPlayer());
            playerStats = App.getCurrentPlayer().getStats();
        }

        leaderboardPlayers = "";
        ArrayList<Player> sortedList = Database.getAllPlayers();
        Collections.sort(sortedList);
        String lengthCheck = "*************************************************************************";
        int length = lengthCheck.length();
        int rank = 1;
        for (Player p : sortedList) {
            String nextString = "*** " + rank + ": " + p.getName() + " -- " + p.getStats().getOverallScore();
            while (nextString.length() < length - 4) {
                nextString += " ";
            }
            leaderboardPlayers += nextString + " ***\n";
            rank++;
        }

        if (playerStats == null) {
            playerStats = new StatsModel();
        }

    }

    public static void loadStrings() {
        updateValues();
        login = "" +
                "**************************************************\n" +
                "***                  ZipCasino                 ***\n" +
                "***                                            ***\n" +
                "***                Keep it Loopy               ***\n" +
                "***                                            ***\n" +
                "***        Enter [USERNAME] [PASSWORD]         ***\n" +
                "***               or 'Register'                ***\n" +
                "**************************************************\n";

        standard = "" +
                "*************************************************************************\n" +
                "***                             ZipCasino                             ***\n" +
                "*************************************************************************\n" +
                "***    Games    |  Play Games                                         ***\n" +
                "***    Currency |  Exchange money and chips, cash-out                 ***\n" +
                "***    Stats    |  View leaderboards and individual player stats      ***\n" +
                "***    Help     |  Get more information about how to use the app      ***\n" +
                "***    Logout   |  Save and quit the ZipCasino app                    ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        register = "" +
                "**************************************************\n" +
                "***                Registration                ***\n" +
                "***                                            ***\n" +
                "***      Enter a new [USERNAME] [PASSWORD]     ***\n" +
                "**************************************************\n";

        badLogin = "" +
                "**************************************************\n" +
                "***                Bad Login!                  ***\n" +
                "***                                            ***\n" +
                "***         Enter [USERNAME] [PASSWORD]        ***\n" +
                "**************************************************\n";

        gamesMenu = "" +
                "*************************************************************************\n" +
                "***                      ZipCasino - Games Menu                       ***\n" +
                "*************************************************************************\n" +
                "***    1 |  Play BlackJack                                            ***\n" +
                "***    2 |  Play Go Fish                                              ***\n" +
                "***    3 |  Play Loopy Dice                                           ***\n" +
                "***    4 |  Play Craps                                                ***\n" +
                "***    0 |  Return to the main menu                                   ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        currencyMenu = "" +
                "*************************************************************************\n" +
                "***                     ZipCasino - Currency Menu                     ***\n" +
                "*************************************************************************\n" +
                "***    $$: + " + dollars + "                                                              ***\n" +
                "*************************************************************************\n" +
                "***    1 |  Buy Chips                                                 ***\n" +
                "***    2 |  Cashout                                                   ***\n" +
                "***    3 |  Deposit                                                   ***\n" +
                "***    4 |  View Chips                                                ***\n" +
                "***    0 |  Return to the main menu                                   ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        buyChipsMenu = "" +
                "********************************************************************************************************************************\n" +
                "***                                                   ZipCasino - Buy Chips                                                  ***\n" +
                "********************************************************************************************************************************\n" +
                "***                         $$: + " + dollars + "                                                                                          ***\n" +
                "********************************************************************************************************************************\n" +
                "***                  1 |  Buy Black                                                                                          ***\n" +
                "***                  2 |  Buy Green                                                                                          ***\n" +
                "***                  3 |  Buy Blue                                                                                           ***\n" +
                "***                  4 |  Buy White                                                                                          ***\n" +
                "***--------------------------------------------------------------------------------------------------------------------------***\n" +
                "***                  5 |  Return to the currency menu                                                                        ***\n" +
                "***                  6 |  Return to the main menu                                                                            ***\n" +
                "********************************************************************************************************************************\n" +
                "*** Enter a command - By default will purchase the maximum amount of chips, unless an additional amount argument is provided ***\n" +
                "********************************************************************************************************************************\n";

        viewChipsMenu = "" +
                "*************************************************************************\n" +
                "***                       ZipCasino - View Chips                      ***\n" +
                "*************************************************************************\n" +
                "***    "+ blackChips + " |  Black                                                     ***\n" +
                "***    "+ greenChips + " |  Green                                                     ***\n" +
                "***    "+ blueChips + " |  Blue                                                      ***\n" +
                "***    "+ whiteChips + " |  White                                                     ***\n" +
                "***-------------------------------------------------------------------***\n" +
                "***    0 |  Return to currency menu                                   ***\n" +
                "***    1 |  Return to main menu                                       ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        statsMenu = "" +
                "*************************************************************************\n" +
                "***                      ZipCasino - Stats Menu                       ***\n" +
                "*************************************************************************\n" +
                "***    1 |  Leaderboards                                              ***\n" +
                "***    2 |  Individual stats                                          ***\n" +
                "***    0 |  Return to the main menu                                   ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        leaderBoard = "" +
                "*************************************************************************\n" +
                "***                      ZipCasino - Leaderboard                      ***\n" +
                "*************************************************************************\n" +
                leaderboardPlayers +
                "***-------------------------------------------------------------------***\n" +
                "***    0 |  Return to the stats menu                                   ***\n" +
                "***    1 |  Return to the main menu                                   ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;

        individualStats = "" +
                "*************************************************************************\n" +
                "***                      ZipCasino - Stats Menu                       ***\n" +
                "*************************************************************************\n" +
                "***    "+ playerStats.getBlackJackWins() +" |  Black Jack Wins                                           ***\n" +
                "***    "+ playerStats.getGoFishWins() +" |  Go Fish Wins                                              ***\n" +
                "***    "+ playerStats.getLoopyWins() +" |  Loopy Dice Wins                                           ***\n" +
                "***    "+ playerStats.getCrapsWins() +" |  Craps Wins                                                ***\n" +
                "***    "+ playerStats.getOverallWins() +" |  Overall Wins                                              ***\n" +
                "***    "+ playerStats.getOverallLosses() +" |  Overall Losses                                            ***\n" +
                "***    "+ playerStats.getGamblingWins() +" |  Gambling Wins                                             ***\n" +
                "***    "+ playerStats.getTotalLifetimeChipWinnings() +" |  Total Lifetime Chip Winnings                              ***\n" +
                "***    "+ playerStats.getTotalCashSpent() +" |  Total Cash Spent                                          ***\n" +
                "***-------------------------------------------------------------------***\n" +
                "***    0 |  Return to stats menu                                      ***\n" +
                "***    1 |  Return to main menu                                       ***\n" +
                "*************************************************************************\n" +
                "***                          Enter a command                          ***\n" +
                "*************************************************************************\n" ;


        commands = "";

        goodbye = "" +
                "**************************************************\n" +
                "***                  Goodbye!                  ***\n" +
                "**************************************************\n";

    }

    public static String getStringFromPromptType(AbstractConsole.PromptMessage msg) {
        loadStrings();
        switch (msg) {
            case LOGIN:
                return login;
            case STANDARD:
                return standard;
            case BAD_LOGIN:
                return badLogin;
            case GAMES_MENU:
                return gamesMenu;
            case STATS_MENU:
                return statsMenu;
            case CURRENCY_MENU:
                return currencyMenu;
            case BUY_CHIPS_MENU:
                return buyChipsMenu;
            case VIEW_CHIPS_MENU:
                return viewChipsMenu;
            case LEADERBOARD:
                return leaderBoard;
            case IND_STATS:
                return individualStats;
            case GOODBYE:
                return goodbye;
            default:
                return "";
        }
    }

    public static String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Set<String> identifiers = new HashSet<String>();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }


}
