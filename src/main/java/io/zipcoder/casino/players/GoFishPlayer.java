package io.zipcoder.casino.players;

import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;

import javax.smartcardio.Card;
import java.util.Collections;

public class GoFishPlayer extends CardPlayer {

    private int gameDrawAmt;

    public GoFishPlayer(Player player, int gameDrawAmt) {
        super(player.getName(), player.getPassword(), player.getWallet());
        this.gameDrawAmt = gameDrawAmt;
    }

    public GoFishPlayer(Player player) {
        this(player, 1);
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
