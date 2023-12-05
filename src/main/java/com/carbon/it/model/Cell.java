package com.carbon.it.model;

public class Cell {

    public int horizontalAxis;
    public int verticalAxis;
    public boolean isMountain;
    public boolean isTreasure;
    public boolean isPlain;
    public boolean isAdventurer;
    public int treasures;

    public char character;

    private Adventurer adventurer;

    public int getHorizontalAxis() {
        return horizontalAxis;
    }

    public void setHorizontalAxis(int horizontalAxis) {
        this.horizontalAxis = horizontalAxis;
    }

    public int getVerticalAxis() {
        return verticalAxis;
    }

    public void setVerticalAxis(int verticalAxis) {
        this.verticalAxis = verticalAxis;
    }

    public boolean isMountain() {
        return isMountain;
    }

    public void setMountain(boolean mountain) {
        isMountain = mountain;
    }

    public boolean isTreasure() {
        return isTreasure;
    }

    public void setTreasure(boolean treasure) {
        isTreasure = treasure;
    }

    public boolean isPlain() {
        return isPlain;
    }

    public void setPlain(boolean plain) {
        isPlain = plain;
    }

    public boolean isAdventurer() {
        return isAdventurer;
    }

    public void setAdventurer(boolean adventurer) {
        isAdventurer = adventurer;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "horizontalAxis=" + horizontalAxis +
                ", verticalAxis=" + verticalAxis +
                ", isMountain=" + isMountain +
                ", isTreasure=" + isTreasure +
                ", isPlain=" + isPlain +
                ", isAdventurer=" + isAdventurer +
                ", treasures=" + treasures +
                ", character=" + character +
                ", adventurer=" + adventurer +
                '}';
    }
}
