package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private String password;
    private Wallet wallet;

    // Stats fields
    // Should be a separate object, but I am worried about proper JSON deserialization
    private int blackJackWins = 0;
    private int goFishWins = 0;
    private int loopyWins = 0;
    private int crapsWins = 0;
    private int highestChipValue = 0;;
    private int overallWins = 0;
    private int overallLosses = 0;
    private int gamblingWins = 0;
    private int totalLifetimeChipWinnings = 0;
    private int totalCashSpent = 0;

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

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getPassword() { return password; }

    public void setBlackJackWins(int blackJackWins) {
        this.blackJackWins = blackJackWins;
    }

    public void setGoFishWins(int goFishWins) {
        this.goFishWins = goFishWins;
    }

    public void setLoopyWins(int loopyWins) {
        this.loopyWins = loopyWins;
    }

    public void setCrapsWins(int crapsWins) {
        this.crapsWins = crapsWins;
    }

    public void setHighestChipValue(int highestChipValue) {
        this.highestChipValue = highestChipValue;
    }

    public void setOverallWins(int overallWins) {
        this.overallWins = overallWins;
    }

    public void setOverallLosses(int overallLosses) {
        this.overallLosses = overallLosses;
    }

    public void setGamblingWins(int gamblingWins) {
        this.gamblingWins = gamblingWins;
    }

    public void setTotalLifetimeChipWinnings(int totalLifetimeChipWinnings) {
        this.totalLifetimeChipWinnings = totalLifetimeChipWinnings;
    }

    public void setTotalCashSpent(int totalCashSpent) {
        this.totalCashSpent = totalCashSpent;
    }
}
