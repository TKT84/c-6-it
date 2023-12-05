package com.carbon.it.model;

import com.carbon.it.enums.Movement;
import com.carbon.it.enums.Direction;

import java.util.List;

public class Adventurer extends Cell {

    public String name;
    public int treasures;
    public Direction direction;
    public List<Movement> movements;

    public Adventurer() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public boolean isAdventurer() {
        return true;
    }

    @Override
    public char getCharacter() {
        return 'A';
    }

    @Override
    public int getHorizontalAxis() {
        return super.getHorizontalAxis();
    }

    @Override
    public int getVerticalAxis() {
        return super.getVerticalAxis();
    }

    @Override
    public String toString() {
        return getCharacter() + " - "
                + name + " - "
                + horizontalAxis + " - "
                + verticalAxis + " - "
                + direction.direction + " - "
                + treasures;
    }
}
