package io.zipcoder.casino.models;

public class BettingArea {

    private String location;
    private boolean isBetOn;
    private int betAmount;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isBetOn() {
        return isBetOn;
    }

    public void setBetOn(boolean betOn) {
        isBetOn = betOn;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
}
