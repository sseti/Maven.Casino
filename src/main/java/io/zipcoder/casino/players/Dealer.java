package io.zipcoder.casino.players;

import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.utilities.MenuStrings;

import java.util.ArrayList;


public class Dealer extends CardPlayer {

    private int handValue = 0;
    private PlayingCard unknownValue;
    private String name;

    public Dealer() {
        this(MenuStrings.randomIdentifier());
    }

    public Dealer(String name) {
        super(name);
        this.name = name;

    }

    public void hit(PlayingCard card){

        addCardToHand(card);
    }

    public boolean isHitting() {

        if(getHandValue() <= 16){
            return true;
        }
        return false;
    }

    public int getHandValue() {
        int newCardValue =0;
        int sum =0;
        for (int i = 0; i <this.getHand().size() ; i++) {
            if (this.getHand().get(i).getValueAsInt() > 10){
                newCardValue = 10;
            }
            else if (this.getHand().get(i).getValueAsInt() == 1){
                newCardValue = 11;
            } else{
                newCardValue  = this.getHand().get(i).getValueAsInt();
            }
            sum += newCardValue;
        }
        return sum;
    }

    public PlayingCard getUnknownValue() {
        return unknownValue;
    }
}