package com.github.kevindagame.day9;

public class Move {
    Direction direction;
    int amount;

    public Move(String s) {
        var split = s.split(" ");
        direction = Direction.valueOf(split[0]);
        amount = Integer.parseInt(split[1]);
    }

    @Override
    public String toString() {
        return "Move{" +
                "direction=" + direction +
                ", amount=" + amount +
                '}';
    }
}
