package io.zipcoder.casino.models;

public class PlayingCard {

    private Rank value;
    private Suit suit;

    public PlayingCard(Rank value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Rank getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public enum Suit {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }

    public enum Rank {
        ACE(1),
        TWO (2),
        THREE (3),
        FOUR (4),
        FIVE (5),
        SIX (6),
        SEVEN (7),
        EIGHT (8),
        NINE (9),
        TEN (10),
        JACK (11),
        QUEEN (12),
        KING (13);

        Rank(int i) {}
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
