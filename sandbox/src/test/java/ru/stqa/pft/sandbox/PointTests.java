package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Assert.assertEquals(Math.round(p1.distance(p2)*100.0)/100.0, 1.41);
    }

    @Test
    public void testDistance2() {
        Point p3 = new Point(1, 2);
        Point p4 = new Point(3, 4);
        Assert.assertEquals(Math.round(p3.distance(p4)*100.0)/100.0, 2.83);
    }

    @Test
    public void testDistance3() {
        Point p5 = new Point(4, 5);
        Point p6 = new Point(10, -3);
        Assert.assertEquals(Math.round(p5.distance(p6)*100.0)/100.0, 10.0);
    }

}
