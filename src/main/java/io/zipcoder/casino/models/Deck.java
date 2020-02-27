package io.zipcoder.casino.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static io.zipcoder.casino.models.PlayingCard.Rank.*;
import static io.zipcoder.casino.models.PlayingCard.Suit.*;

public class Deck {

    private ArrayList<PlayingCard> cards;
    private int deckSize;
    private Random generator;
    private ArrayList<PlayingCard.Rank> ranks;
    private ArrayList<PlayingCard.Suit> suits;

    public Deck() {
        this(52);
    }

    public Deck(int deckSize) {
        this.generator = new Random();
        this.deckSize = deckSize;
        this.ranks = fillRanks();
        this.suits = fillSuits();
        this.cards = generateDeck();
    }

    public ArrayList<PlayingCard.Rank> fillRanks() {
        ArrayList<PlayingCard.Rank> newRanks = new ArrayList<>();
        newRanks.add(ACE);
        newRanks.add(TWO);
        newRanks.add(THREE);
        newRanks.add(FOUR);
        newRanks.add(FIVE);
        newRanks.add(SIX);
        newRanks.add(SEVEN);
        newRanks.add(EIGHT);
        newRanks.add(NINE);
        newRanks.add(TEN);
        newRanks.add(JACK);
        newRanks.add(QUEEN);
        newRanks.add(KING);
        return newRanks;
    }

    public ArrayList<PlayingCard.Suit> fillSuits() {
        ArrayList<PlayingCard.Suit> newSuits = new ArrayList<>();
        newSuits.add(HEARTS);
        newSuits.add(SPADES);
        newSuits.add(CLUBS);
        newSuits.add(DIAMONDS);
        return newSuits;
    }

    public ArrayList<PlayingCard> generateRandomCards(int amt) {
        ArrayList<PlayingCard> newCards = new ArrayList<>();
        while (newCards.size() < amt) {
            PlayingCard.Rank randRank = ranks.get(this.generator.nextInt(ranks.size()));
            PlayingCard.Suit randSuit = suits.get(this.generator.nextInt(suits.size()));
            PlayingCard randCard = new PlayingCard(randRank, randSuit);
            newCards.add(randCard);
        }
        return newCards;
    }

    public ArrayList<PlayingCard> generateDeck() {
        ArrayList<PlayingCard> newDeck = new ArrayList<>();
        if (this.deckSize >= 52) {
            for (int i = 0; i < ranks.size(); i++) {
                for (int j = 0; j < suits.size(); j++) {
                    PlayingCard card = new PlayingCard(ranks.get(i), suits.get(j));
                    newDeck.add(card);
                }
            }
            int cardsNeeded = this.deckSize - newDeck.size();
            if (cardsNeeded > 0) {
                newDeck.addAll(generateRandomCards(cardsNeeded));
            }
        } else {
            newDeck.addAll(generateRandomCards(this.deckSize));
        }
        Collections.shuffle(newDeck);
        return newDeck;
    }

    public ArrayList<PlayingCard> draw(int amt) {
        ArrayList<PlayingCard> toDraw = new ArrayList<>();
        int drawsLeft = amt;
        while (drawsLeft > 0 && this.cards.size() > 0) {
            toDraw.add(this.cards.remove(generator.nextInt(this.cards.size())));
            drawsLeft--;
        }
        return toDraw;
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public void setSeed() {
        this.generator.setSeed(55);
    }
}