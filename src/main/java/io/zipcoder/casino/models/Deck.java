package io.zipcoder.casino.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private ArrayList<PlayingCard> cards = new ArrayList<>();
    public static int DECKSIZE = 52;


    public PlayingCard draw(int amt) {
       if (amt > 0) {
           int index = ThreadLocalRandom.current().nextInt(cards.size());
           return cards.remove(index);
       } else {
           return null;
       }

    }

    public void generateDeck(int deckSize) {
        Random generator = new Random();
        for(int i=cards.size(); i>0; --i) {
	int index = generator.nextInt(i);
		cards.add(cards.remove(index));
		}
            Collections.shuffle(cards);

    }

}
