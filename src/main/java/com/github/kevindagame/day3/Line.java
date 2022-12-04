package com.github.kevindagame.day3;

import javax.naming.directory.Attribute;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Item> items = new ArrayList<>();

    public Line(String line) {
        for(Character c: line.toCharArray()) {
            items.add(new Item(c));
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public int getValueOfRecurringItem() {
        //split the item list in half
        //find the item that occurs in both halves
        //return value of that item
        var half = items.size() / 2;
        var leftSIte = items.subList(0, half);
        var rightSide = items.subList(half, items.size());
        for(Item i: leftSIte) {
            if(rightSide.contains(i)) {
                return i.getPriority();
            }
        }
        return 0;
    }
}
