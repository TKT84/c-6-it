package com.carbon.it.model;

import java.util.Arrays;
import java.util.List;

public class Map {

    Cell[][] cells;

    public Map(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public char getCharacter() {
            return 'C';
    }

    @Override
    public String toString() {
        return getCharacter() + " - "
                + cells.length + " - "
                + cells[0].length;
    }
}
