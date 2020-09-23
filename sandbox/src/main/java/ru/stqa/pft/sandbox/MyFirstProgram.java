package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");
        hello("Anastasia");

        Square s = new Square(5);
        System.out.println("Площадь квадртата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        System.out.println("Расстоние между двумя точками c координатами (" + p1.x + ";" + p1.y + ") и (" + p2.x + ";" + p2.y + ") = " + Math.round(p1.distance(p2)*100.0)/100.0);

        Point p3 = new Point(1, 2);
        Point p4 = new Point(3, 4);
        System.out.println("Расстоние между двумя точками c координатами (" + p3.x + ";" + p3.y + ") и (" + p4.x + ";" + p4.y + ") = " + Math.round(p3.distance(p4)*100.0)/100.0);

        Point p5 = new Point(4, 5);
        Point p6 = new Point(10, -3);
        System.out.println("Расстоние между двумя точками c координатами (" + p5.x + ";" + p5.y + ") и (" + p6.x + ";" + p6.y + ") = " + Math.round(p5.distance(p6)*100.0)/100.0);

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}