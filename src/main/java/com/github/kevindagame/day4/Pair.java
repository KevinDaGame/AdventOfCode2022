package com.github.kevindagame.day4;

public class Pair {
    private Range r1;
    private Range r2;

    public Pair(String line) {
        var split = line.split(",");
        var range1 = split[0].split("-");
        var range2 = split[1].split("-");
        r1 = new Range(Integer.parseInt(range1[0]), Integer.parseInt(range1[1]));
        r2 = new Range(Integer.parseInt(range2[0]), Integer.parseInt(range2[1]));
    }

    public Range getR1() {
        return r1;
    }

    public Range getR2() {
        return r2;
    }

    public int oneContainsTheOther() {
        return (r1.containsRange(r2) || r2.containsRange(r1)) ? 1 : 0;
    }

    public int hasOverlap() {
        return r1.hasOverlap(r2) ? 1 : 0;
    }
}
