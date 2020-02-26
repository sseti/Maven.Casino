package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CardPlayerTest {

    private static final Logger LOGGER = Logger.getLogger(CardPlayerTest.class.getName());


    @Test
    public void getHandTest(){
        String name = "Raheel Uppal";
        int age = 25;
        PlayingCard ACE = new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS);
        ArrayList<PlayingCard> hand = new ArrayList<>();
        hand.add(ACE);
        hand.add(ACE);
        hand.add(ACE);
        hand.add(ACE);

        CardPlayer Raheel = new CardPlayer(name);

        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);

        ArrayList playerHand = Raheel.getHand();

        String output = "";

        for (int i = 0; i <playerHand.size() ; i++) {
            output += playerHand.get(i).toString();
        }
        LOGGER.info(output);

        String expected = output;
        String actual = "ACE of HEARTSACE of HEARTSACE of HEARTSACE of HEARTS";

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void removeFromHandTest(){
        String name = "Raheel Uppal";
        int age = 25;
        PlayingCard ACE = new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS);
        ArrayList<PlayingCard> hand = new ArrayList<>();
        hand.add(ACE);
        hand.add(ACE);
        hand.add(ACE);
        hand.add(ACE);
        hand.remove(ACE);

        CardPlayer Raheel = new CardPlayer(name);

        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);
        Raheel.addCardToHand(ACE);
        Raheel.removeCard(ACE);

        ArrayList playerHand = Raheel.getHand();

        String output = "";

        for (int i = 0; i <playerHand.size() ; i++) {
            output += playerHand.get(i).toString();
        }
        LOGGER.info(output);

        String expected = output;
        String actual = "ACE of HEARTSACE of HEARTSACE of HEARTS";

        Assert.assertEquals(expected,actual);

    }

}
