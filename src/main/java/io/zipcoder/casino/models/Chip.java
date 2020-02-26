package io.zipcoder.casino.models;

import java.util.Map;

public class Chip {

    private int dollarVal;
    private static final int WHITE = 1;
    private static final int BLUE = 5;
    private static final int GREEN = 25;
    private static final int BLACK = 100;


    public int getDollarVal(int chipValue) { return chipValue; }

    public static int getWHITE() {
        return WHITE;
    }

    public static int getBLUE() {
        return BLUE;
    }

    public static int getGREEN() {
        return GREEN;
    }

    public static int getBLACK() {
        return BLACK;
    }


    public enum ChipValue {
        WHITE,
        BLUE,
        GREEN,
        BLACK;



    }
}
