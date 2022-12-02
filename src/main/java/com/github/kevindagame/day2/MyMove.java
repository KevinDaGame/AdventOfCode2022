package com.github.kevindagame.day2;

public enum MyMove {
    X(RPS.ROCK, Outcome.LOSE),
    Y(RPS.PAPER, Outcome.TIE),
    Z(RPS.SCISSORS, Outcome.WIN),
    ;

    private final RPS rps;
    private final Outcome outCome;

    MyMove(RPS rps, Outcome outcome) {
        this.rps = rps;
        this.outCome = outcome;
    }

    public RPS getMove() {
        return rps;
    }

    public Outcome getOutCome() {
        return outCome;
    }
}
