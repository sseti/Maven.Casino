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

    @JsonCreator
    public Player(@JsonProperty("name")String name, @JsonProperty("password")String password, @JsonProperty("wallet")Wallet wallet, @JsonProperty("blackJackWins")int blackJackWins, @JsonProperty("goFishWins")int goFishWins, @JsonProperty("loopyWins")int loopyWins, @JsonProperty("crapsWins")int crapsWins, @JsonProperty("highestChipValue")int highestChipValue, @JsonProperty("overallWins")int overallWins, @JsonProperty("overallLosses")int overallLosses, @JsonProperty("gamblingWins")int gamblingWins, @JsonProperty("totalLifetimeChipWinnings")int totalLifetimeChipWinnings, @JsonProperty("totalCashSpent")int totalCashSpent) {
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
