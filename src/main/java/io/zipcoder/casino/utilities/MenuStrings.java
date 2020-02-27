package io.zipcoder.casino.utilities;

import io.zipcoder.casino.utilities.io.AbstractConsole;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MenuStrings {

    public static String welcome;
    public static String standard;
    public static String commands;
    public static String goodbye;
    public static String register;
    public static String badLogin;
    public static String gamesMenu;
    public static String loginMenuCommands;
    public static String currencyMenuCommands;
    public static String gamesMenuCommands;
    public static String statsMenuCommands;
    public static String mainMenuCommands;

    public static void loadStrings() {

        welcome = "" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***                ZipCasino                   ***\n" +
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

        commands = "";

        goodbye = "";

    }

    public static String getStringFromPromptType(AbstractConsole.PromptMessage msg) {
        switch (msg) {
            case LOGIN:
                return "";
            case WELCOME:
                return welcome;
            case STANDARD:
                return standard;
            case BAD_LOGIN:
                return badLogin;
            case GAMES_MENU:
                return gamesMenu;
            case STATS_MENU:
                return "";
            case CURRENCY_MENU:
                return "";
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
