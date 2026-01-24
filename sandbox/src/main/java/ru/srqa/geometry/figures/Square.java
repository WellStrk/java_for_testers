package ru.srqa.geometry.figures;

public class Square {
    private static double squareArea(double a) {
        return a * a;
    }

    public static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }
}
