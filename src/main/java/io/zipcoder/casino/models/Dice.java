package io.zipcoder.casino.models;

import java.util.Random;

public class Dice {

    private int numFaces = 6;
    private Random rgen = new Random();

    public int toss() {
        return rgen.nextInt(numFaces) + 1;
    }

    public int getNumFaces() {
        return this.numFaces;
    }

    public void setSeed() {
        this.rgen.setSeed(72);
    }

    public void setNumFaces(int numFaces) {
        this.numFaces = numFaces;
    }
}
