package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackTest {

    @Test
    public void newDealTest(){
        BlackJackPlayer player = new BlackJackPlayer("Zeth");
        Chip chip = new Chip(Chip.ChipValue.BLACK);
        BlackJack blackJack = new BlackJack(2, chip);
        blackJack.newDeal();


        Assert.assertEquals(player.getHand(), 2);
    }

}
