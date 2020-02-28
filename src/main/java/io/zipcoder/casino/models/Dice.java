package io.zipcoder.casino.models;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int numFaces;
    private Random rgen;

    public Dice() {
        this(6);
    }

    public Dice(int numFaces) {
        this.numFaces = numFaces;
        this.rgen = new Random();
    }

    public int toss() {
        return rgen.nextInt(numFaces) + 1;
    }

    public int getNumFaces() {
        return this.numFaces;
    }

    public void setSeed() {
        this.rgen.setSeed(72);
    }

    public void setSeed(Long seed) {
        this.rgen.setSeed(seed);
    }

    public void setNumFaces(int numFaces) {
        this.numFaces = numFaces;
    }
}
