package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;

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
        GoFishPlayer plrToPullFrom = new GoFishPlayer("Big Ragu");
        GoFish game = new GoFish();
        PlayingCard six = new PlayingCard(6, PlayingCard.Suit.DIAMONDS);
        PlayingCard actual = six;
        List<PlayingCard> expected = plrToPullFrom.getHand();
        Assert.assertThat(expected, hasItems());
    }


    @Test
    public void getCardFromPlayer2() {
        GoFishPlayer plrToPullFrom = new GoFishPlayer("Big Flex");
        GoFish game = new GoFish();
        PlayingCard two = new PlayingCard(2, PlayingCard.Suit.CLUBS);
        PlayingCard actual = two;
        List<PlayingCard> expected = plrToPullFrom.getHand();
        Assert.assertThat(expected, hasItems());
    }

}
