package com.github.kevindagame.day3;

public record Group(Line[] lines) {

    public int getSharedItemValue() {
        //get the character that occurs in each line of lines
        //return the character
        for (Item c: lines[0].getItems()) {
            if(lines[1].getItems().contains(c) && lines[2].getItems().contains(c)) {
                return c.getPriority();
            }
        }
        throw new RuntimeException("No shared item found");
    }
}
