package io.zipcoder.casino.utilities.persistence;

import io.zipcoder.casino.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<String, Player> usersByName;

    public static Map<String, Player> getData() {
        return usersByName;
    }

    public static boolean isUser(String name) {
        return usersByName.containsKey(name) ? true : false;
    }

    public static Player getPlayer(String name) {
        return usersByName.get(name);
    }

    public static void addUser(Player user) {
        usersByName.put(user.getName(), user);
    }

    public static ArrayList<Player> getAllPlayers() {
        ArrayList<Player> toRet = new ArrayList<>();
        for (Map.Entry<String, Player> entry : usersByName.entrySet()) {
            toRet.add(entry.getValue());
        }

        return toRet;
    }

    public static Player processStats(Player currentPlayer) {
        Player processedPlayer = currentPlayer;
        processedPlayer.getStats().setBlackJackWins(StatTracker.blackJackWins);
        processedPlayer. getStats().setLoopyWins(StatTracker.blackJackWins);
        processedPlayer. getStats().setCrapsWins(StatTracker.blackJackWins);
        processedPlayer.getStats().setGoFishWins(StatTracker.blackJackWins);
        processedPlayer. getStats().setOverallLosses(StatTracker.overallLosses);
        processedPlayer.getStats().setHighestChipValue(StatTracker.highestChipValue);
        processedPlayer. getStats().setLoopyWins(StatTracker.loopyWins);
        processedPlayer. getStats().setTotalCashSpent(StatTracker.totalCashSpent);
        processedPlayer. getStats().setTotalLifetimeChipWinnings(StatTracker.totalLifetimeChipWinnings);
        int gamblingWins = StatTracker.crapsWins + StatTracker.blackJackWins;
        int nonGamblingWins = StatTracker.loopyWins + StatTracker.goFishWins;
        int totalWins = gamblingWins + nonGamblingWins;
        processedPlayer. getStats().setOverallWins(totalWins);
        processedPlayer. getStats().setGamblingWins(gamblingWins);
        return processedPlayer;
    }

    public static void reloadAllUsers(ArrayList<Player> players) {
        usersByName.clear();
        for (Player p : players) {
            usersByName.put(p.getName(), p);
        }
    }

    public static boolean canLogin(String name, String pass) {
        return (usersByName.containsKey(name)) ? (usersByName.get(name).getPassword().equals(pass)) : false;
    }

    static {
        usersByName = new HashMap<>();
    }

}
