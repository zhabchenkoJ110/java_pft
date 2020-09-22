package ru.stqa.pft.sandbox;

public class Point {

    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Point(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return (Math.sqrt((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1)));
    }

//    public static double distance(Point p1, Point p2) {
//        return (Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)));
//    }


//    Point p1 = new Point(1, 1);
//    Point p2 = new Point(2, 2);
//        System.out.println("Расстоние между двумя точками: " + distance(p1,p2));

}
