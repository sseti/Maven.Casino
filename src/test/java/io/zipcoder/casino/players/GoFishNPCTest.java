package io.zipcoder.casino.players;

import org.junit.Test;

public class GoFishNPCTest {

    @Test
    public void TestCat() {
        GoFishNPC drawAmt = new GoFishNPC (5);
        Integer actual = GoFishNPC.addCardTohand();
        Integer expected = 6;
        Assertions.assertEquals(expected, actual);
    }
}
