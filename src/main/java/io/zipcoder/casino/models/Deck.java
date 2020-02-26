package io.zipcoder.casino.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private ArrayList<PlayingCard> cards = new ArrayList<>();
    public static int DECKSIZE = 52;
    private Random generator = new Random();


    public ArrayList<PlayingCard> draw(int amt) {
        ArrayList<PlayingCard> cards = new ArrayList<>(52);
       if (cards.size() > 0) {
           int index = generator.nextInt(cards.size());
           return .remove(index);
       } else {
           return null;
       }

    }

    public void generateDeck(int deckSize) {
        for(int i=cards.size(); i>0; --i) {
	int index = generator.nextInt(i);
		cards.add(cards.remove(index));
		}
            Collections.shuffle(cards);

    }
    public void setSeed() {
        this.generator.setSeed(34);
    }
}
