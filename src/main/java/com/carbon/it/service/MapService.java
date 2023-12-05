package com.carbon.it.service;

import com.carbon.it.enums.Movement;
import com.carbon.it.model.Adventurer;
import com.carbon.it.model.Cell;
import com.carbon.it.model.Mountain;
import com.carbon.it.model.Treasure;
import com.carbon.it.util.ServiceUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapService {

    public static final Logger LOGGER = Logger.getLogger(MapService.class.getName());

    public static Cell[][] placePlainsOnMap(Cell[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                Cell cell = new Cell();
                cell.setPlain(true);
                cells[i][j] = cell;
            }
        }
        return cells;
    }

    public static Cell[][] placeAdventurersOnMap(Cell[][] cells, List<Adventurer> adventurers) {

        for(Adventurer adventurer : adventurers) {

            if(!ServiceUtil.canBePlacedOnMap(cells, adventurer)) {
                LOGGER.warning("Cannot set Adventurer outside of map");
                continue;
            }

            Cell cell = cells[adventurer.getHorizontalAxis()][adventurer.getVerticalAxis()];
            if (cell.isMountain()) {
                LOGGER.log(Level.INFO, "Cannot set Adventurer, cell is Mountain");
            } else if(cell.isAdventurer()) {
                LOGGER.log(Level.INFO, "Cannot set Adventurer, Adventurer already present");
            } else {
                cell.setAdventurer(adventurer.isAdventurer());
                cell.setAdventurer(adventurer);
                cell.setHorizontalAxis(adventurer.getHorizontalAxis());
                cell.setVerticalAxis(adventurer.getVerticalAxis());
                if(cell.isTreasure()){
                    cell.setTreasures(cell.getTreasures() - 1);
                }
            }
        }
        return cells;
    }

    public static Cell[][] placeTreasuresOnMap(Cell[][] cells, List<Treasure> treasures) {

        for(Treasure treasure : treasures) {

            if(!ServiceUtil.canBePlacedOnMap(cells, treasure)) {
                LOGGER.warning("Cannot set Treasure outside of Map");
                continue;
            }

            Cell cell = cells[treasure.getHorizontalAxis()][treasure.getVerticalAxis()];
            if (cell.isMountain()) {
                LOGGER.info("Cannot set Treasure, cell is Mountain");
            } else {
                cell.setTreasure(treasure.isTreasure());
                cell.setPlain(false);
                cell.setTreasures(treasure.getNumberOfTreasure());
                cell.setHorizontalAxis(treasure.getHorizontalAxis());
                cell.setVerticalAxis(treasure.getVerticalAxis());
            }
        }

        return cells;
    }

    public static Cell[][] placeMountainsOnMap(Cell[][] cells, List<Mountain> mountains) {

        for(Mountain mountain : mountains) {

            if(!ServiceUtil.canBePlacedOnMap(cells, mountain)) {
                LOGGER.warning("Cannot set Mountain outside of Map");
                continue;
            }

            Cell cell = cells[mountain.getHorizontalAxis()][mountain.getVerticalAxis()];
            if (cell.isMountain()) {
                LOGGER.log(Level.INFO, "Cannot set Mountain, cell is already a Mountain");
            } else {
                cell.setMountain(mountain.isMountain());
                cell.setHorizontalAxis(mountain.getHorizontalAxis());
                cell.setVerticalAxis(mountain.getVerticalAxis());
                cell.setPlain(false);
            }
        }
        return cells;
    }

    public static Cell[][] move(Cell[][] cells, Adventurer adventurer, Movement movement) {

        if (Movement.getMovement(movement.getMovement()) == Movement.MOVE_FORWARD) {
            cells = AdventurerService.moveForward(cells, adventurer);
        }
        if (Movement.getMovement(movement.getMovement()) == Movement.MOVE_LEFT) {
            AdventurerService.faceLeft(adventurer);
        }
        if (Movement.getMovement(movement.getMovement()) == Movement.MOVE_RIGHT) {
            AdventurerService.faceRight(adventurer);
        }
        return cells;
    }

    public static Cell[][] moveAcrossMap(Cell[][] cells, Adventurer adventurer) {
        for(Movement movement : adventurer.getMovements()) {
            cells = move(cells, adventurer, movement);
        }
        return cells;
    }

    public static Cell[][] moveAdventurers(Cell[][] cells, List<Adventurer> adventurerList) {

        for (Adventurer adventurer : adventurerList) {
            cells = moveAcrossMap(cells, adventurer);
        }
        return cells;
    }

    public static void displayMap(Cell[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if(cells[i][j] != null) {
                    cells[i][j].toString();
                }
            }
        }
    }
}
