package ru.srqa.geometry.figures;

public class Square {
    private static double squareArea(double a) {
        return a * a;
    }

    public static void printSquareArea(double side) {
        String text = String.format("Площадь квадрата со стороной %f = %f", side, squareArea(side));
        System.out.println(text);
    }
}
