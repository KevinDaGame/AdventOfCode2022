package com.github.kevindagame.day3;

public record Item(Character c) {
    public int getPriority() {
        //get Ascci value of char where a = 1 and A = 27
        return c - (Character.isUpperCase(c) ? 38 : 96);

    }
}
