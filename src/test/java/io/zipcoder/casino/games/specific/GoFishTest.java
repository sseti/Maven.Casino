package io.zipcoder.casino.games.specific;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.CardPlayer;
import io.zipcoder.casino.players.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {


    @Test
    public void pollCard() {
        GoFishPlayer plp = new GoFishPlayer("jay");
        GoFish game = new GoFish();
        PlayingCard three = new PlayingCard(3, PlayingCard.Suit.HEARTS);
        plp.addCardToHand( new PlayingCard(3));
        Assert.assertTrue( game.pollCard(three, plp));
    }

    @Test
    public void pollCard2 (){
        GoFishPlayer plr = new GoFishPlayer("Lucky Louie");
        GoFish game = new GoFish();
        PlayingCard two = new PlayingCard(2, PlayingCard.Suit.SPADES);
        plr.addCardToHand(new PlayingCard(3));
        Assert.assertFalse(game.pollCard(two, plr));

    }

    @Test
    public void getCardFromPlayer() {
    }
}
