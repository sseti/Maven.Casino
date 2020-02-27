package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import org.junit.Assert;
import org.junit.Test;

public class GoFishPlayerTest {

    @Test

    public void goFishPlayerTest() {

        boolean hasCard = true;

        GoFishPlayer player = new GoFishPlayer("John");

        PlayingCard card = new PlayingCard(PlayingCard.Rank.JACK, PlayingCard.Suit.HEARTS);

        player.addCardToHand(card);

        Assert.assertTrue(player.hasCard(card));
    }

    public void goFishPlayerTest2() {

        boolean hasCard = true;

        GoFishPlayer player = new GoFishPlayer("Bill");

        PlayingCard card = new PlayingCard(PlayingCard.Rank.TEN, PlayingCard.Suit.DIAMONDS);

        player.addCardToHand(card);

        Assert.assertTrue(player.hasCard(card));
    }
}