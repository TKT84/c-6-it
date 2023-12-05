package com.carbon.it.enums;

public enum Movement {
    MOVE_FORWARD('A'),
    MOVE_LEFT('G'),
    MOVE_RIGHT('D');

    Movement(char movement) {
        this.movement = movement;
    }

    public char movement;

    public static Movement getMovement(char c) {

        if (c == 0) {
            return null;
        }
        Movement  movement = null;
        for(Movement item : Movement.values()) {

            if (item.movement == c) {
                movement = item;
            }
        }
        return movement;
    }

    public char getMovement() {
        return movement;
    }

    public void setMovement(char movement) {
        this.movement = movement;
    }
}
