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


        Point p1 = new Point(1,2,3,4);
        System.out.println("Расстоние между двумя точками c координатами (" + p1.x1+";" + p1.y1 +") и (" + p1.x2+";" + p1.y2 +") = "   + p1.distance());

        Point p2 = new Point(1,1,2,2);
        System.out.println("Расстоние между двумя точками c координатами (" + p2.x1+";" + p2.y1 +") и (" + p2.x2+";" + p2.y2 +") = "   + p2.distance());

        Point p3 = new Point(4,5,10,-3);
        System.out.println("Расстоние между двумя точками c координатами (" + p3.x1+";" + p3.y1 +") и (" + p3.x2+";" + p3.y2 +") = "   + p3.distance());

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}