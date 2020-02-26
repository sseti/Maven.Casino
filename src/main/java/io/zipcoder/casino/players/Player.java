package io.zipcoder.casino.players;

import io.zipcoder.casino.models.StatsModel;
import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private String password;
    private Wallet wallet;
    private StatsModel stats;

    // For tests
    public Player(String name) {
        this.name = name;
        this.wallet = wallet;
    }

    public Player(String name, String password, Wallet wallet) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;
    }

    public Player(String name, String password, Wallet wallet, int blackJackWins, int goFishWins, int loopyWins, int crapsWins, int highestChipValue, int overallWins, int overallLosses, int gamblingWins, int totalLifetimeChipWinnings, int totalCashSpent) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;

        StatsModel temp = new StatsModel(blackJackWins, goFishWins, loopyWins, crapsWins, highestChipValue,overallWins, overallLosses, gamblingWins, totalLifetimeChipWinnings, totalCashSpent);

    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getPassword() { return password; }

    public StatsModel getStats() {
        return stats;
    }

    public void setStats(StatsModel stats) {
        this.stats = stats;
    }
}
