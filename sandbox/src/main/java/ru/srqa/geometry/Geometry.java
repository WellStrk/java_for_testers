package ru.srqa.geometry;

import ru.srqa.geometry.figures.Rectangle;
import ru.srqa.geometry.figures.Square;
import ru.srqa.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);

        Consumer<Square> print = (square) -> {
            Square.printSquareArea(square);
            Square.printSquarePerimeter(square);
        };
        squares.peek(Square::printSquareArea).forEach(Square::printSquarePerimeter);

        //  Rectangle.printRectangleArea(15.0, 3.0);
      // Rectangle.printRectangleArea(7.0, 5.0);

      //  Triangle.printTriangleArea(new Triangle(20.0, 30.0, 15.0));
      //  Triangle.printTriangleArea(new Triangle(3.0, 4.0, 5.0)); // нулевая сторона
      //  Triangle.printTriangleArea(new Triangle(3.0, 4.0, 60.0)); // несу
      //  Triangle.printTrianglePerimeter(new Triangle(3.0, 4.0, 5.0));
      //  Triangle.printTrianglePerimeter(new Triangle(3.0, 0.0, 8.0)); // нулевая сторона
      // Triangle.printTrianglePerimeter(new Triangle(3.0, 4.0, 60.0)); // несущ
    }

}
