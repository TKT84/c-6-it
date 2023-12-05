package com.carbon.it.converter;

import com.carbon.it.enums.Movement;
import com.carbon.it.enums.Direction;
import com.carbon.it.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileToDataConverter {

    public static final Logger LOGGER = Logger.getLogger(FileToDataConverter.class.getName());

    public static Cell[][] toMap(List<String> lines) {

        if (lines == null || lines.isEmpty()){
            LOGGER.severe("lines list is null or empty");
            return new Cell[][]{};
        }

        List<Cell[][]> cellsList = lines.stream()
                .filter(line -> !line.startsWith("#"))
                .filter(line -> line.startsWith("C"))
                .map(FileToDataConverter::toMap).collect(Collectors.toList());
        Cell[][] cells;
        if (cellsList.size() == 1) {
            cells =  cellsList.get(0);
        } else {
            // warn
            cells = cellsList.get(cellsList.size() - 1);
        }
        return cells;
    }

    public static Cell[][] toMap(String line) {

        if(line == null) {
            LOGGER.severe("line is null");
            return new Cell[][]{};
        }

        String[] array = toArray(line);

        if (array.length != 3) {
            throw new RuntimeException("Map input does not have the correct Format");
        }

        return new Cell[Integer.parseInt(array[1])][Integer.parseInt(array[2])];
    }

    public static List<Mountain> getMountains(List<String> lines){

        if (lines == null || lines.isEmpty()){
            LOGGER.severe("lines list is null or empty");
            return new ArrayList<>();
        }

        return lines.stream()
                .filter(line -> !line.startsWith("#"))
                .filter(line -> line.startsWith("M"))
                .map(FileToDataConverter::toMountain)
                .collect(Collectors.toList());
    }

    public static List<Treasure> getTreasures(List<String> lines){

        if (lines == null || lines.isEmpty()){
            LOGGER.severe("lines list is null or empty");
            return new ArrayList<>();
        }

        return lines.stream()
                .filter(line -> !line.startsWith("#"))
                .filter(line -> line.startsWith("T"))
                .map(FileToDataConverter::toTreasure)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static Mountain toMountain(String line) {
        Mountain mountain = null;
        String[] array = toArray(line);

        if (array.length == 3) {
            mountain = new Mountain();
            mountain.setHorizontalAxis(Integer.parseInt(array[1]));
            mountain.setVerticalAxis(Integer.parseInt(array[2]));
        } else {
            LOGGER.info("Mountain not in correct format");
        }
        return mountain;
    }

    public static Treasure toTreasure(String line) {
        Treasure treasure = null;
        String[] array = toArray(line);

        if (array.length == 4) {
            treasure = new Treasure();
            treasure.setHorizontalAxis(Integer.parseInt(array[1]));
            treasure.setVerticalAxis(Integer.parseInt(array[2]));
            treasure.setNumberOfTreasure(Integer.parseInt(array[3]));
        } else {
            LOGGER.info("Treasure not in correct format");
        }

        return treasure;
    }

    public static Adventurer toAdventurer(String line) {
        Adventurer adventurer = null;
        String[] array = toArray(line);
        if (array.length == 6) {
            adventurer = new Adventurer();
            adventurer.setName(array[1]);
            adventurer.setHorizontalAxis(Integer.parseInt(array[2]));
            adventurer.setVerticalAxis(Integer.parseInt(array[3]));
            adventurer.setDirection(Direction.getDirection(array[4]));
            adventurer.setMovements(toMovements(array[5]));
        } else {
            LOGGER.info("Adventurer not in correct format");
        }

        return adventurer;
    }

    public static String[] toArray(String line) {

        if (line == null) {
            LOGGER.severe("line is null. cannot convert to array");
            return new String[]{};
        }

        return line.split(" - ");
    }

    public static List<Adventurer> getAdventurers(List<String> lines){

        if (lines == null || lines.isEmpty()){
            LOGGER.severe("lines list is null or empty");
            return new ArrayList<>();
        }
        return lines.stream()
                .filter(line -> !line.startsWith("#"))
                .filter(line -> line.startsWith("A"))
                .map(FileToDataConverter::toAdventurer)
                .collect(Collectors.toList());
    }

    public static List<Movement> toMovements(String movementsStr) {

        if(movementsStr == null) {
            LOGGER.severe("movementsStr is null");
            return new ArrayList<>();
        }

        List<Movement> movements = new ArrayList<>();

        for (char c : movementsStr.toCharArray()) {
            movements.add(Movement.getMovement(c));
        }
        return movements;
    }

}
