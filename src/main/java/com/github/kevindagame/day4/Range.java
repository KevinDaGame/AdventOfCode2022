package com.github.kevindagame.day4;

public record Range(int min, int max) {
    public boolean containsRange(Range r) {
        return min <= r.min && max >= r.max;
    }

    public boolean contains(int i) {
        return i >= min && i <= max;
    }

    public boolean hasOverlap(Range r) {
        for (int i = min; i <= max; i++) {
            if (r.contains(i)) return true;
        }
        return false;
    }
}
