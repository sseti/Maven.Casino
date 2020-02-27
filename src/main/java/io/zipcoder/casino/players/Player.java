package io.zipcoder.casino.players;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.zipcoder.casino.models.StatsModel;
import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private String password;
    private Wallet wallet;
    private StatsModel stats;

    public Player() {

    }

    // For tests
    public Player(String name) {
        this(name, "", new Wallet());
    }

    public Player(String name, String password, Wallet wallet) {
        this(name, password, wallet, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @JsonCreator
    public Player(@JsonProperty("name")String name, @JsonProperty("password")String password, @JsonProperty("wallet")Wallet wallet, @JsonProperty("stats")StatsModel stat) {
        this(name, password, wallet, stat.getBlackJackWins(), stat.getGoFishWins(), stat.getLoopyWins(), stat.getCrapsWins(), stat.getHighestChipValue(), stat.getOverallWins(), stat.getOverallLosses(), stat.getGamblingWins(), stat.getTotalLifetimeChipWinnings(), stat.getTotalCashSpent());
    }

    public Player(String name, String password, Wallet wallet, int blackJackWins, int goFishWins, int loopyWins, int crapsWins, int highestChipValue, int overallWins, int overallLosses, int gamblingWins, int totalLifetimeChipWinnings, int totalCashSpent) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;
        this.stats = new StatsModel(blackJackWins, goFishWins, loopyWins, crapsWins, highestChipValue,overallWins, overallLosses, gamblingWins, totalLifetimeChipWinnings, totalCashSpent);
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
