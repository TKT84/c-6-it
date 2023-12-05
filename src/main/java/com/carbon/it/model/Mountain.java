package com.carbon.it.model;

public class Mountain extends Cell{

    public boolean isMountain() {
        return true;
    }

    @Override
    public char getCharacter() {
        return 'M';
    }

    @Override
    public String toString() {
        return getCharacter() + " - "
                + horizontalAxis + " - "
                + verticalAxis;
    }
}
