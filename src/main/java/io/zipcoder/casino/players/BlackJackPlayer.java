package io.zipcoder.casino.players;

import io.zipcoder.casino.games.specific.BlackJack;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.Deck;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.models.Wallet;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class BlackJackPlayer extends CardPlayer {

    private Wallet myWallet = new Wallet();
    private ArrayList<PlayingCard> splitHand;
    private int handValue;
    private int splitValue;

    // For tests
    public BlackJackPlayer(String name) {
        super(name);
    }

    public BlackJackPlayer(String name, String password, Wallet wallet) {
        super(name, password, wallet);
    }

    public BlackJackPlayer(Player player) {
        super(player.getName(), player.getPassword(), player.getWallet());
    }


    public void doubleDown(PlayingCard card, Chip chip) {
        addCardToHand(card);
        myWallet.subChip(chip);
    }

    public boolean split() {
        return false;
    }
}
