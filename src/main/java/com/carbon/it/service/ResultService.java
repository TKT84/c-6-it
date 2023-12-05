package com.carbon.it.service;

import com.carbon.it.converter.DataToFileConverter;
import com.carbon.it.converter.FileToDataConverter;
import com.carbon.it.model.Cell;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ResultService {

    public static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());

    public static Cell[][] placeAndMoveItemsOnMap(List<String> stringList){

        if (stringList == null || stringList.isEmpty()) {
            LOGGER.info("No map Found.");
            return new Cell[][]{};
        }
        Cell[][] cells = FileToDataConverter.toMap(stringList);
        cells = MapService.placePlainsOnMap(cells);
        cells = MapService.placeMountainsOnMap(cells, FileToDataConverter.getMountains(stringList));
        cells = MapService.placeTreasuresOnMap(cells, FileToDataConverter.getTreasures(stringList));
        cells = MapService.placeAdventurersOnMap(cells, FileToDataConverter.getAdventurers(stringList));
        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(stringList));
        return cells;
    }

    public static List<String> getResults(Cell[][] cells) {

        List<String> list = new ArrayList<>();
        list.add(DataToFileConverter.toMap(cells).toString());

        for(Cell[] cellArray : cells) {
            for(Cell cell : cellArray) {
                if(cell.isTreasure()) {
                    list.add(DataToFileConverter.toTreasure(cell).toString());
                }
                if (cell.isMountain()) {
                    list.add(DataToFileConverter.toMountain(cell).toString());
                }
            }
        }
        list.addAll(Arrays.stream(cells)  //'array' is two-dimensional
                .flatMap(Arrays::stream)
                        .filter(cell -> cell.isAdventurer() || cell.getAdventurer() != null)
                .map(cell -> DataToFileConverter.toAdventurer(cell).toString())
                .collect(Collectors.toList()));
        return list;
    }

}
