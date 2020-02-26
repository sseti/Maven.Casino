package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Wallet;

public class Player {

    private String name;
    private String password;
    private Wallet wallet;
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

    public Player(String name, String password, Wallet wallet, int blackJackWins, int goFishWins, int loopyWins, int crapsWins, int highestChipValue, int overallWins, int overallLosses, int gamblingWins, int totalLifetimeChipWinnings, int totalCashSpent) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;
        this.blackJackWins = blackJackWins;
        this.goFishWins = goFishWins;
        this.loopyWins = loopyWins;
        this.crapsWins = crapsWins;
        this.highestChipValue = highestChipValue;
        this.overallWins = overallWins;
        this.overallLosses = overallLosses;
        this.gamblingWins = gamblingWins;
        this.totalLifetimeChipWinnings = totalLifetimeChipWinnings;
        this.totalCashSpent = totalCashSpent;
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

    public int getBlackJackWins() {
        return blackJackWins;
    }

    public int getGoFishWins() {
        return goFishWins;
    }

    public int getLoopyWins() {
        return loopyWins;
    }

    public int getCrapsWins() {
        return crapsWins;
    }

    public int getHighestChipValue() {
        return highestChipValue;
    }

    public int getOverallWins() {
        return overallWins;
    }

    public int getOverallLosses() {
        return overallLosses;
    }

    public int getGamblingWins() {
        return gamblingWins;
    }

    public int getTotalLifetimeChipWinnings() {
        return totalLifetimeChipWinnings;
    }

    public int getTotalCashSpent() {
        return totalCashSpent;
    }
}
