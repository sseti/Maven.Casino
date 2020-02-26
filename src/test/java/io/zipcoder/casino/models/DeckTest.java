package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {

    @Test
    public void drawTest() {
        //given
        Deck newDeck = new Deck();
        newDeck.generateDeck(Deck.DECKSIZE);
        newDeck.setSeed();
        //when
        ArrayList<PlayingCard> drawnCards = newDeck.draw(1);
        //boolean expected2 = newDeck.draw(2);
        //then
        //Assert.assertEquals(expected, actual);
    }

}
