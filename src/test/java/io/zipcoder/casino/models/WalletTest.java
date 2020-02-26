package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WalletTest{

    @Test
    public void addDollarTest(){
        Wallet wallet = new Wallet(100);
        int amt = 150;
        int dollarsTotal = wallet.getDollars() + amt;
        wallet.addDollar(dollarsTotal);
        int expected = wallet.getDollars();

        Assert.assertEquals(expected, dollarsTotal);
    }

    @Test
    public void addChipTest(){
        Wallet wallet = new Wallet(100);
        Map<Chip, Integer> chip = new HashMap<>();
        Chip white = new Chip();
        wallet.addChip(white);
        boolean expected = false;
        boolean actual = chip.isEmpty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subDollarTest(){
        Wallet wallet = new Wallet(90);
        int amt = 25;
        wallet.subDollar(amt);
        int actual = wallet.getDollars();
        int expected = 90 - amt;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void subChipTest(){
        Wallet wallet = new Wallet(100);
        Map<Chip, Integer> chip = new HashMap<>();
        Chip black = new Chip();
        chip.put(black,6);
        wallet.subChip(black);

        int expected = 5;
        int actual = chip.size();

        Assert.assertEquals(expected, actual);
    }

}
