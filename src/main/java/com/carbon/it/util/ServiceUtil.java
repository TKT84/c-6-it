package com.carbon.it.util;

import com.carbon.it.model.Cell;

public class ServiceUtil {

    public static boolean canBePlacedOnMap(Cell[][] cells, Cell cell){
        return cell.getHorizontalAxis() >= 0
                && cell.getVerticalAxis() >= 0
                && cells.length > cell.getHorizontalAxis()
                && cells[0].length > cell.getVerticalAxis();
    }
}
