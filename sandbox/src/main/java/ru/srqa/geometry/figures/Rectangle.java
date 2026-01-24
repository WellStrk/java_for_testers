package ru.srqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double side1, double side2) {
        System.out.println("Площадь прямоугольника со сторонами " + side1 + " и " + side2 + " = " + RectangleArea(side1, side2));
    }

    private static double RectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
