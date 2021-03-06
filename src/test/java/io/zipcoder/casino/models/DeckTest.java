package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {

    @Test
    public void drawTest() {
        //given
        Deck newDeck = new Deck();
        //ArrayList<PlayingCard> cards = new ArrayList<>();
        newDeck.generateDeck();

        // when
        int expected = 52;
        int actual = newDeck.getCards().size();

        // then
        Assert.assertEquals(expected, actual);
    }
}