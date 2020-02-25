package io.zipcoder.casino.games.specific;

import io.zipcoder.casino.games.DiceGame;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.models.BettingArea;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.CrapsTable;

import java.util.Map;

public class Craps extends Game implements DiceGame {

    private CrapsTable table;
    private Map<Chip, BettingArea> crapsMap;


    @Override
    public void runGame() {

    }
}
