package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.players.Player;

import javax.smartcardio.Card;

public class GoFish extends Game implements CardGame {


    public boolean pollCard(Card card, Player playerToPoll) {
        return false;
    }

    public boolean getCardFromPlayer(Card card, Player playerToPullFrom) {
        return false;
    }


    @Override
    public void runGame() {

    }
}
