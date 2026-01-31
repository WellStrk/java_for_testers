package ru.srqa.geometry.figures;

public record Square(double side) {
    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Стороны квадрата не должны быть отрицательными!");
        }
    }


    public static void printSquareArea(Square s) {  //ф-ция, в которой передаётся не число, а объект
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.Area());
        System.out.println(text);
    }

    public double Area() {
        return this.side * this.side; //Данные для вычисления площади берутся не из параметров ф-ции, а из текущего объекта.
    }

    public double perimeter() {
        return this.side * 4;
    }
}
