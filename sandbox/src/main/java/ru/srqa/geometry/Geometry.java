package ru.srqa.geometry;

import ru.srqa.geometry.figures.Rectangle;
import ru.srqa.geometry.figures.Square;
import ru.srqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {

        var squares = List.of(new Square(7.0),new Square(5.0),new Square(3.0));
      //  for (Square square : squares) {
       //     Square.printSquareArea(square);
       // }
        Consumer<Square> print = (square) -> {
            Square.printSquareArea(square);
        };
        squares.forEach(print);

       // Rectangle.printRectangleArea(15.0, 3.0);
       // Rectangle.printRectangleArea(7.0, 5.0);

      //  Triangle.printTriangleArea(new Triangle(20.0, 30.0, 15.0));
      //  Triangle.printTriangleArea(new Triangle(3.0, 4.0, 5.0)); // нулевая сторона
      //  Triangle.printTriangleArea(new Triangle(3.0, 4.0, 60.0)); // несу
      //  Triangle.printTrianglePerimeter(new Triangle(3.0, 4.0, 5.0));
      //  Triangle.printTrianglePerimeter(new Triangle(3.0, 0.0, 8.0)); // нулевая сторона
      // Triangle.printTrianglePerimeter(new Triangle(3.0, 4.0, 60.0)); // несущ
    }

}
