package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Date;

public class DeckTest {

    @Test
    public void drawTest() {
        //given
        Deck newDeck = new Deck();
        newDeck.setSeed();
        //when
        boolean PlayingCard = newDeck.draw(1);
        System.out.println(expected);

        boolean expected2 = newDeck.draw(2);
        System.out.println(expected2);

        int expected3 = newDeck.draw(3);
        System.out.println(expected3);

       //then
        Assert.assertEquals(expected, actual);
    }
}
