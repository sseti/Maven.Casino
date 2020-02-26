package io.zipcoder.casino.models;

public class Chip {

    private int dollarVal;

    public int getDollarVal() { return dollarVal; }

    public static int getWHITE() {
        return ChipValue.WHITE.ordinal();
    }

    public static int getBLUE() {
        return ChipValue.BLUE.ordinal();
    }

    public static int getGREEN() {
        return ChipValue.GREEN.ordinal();
    }

    public static int getBLACK() {
        return ChipValue.BLACK.ordinal();
    }


    public enum ChipValue {
        WHITE(1),
        BLUE(5),
        GREEN(25),
        BLACK(100);

        ChipValue(int i){}
    }

}
