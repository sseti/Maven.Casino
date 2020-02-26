package io.zipcoder.casino.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WalletTest{

    @Test
    public void addDollarTest(){
        Wallet wallet = new Wallet(0);
        int amt = 150;
        int dollarsTotal = wallet.getDollars() + amt;
        wallet.addDollar(dollarsTotal);
        int expected = wallet.getDollars();

        Assert.assertEquals(expected, dollarsTotal);
    }

    @Test
    public void addChipTest(){
        Wallet wallet = new Wallet(0);
        Map<Chip, Integer> chip = new HashMap<>();
        Chip white = new Chip(Chip.ChipValue.WHITE);
        wallet.addChip(white);
        int expected = 1;
        int totalChips = 0;
        for (Map.Entry<Chip, Integer> i : chip.entrySet()){
            totalChips += i.getValue();
        }

        Assert.assertEquals(expected, totalChips);
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
        Chip black = new Chip(Chip.ChipValue.BLACK);
        chip.put(black,6);
        wallet.subChip(black);
        int totalChips = 0;
        for (Map.Entry<Chip, Integer> i : chip.entrySet()) {
            totalChips += i.getValue();
        }

        int expected = 5;
        int actual = totalChips;

        Assert.assertEquals(expected, actual);
    }

   /* @Test
    public void subChipByDollar(){
        Wallet wallet = new Wallet(100);
        Map<Chip, Integer> chip = new HashMap<>();
        Chip black = new Chip();
        chip.put(black,6);
        wallet.subChip(100);
    }*/

}
