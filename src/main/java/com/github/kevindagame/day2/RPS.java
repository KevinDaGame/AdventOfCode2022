package com.github.kevindagame.day2;

public enum RPS {
    ROCK(1, "PAPER", "SCISSORS"),
    PAPER(2, "SCISSORS", "ROCK"),
    SCISSORS(3, "ROCK", "PAPER");

    private final int val;
    private final String lose;
    private final String win;

    RPS(int i, String lose, String win) {
        this.val = i;
        this.lose = lose;
        this.win = win;
    }

    public int getVal() {
        return val;
    }

    public RPS getLose() {
        return RPS.valueOf(lose);
    }

    public RPS getWin() {
        return RPS.valueOf(win);
    }
}
