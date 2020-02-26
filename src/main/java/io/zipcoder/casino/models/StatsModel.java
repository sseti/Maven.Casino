package io.zipcoder.casino.models;

public class StatsModel {

    private int blackJackWins = 0;
    private int goFishWins = 0;
    private int loopyWins = 0;
    private int crapsWins = 0;
    private int highestChipValue = 0;
    private int overallWins = 0;
    private int overallLosses = 0;
    private int gamblingWins = 0;
    private int totalLifetimeChipWinnings = 0;
    private int totalCashSpent = 0;

    public StatsModel(int blackJackWins, int goFishWins, int loopyWins, int crapsWins, int highestChipValue, int overallWins, int overallLosses, int gamblingWins, int totalLifetimeChipWinnings, int totalCashSpent) {
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

    public int getBlackJackWins() {
        return blackJackWins;
    }

    public void setBlackJackWins(int blackJackWins) {
        this.blackJackWins = blackJackWins;
    }

    public int getGoFishWins() {
        return goFishWins;
    }

    public void setGoFishWins(int goFishWins) {
        this.goFishWins = goFishWins;
    }

    public int getLoopyWins() {
        return loopyWins;
    }

    public void setLoopyWins(int loopyWins) {
        this.loopyWins = loopyWins;
    }

    public int getCrapsWins() {
        return crapsWins;
    }

    public void setCrapsWins(int crapsWins) {
        this.crapsWins = crapsWins;
    }

    public int getHighestChipValue() {
        return highestChipValue;
    }

    public void setHighestChipValue(int highestChipValue) {
        this.highestChipValue = highestChipValue;
    }

    public int getOverallWins() {
        return overallWins;
    }

    public void setOverallWins(int overallWins) {
        this.overallWins = overallWins;
    }

    public int getOverallLosses() {
        return overallLosses;
    }

    public void setOverallLosses(int overallLosses) {
        this.overallLosses = overallLosses;
    }

    public int getGamblingWins() {
        return gamblingWins;
    }

    public void setGamblingWins(int gamblingWins) {
        this.gamblingWins = gamblingWins;
    }

    public int getTotalLifetimeChipWinnings() {
        return totalLifetimeChipWinnings;
    }

    public void setTotalLifetimeChipWinnings(int totalLifetimeChipWinnings) {
        this.totalLifetimeChipWinnings = totalLifetimeChipWinnings;
    }

    public int getTotalCashSpent() {
        return totalCashSpent;
    }

    public void setTotalCashSpent(int totalCashSpent) {
        this.totalCashSpent = totalCashSpent;
    }
}