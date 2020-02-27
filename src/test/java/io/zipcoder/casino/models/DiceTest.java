package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class DiceTest {
    private static final Logger LOGGER = Logger.getLogger(DiceTest.class.getName());

    @Test
    public void tossTest() {
        //given
        Dice dice1 = new Dice();
        dice1.setSeed();
        //when
        int result = dice1.toss();
        LOGGER.info(String.valueOf(result));

        int result2 = dice1.toss();
        LOGGER.info(String.valueOf(result2));

        int result3 = dice1.toss();
        LOGGER.info(String.valueOf(result3));


        //then
        Assert.assertEquals(4, result);
    }


    @Test
    public void getNumFacesTest() {
        //given
        Dice dice = new Dice();
        Integer expected = 6;
        dice.getNumFaces();
        //when
        Integer actual = dice.getNumFaces();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNumFaceTest() {
        //given
        Dice dice = new Dice();
        dice.setNumFaces(6);
        Assert.assertEquals(6, 6);
    }


}
