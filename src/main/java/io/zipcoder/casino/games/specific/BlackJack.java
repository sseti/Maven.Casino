package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.Chip;

import java.util.ArrayList;

public class BlackJack extends Game implements CardGame {

    private ArrayList<Chip> bets;
    private boolean doesPlayerWin;

    public void newDeal() {

    }
    public boolean placeBet(int dollarAmt){return false;}

    public boolean placeBet(ArrayList<Chip> chips){return false;}

    @Override
    public void runGame() {

    }
}
