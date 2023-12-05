package com.carbon.it.converter;

import com.carbon.it.model.*;

public class DataToFileConverter {

    public static Adventurer toAdventurer(Cell cell) {

        if (!cell.isAdventurer()) {
            return null;
        }

        return cell.getAdventurer() != null ? cell.getAdventurer() : null;
    }

    public static Mountain toMountain(Cell cell) {

        if (!cell.isMountain()) {
            return null;
        }

        Mountain mountain = new Mountain();
        mountain.setHorizontalAxis(cell.getHorizontalAxis());
        mountain.setVerticalAxis(cell.getVerticalAxis());
        return mountain;
    }

    public static Treasure toTreasure (Cell cell) {

        if (!cell.isTreasure()) {
            return null;
        }

        Treasure treasure = new Treasure();
        treasure.setNumberOfTreasure(cell.getTreasures());
        treasure.setHorizontalAxis(cell.getHorizontalAxis());
        treasure.setVerticalAxis(cell.getVerticalAxis());
        return treasure;
    }

    public static Map toMap(Cell[][] cells) {

        if (cells == null) {
            return null;
        }

        return new Map(cells);
    }
}
