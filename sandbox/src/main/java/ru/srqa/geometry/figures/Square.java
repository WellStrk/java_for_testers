package ru.srqa.geometry.figures;

public class Square {
    public static double Area(double a) {
        return a * a;
    }

    public static void printSquareArea(double side) {
        String text = String.format("Площадь квадрата со стороной %f = %f", side, Area(side));
        System.out.println(text);
    }

    public static double perimeter(double a) {
        return a * 4;
    }
}
