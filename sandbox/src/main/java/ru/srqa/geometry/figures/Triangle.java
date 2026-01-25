package ru.srqa.geometry.figures;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static void printTriangleArea(Triangle ABC) {
        if (!ABC.isTriangleExist()) {
            System.out.println("Такого треугольника не существует!");
            return;
        }
        var text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", ABC.side1, ABC.side2, ABC.side3, ABC.Area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle ABC) {
        if (!ABC.isTriangleExist()) {
            System.out.println("Такого треугольника не существует!");
            return;
        }
        var text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", ABC.side1, ABC.side2, ABC.side3, ABC.Perimeter());
        System.out.println(text);
    }


    public double Area() {

        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public double Perimeter() {

        return side1 + side2 + side3;
    }

    public boolean isTriangleExist() {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        }
        if (side1 + side2 <= side3) {
            return false;
        }
        if (side3 + side2 <= side1) {
            return false;
        }
        if (side1 + side3 <= side2) {
            return false;
        }
        return true;
    }
   }
