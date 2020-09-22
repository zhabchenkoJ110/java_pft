package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1() {
        Point p1 = new Point(1,2,3,4);
        Assert.assertEquals(p1.distance(), 2.8284271247461903);
    }

    @Test
    public void testDistance2() {
        Point p2 = new Point(1,1,2,2);
        Assert.assertEquals(p2.distance(), 1.4142135623730951);
    }

    @Test
    public void testDistance3() {
        Point p3 = new Point(4,5,10,-3);
        Assert.assertEquals(p3.distance(), 10.0);
    }

}
