package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ChipTest {


    @Test
    public void dollarValTest(){

        int expected = 1;
        int actual = Chip.getWHITE();

        Assert.assertEquals(expected, actual);

    }
}
