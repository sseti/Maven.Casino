package io.zipcoder.casino.players;

import org.junit.Assert;
import org.junit.Test;

public class DicePlayerTest {

    @Test
    public void rollDiceTest (){
        //given
        DicePlayer plr = new DicePlayer("Moe");
        plr.addDice(2);
        //when
        int result = plr.rollDice();
        //then
        Assert.assertEquals(5, result);

    }

}
