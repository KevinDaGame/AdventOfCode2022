package com.github.kevindagame.day2;

public enum Outcome {
    WIN(6),
    TIE(3),
    LOSE(0);

    private final int val;

    Outcome(int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }
}
