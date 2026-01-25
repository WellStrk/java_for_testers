package ru.srqa.geometry.figures;

public record Rectangle(double side1, double side2) { /* Альтернативное задание объектов и конструкторов. Вместо class
 используем ключевое слово record, а после имени класса указывается набор свойств*/ 

    public static void printRectangleArea(double side1, double side2) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", side1, side2, RectangleArea(side1, side2));
        System.out.println(text);
    }

    private static double RectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
