package com.carbon.it.service;

import com.carbon.it.constants.MapConstant;
import com.carbon.it.enums.Direction;
import com.carbon.it.model.Adventurer;
import com.carbon.it.model.Cell;
import com.carbon.it.util.ServiceUtil;

import java.util.logging.Logger;

public class AdventurerService {

    public static final Logger LOGGER = Logger.getLogger(AdventurerService.class.getName());

    public static void faceRight(Adventurer adventurer) {

        if (adventurer.getDirection() == Direction.NORTH) {
            adventurer.setDirection(Direction.EAST);
        }

        if (adventurer.getDirection() == Direction.SOUTH) {
            adventurer.setDirection(Direction.WEST);
        }

        if (adventurer.getDirection() == Direction.EAST) {
            adventurer.setDirection(Direction.SOUTH);
        }

        if (adventurer.getDirection() == Direction.SOUTH) {
            adventurer.setDirection(Direction.NORTH);
        }
    }

    public static void faceLeft(Adventurer adventurer) {

        if (adventurer.getDirection() == Direction.NORTH) {
            adventurer.setDirection(Direction.WEST);
        }

        if (adventurer.getDirection() == Direction.SOUTH) {
            adventurer.setDirection(Direction.EAST);
        }

        if (adventurer.getDirection() == Direction.EAST) {
            adventurer.setDirection(Direction.NORTH);
        }

        if (adventurer.getDirection() == Direction.SOUTH) {
            adventurer.setDirection(Direction.NORTH);
        }
    }

    public static Cell getNextCell(Cell[][] cells, Adventurer adventurer) {

        if (adventurer.getDirection() == Direction.NORTH) {
            adventurer.setVerticalAxis(adventurer.getVerticalAxis() - 1);
            adventurer.setHorizontalAxis(adventurer.getHorizontalAxis());
        }

        if (adventurer.getDirection() == Direction.SOUTH) {
            adventurer.setVerticalAxis(adventurer.getVerticalAxis() + 1);
            adventurer.setHorizontalAxis(adventurer.getHorizontalAxis());
        }

        if (adventurer.getDirection() == Direction.EAST) {
            adventurer.setVerticalAxis(adventurer.getVerticalAxis());
            adventurer.setHorizontalAxis(adventurer.getHorizontalAxis() + 1);
        }

        if (adventurer.getDirection() == Direction.WEST) {
            adventurer.setVerticalAxis(adventurer.getVerticalAxis());
            adventurer.setHorizontalAxis(adventurer.getHorizontalAxis() - 1);
        }

        int horizontalAxis = adventurer.getHorizontalAxis();
        int verticalAxis = adventurer.getVerticalAxis();

        if(!ServiceUtil.canBePlacedOnMap(cells, adventurer)) {

            if(horizontalAxis < 0) {
                LOGGER.warning("Adventurer " + adventurer.getName() + " cannot advance any further");
                horizontalAxis = 0;
            }

            if(horizontalAxis > cells.length - 1) {
                LOGGER.warning("Adventurer " + adventurer.getName() + " cannot advance any further");
                horizontalAxis = cells.length - 1;
            }

            if(verticalAxis < 0) {
                LOGGER.warning("Adventurer " + adventurer.getName() + " cannot advance any further");
                verticalAxis = 0;
            }

            if(verticalAxis > cells[0].length - 1) {
                LOGGER.warning("Adventurer " + adventurer.getName() + " cannot advance any further");
                verticalAxis = cells[0].length - 1;
            }
        }

        Cell cell = cells[horizontalAxis][verticalAxis];
        cell.setVerticalAxis(verticalAxis);
        cell.setHorizontalAxis(horizontalAxis);
        return cell;
    }

    public static Cell[][] moveForward(Cell[][] cells, Adventurer adventurer) {

        if(!ServiceUtil.canBePlacedOnMap(cells, adventurer)) {
            LOGGER.warning(MapConstant.CANNOT_SET_ADVENTURER_COORDINATES_ARE_OUTSIDE_OF_MAP);
        } else {
            Cell currentCell = cells[adventurer.getHorizontalAxis()][adventurer.getVerticalAxis()];
            Cell nextCell = getNextCell(cells, adventurer);

            if (nextCell.isMountain() || nextCell.isAdventurer()) {
                LOGGER.info("Cannot set adventurer on coordinates, there is a mountain or an adventurer on it");
                nextCell = currentCell;
                adventurer.setVerticalAxis(nextCell.getVerticalAxis());
                adventurer.setHorizontalAxis(nextCell.getHorizontalAxis());
                nextCell.setAdventurer(adventurer);
                return cells;
            } else {
                currentCell.setAdventurer(null);
                currentCell.setAdventurer(false);

                if (nextCell.isTreasure() && nextCell.getTreasures() > 0) {
                    nextCell.setTreasures(nextCell.getTreasures() - 1);
                    adventurer.setTreasures(adventurer.getTreasures() + 1);

                    if (nextCell.getTreasures() == 0) {
                        nextCell.setTreasure(false);
                    }
                }
                nextCell.setAdventurer(true);
                nextCell.setAdventurer(adventurer);
            }
        }
        return cells;
    }
}
