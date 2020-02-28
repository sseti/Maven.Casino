package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.utilities.MenuStrings;

import java.util.ArrayList;
import java.util.Random;


public class GoFishNPC extends CardPlayer {

    private int gameDrawAmt;
    private String name;
    private Random rng;
    private ArrayList<String> welcomeMessages;

    public GoFishNPC() {
        this(MenuStrings.getRandomOpponentName(), 1, new ArrayList<>());
    }

    public GoFishNPC(String name, int drawAmt, ArrayList<String> welcomeMessages) {
        super(name);
        this.rng = new Random();
        this.gameDrawAmt = drawAmt;
        this.welcomeMessages = new ArrayList<>();
        this.welcomeMessages.addAll(welcomeMessages);
    }

    public String generateWelcomeMessage() {
       return (this.welcomeMessages.size() > 0) ? this.welcomeMessages.get(this.rng.nextInt(this.welcomeMessages.size())) : "Hello and good luck!";
    }

    public PlayingCard generateCardToAsk() {
        return (this.getHand().size() > 0) ? this.getHand().get(this.rng.nextInt(this.getHand().size())) : null;
    }

    private void updateName() {
        if (this.welcomeMessages.size() < 1) {
            this.welcomeMessages.add("Hello, I am " + this.name + ". Good luck!");
        }
    }

    public boolean hasCard(PlayingCard card) {
        return (this.getHand().size() > 0) ? this.getHand().contains(card) : false;
    }

    public Boolean goFish(Deck gameDeck) {
        int size = this.getHand().size();
        this.getHand().addAll(gameDeck.draw(this.gameDrawAmt));
        int afterDrawSize = this.getHand().size();
        return afterDrawSize - this.gameDrawAmt == size;
    }

    public void setGameDrawAmt(int gameDrawAmt) {
        this.gameDrawAmt = gameDrawAmt;
    }

}
