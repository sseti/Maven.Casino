package io.zipcoder.casino.models;

import java.util.HashMap;
import java.util.Map;

public class Chip {

    private int dollarVal;
    private ChipValue val;

    public Chip(ChipValue val) {
        this.val = val;
    }

    public ChipValue getVal() {
        return val;
    }

    public int getDollarVal() {
        if(val == ChipValue.WHITE){
            dollarVal = getWHITE();
        }
        if (val == ChipValue.BLUE){
            dollarVal = getBLUE();

        }
        if( val == ChipValue.GREEN){
            dollarVal = getGREEN();

        }
        if( val == ChipValue.BLACK){
            dollarVal = getBLACK();
        }
        return dollarVal;
    }


    public static int getWHITE() {
        ChipValue whiteChip = ChipValue.WHITE;
        int whiteChipVal = whiteChip.getValue();
        return whiteChipVal;
    }

    public static int getBLUE() {
        ChipValue blueChip = ChipValue.BLUE;
        int blueChipVal = blueChip.getValue();
        return blueChipVal;

    }

    public static int getGREEN() {
        ChipValue greenChip = ChipValue.GREEN;
        int greenChipVal = greenChip.getValue();
        return greenChipVal;
    }

    public static int getBLACK() {
        ChipValue blackChip = ChipValue.BLACK;
        int blackChipVal = blackChip.getValue();
        return blackChipVal;
    }


    public enum ChipValue {
        WHITE(1),
        BLUE(5),
        GREEN(25),
        BLACK(100);

        private int value;
        private static Map map = new HashMap<>();

        ChipValue(int value){
            this.value = value;
        }
        static {
            for (ChipValue chipValue: ChipValue.values()) {
                map.put(chipValue.value, chipValue);
            }
        }

        public int getValue() {
            return value;
        }
    }

}
