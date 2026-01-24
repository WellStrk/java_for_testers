package ru.srqa.geometry;

import ru.srqa.geometry.figures.Rectangle;
import ru.srqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(7.0);
        Square.printSquareArea(5.0);
        Square.printSquareArea(3.0);
        

        Rectangle.printRectangleArea(15.0, 3.0);
        Rectangle.printRectangleArea(7.0, 5.0);
    }

}
