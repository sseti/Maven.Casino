package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

public class ChipTest {

    @Test
    public void dollarValTest(){

        int expected = 1;
        int actual = Chip.getWHITE();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dollarValTest2(){
        int expected = 5;
        int actual = Chip.getBLUE();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dollarValTest3() {
        int expected = 25;
        int actual = Chip.getGREEN();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dollarValTest4() {
        int expected = 100;
        int actual = Chip.getBLACK();

        Assert.assertEquals(expected, actual);
    }

}
