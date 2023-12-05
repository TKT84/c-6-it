package com.carbon.it.model;

public class Treasure extends Cell{

    public int numberOfTreasure;

    public int getNumberOfTreasure() {
        return numberOfTreasure;
    }

    public void setNumberOfTreasure(int numberOfTreasure) {
        this.numberOfTreasure = numberOfTreasure;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    public char getCharacter() {
        return 'T';
    }

    @Override
    public String toString() {
        return getCharacter() + " - "
                + horizontalAxis + " - "
                + verticalAxis + " - "
                + numberOfTreasure;
    }
}
