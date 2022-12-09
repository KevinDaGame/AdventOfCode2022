package com.github.kevindagame.day9;

import junit.framework.TestCase;
import org.junit.Test;

public class MainTest extends TestCase {
    @Test
    public void testShouldMove() {
        Main.head = new Vector2(0, 0);
        Main.tail = new Vector2(0, 0);
        assertFalse(Main.shouldMove(cur, prev));
        Main.head = new Vector2(1, 0);
        assertFalse(Main.shouldMove(cur, prev));
        Main.head = new Vector2(1, 1);
        assertFalse(Main.shouldMove(cur, prev));
        Main.head = new Vector2(-1, 0);
        assertFalse(Main.shouldMove(cur, prev));
        Main.head = new Vector2(-1, -1);
        assertFalse(Main.shouldMove(cur, prev));
        Main.tail = new Vector2(1, 0);
        assertTrue(Main.shouldMove(cur, prev));
        Main.head = new Vector2(2,0);
        Main.tail = new Vector2(0,0);
        assertTrue(Main.shouldMove(cur, prev));
    }
}