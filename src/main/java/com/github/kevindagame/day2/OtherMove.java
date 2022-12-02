package com.github.kevindagame.day2;

public enum OtherMove {
    A(RPS.ROCK),
    B(RPS.PAPER),
    C(RPS.SCISSORS);

    private final RPS rps;

    OtherMove(RPS rps) {
        this.rps = rps;
    }

    public RPS getMove() {
        return rps;
    }
}
