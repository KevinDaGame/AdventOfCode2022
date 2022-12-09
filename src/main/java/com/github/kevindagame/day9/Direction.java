package com.github.kevindagame.day9;

public enum Direction {
    U(new Vector2(0, -1), "D"),
    D(new Vector2(0, 1), "U"),
    L(new Vector2(-1, 0), "R"),
    R(new Vector2(1, 0), "L");

    private final Vector2 vector;
    private final String opposite;


    Direction(Vector2 vector, String opposite) {
        this.vector = vector;
        this.opposite = opposite;
    }

    public Vector2 getVector() {
        return vector;
    }

    public Direction getOpposite() {
        return Direction.valueOf(opposite);
    }
}
