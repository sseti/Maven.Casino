package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.CardPlayer;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {
    @Test
    public void pollCard() {
        GoFish game = new GoFish();
        CardPlayer testPlayer = new CardPlayer("Adam");
        testPlayer.getHand().addAll(game.getGameDeck().draw(52));
        Assert.assertTrue(game.pollCard(new PlayingCard(2), testPlayer));
        testPlayer.getHand().clear();
        Assert.assertFalse(game.pollCard(new PlayingCard(2), testPlayer));
    }
}
