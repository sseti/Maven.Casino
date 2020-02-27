package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackPlayerTest {
    @Test
    public void hitTest() {
        ArrayList<PlayingCard> hand = new ArrayList<>();
        BlackJackPlayer Raheel = new BlackJackPlayer("Raheel");
        Raheel.hit(Raheel);
        Integer actual = hand.size();
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleDownTest() {
        ArrayList<PlayingCard> hand = new ArrayList<>();
        BlackJackPlayer Raheel = new BlackJackPlayer("Raheel");
        Raheel.hit(Raheel);
        Raheel.doubleDown();
        //Table chips go up



    }
    @Test
    public void splitTest() {
        ArrayList<PlayingCard> hand = new ArrayList<>();
        BlackJackPlayer Raheel = new BlackJackPlayer("Raheel");

        if(hand.indexOf(0) == hand.indexOf(1)){
            Raheel.split();
        }
    }

}
