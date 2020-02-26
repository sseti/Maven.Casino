package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void tossTest() {
        //given
        Dice dice1 = new Dice();
        dice1.setSeed();
        //when
        int result = dice1.toss();
        System.out.println(result);

        int result2 = dice1.toss();
        System.out.println(result2);

        int result3 = dice1.toss();
        System.out.println(result3);


        //then
        Assert.assertEquals(4, result);
    }


}
