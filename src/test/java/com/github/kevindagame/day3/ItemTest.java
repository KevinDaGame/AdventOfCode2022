package com.github.kevindagame.day3;

import junit.framework.TestCase;

public class ItemTest extends TestCase {

    public void testGetPriority() {
        Item i = new Item('a');
        assertEquals(1, i.getPriority());
        i = new Item('b');
        assertEquals(2, i.getPriority());
        i = new Item('A');
        assertEquals(27, i.getPriority());
        i = new Item('B');
        assertEquals(28, i.getPriority());
    }
}