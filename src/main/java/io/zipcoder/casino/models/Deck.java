package io.zipcoder.casino.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<PlayingCard> cards = new ArrayList<>();
    public static int DECKSIZE = 52;
    private Random generator = new Random();

    public ArrayList<PlayingCard> draw(int amt) {
        ArrayList<PlayingCard> toDraw = new ArrayList<>(52);
        int drawsLeft = amt;
        while (drawsLeft > 0 && this.cards.size() > 0) {
            toDraw.add(this.cards.remove(generator.nextInt(toDraw.size())));
            drawsLeft--;
        }
        return toDraw;
    }

    public void generateDeck(int deckSize) {
        int n = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
               // PlayingCard card = new PlayingCard(suit.size());
                n++;

            }
            Collections.shuffle(cards);

        }
    }
}