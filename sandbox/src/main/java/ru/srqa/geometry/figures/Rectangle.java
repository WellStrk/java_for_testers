package ru.srqa.geometry.figures;

import java.util.Objects;

public record Rectangle(double side1, double side2) { /* Альтернативное задание объектов и конструкторов. Вместо class
 используем ключевое слово record, а после имени класса указывается набор свойств*/
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.side1, rectangle.side1) == 0 && Double.compare(this.side2, rectangle.side2) == 0)
                || (Double.compare(this.side2, rectangle.side1) == 0 && Double.compare(this.side1, rectangle.side2) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Rectangle {
        if (side1 < 0 || side2 < 0)
            throw new IllegalArgumentException("Стороны прямоугольника не должны быть равны нулю");
    }

    public static void printRectangleArea(double side1, double side2) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", side1, side2, RectangleArea(side1, side2));
        System.out.println(text);
    }

    private static double RectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
