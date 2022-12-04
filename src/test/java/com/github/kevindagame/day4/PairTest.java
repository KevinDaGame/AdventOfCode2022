package com.github.kevindagame.day4;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PairTest {
    @Test
    public void pairTest() {
        var input = "3-6,4-6";
        var p = new Pair(input);
        Assert.assertEquals(3, p.getR1().min());
        Assert.assertEquals(6, p.getR1().max());
        Assert.assertEquals(4, p.getR2().min());
        Assert.assertEquals(6, p.getR2().max());
    }

    @Test
    public void testHasOverlap() {
        var input = "1-4,4-8";
        var p = new Pair(input);
        Assert.assertEquals(1, p.hasOverlap());
    }
}