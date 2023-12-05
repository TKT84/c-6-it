package com.carbon.it.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    public String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public static Direction getDirection(String direction) {

        Optional<Direction> optionalDirection =  Arrays.asList(Direction.values())
                .stream()
                .filter(d -> direction.equals(d.direction))
                .findFirst();

        return optionalDirection.isPresent() ? optionalDirection.get() : null;
    }
}
