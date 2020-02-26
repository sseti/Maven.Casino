package io.zipcoder.casino.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static io.zipcoder.casino.models.PlayingCard.Rank.*;
import static io.zipcoder.casino.models.PlayingCard.Suit.*;

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

            ArrayList<PlayingCard.Rank> list = new ArrayList<>();

            list.add(ACE);
            list.add(TWO);
            list.add(THREE);
            list.add(FOUR);
            list.add(FIVE);
            list.add(SIX);
            list.add(SEVEN);
            list.add(EIGHT);
            list.add(NINE);
            list.add(TEN);
            list.add(JACK);
            list.add(QUEEN);
            list.add(KING);

            ArrayList <PlayingCard.Suit> listTwo = new ArrayList<>();
            listTwo.add(HEARTS);
            listTwo.add(SPADES);
            listTwo.add(CLUBS);
            listTwo.add(DIAMONDS);

            this.cards = new ArrayList();
            for (int i = 0; i < 13; i++){
                for (int j = 0; j < 4; j++) {

               PlayingCard card = new PlayingCard(list.get(i), listTwo.get(j));
               this.cards.add(card);

            }
            Collections.shuffle(cards);

        }

    }


    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public static void setSeed() {

    }
}