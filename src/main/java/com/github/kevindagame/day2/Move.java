package com.github.kevindagame.day2;

public record Move(OtherMove other, MyMove mine) {
    int getPoints() {
        return getOutcome(other.getMove(), mine.getMove()).getVal() + mine.getMove().getVal();
    }

    int getPoints2() {
        return getOutcome(other.getMove(), getMove()).getVal() + getMove().getVal();
    }

    RPS getMove() {
        // if mine.getOutcome == lose then pick the losing move
        // if mine.getOutcome == tie then pick the tie move
        // if mine.getOutcome == win then pick the winning move
        return switch (mine.getOutCome()) {
            case LOSE -> other.getMove().getWin();
            case TIE -> other.getMove();
            case WIN -> other.getMove().getLose();
            default -> null;
        };
    }
    Outcome getOutcome(RPS other, RPS mine) {
        if(other.getWin() == mine) return Outcome.LOSE;
        if(other.getLose() == mine) return Outcome.WIN;
        return Outcome.TIE;

    }
}
