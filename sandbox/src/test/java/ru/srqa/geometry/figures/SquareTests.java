package ru.srqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

   /*  @Test
    void canCalculateArea() {
        var s = new Square(5.0); //Вызов конструктора объекта. Передаём в кач-ве параметра сторону квадрата
        var result = s.Area(); // Вызов метода (функции) Area в этом объекте. Метод берёт необходимый параметр из объекта, в котором он вызывается
        Assertions.assertEquals(25.0, result);
    }

   /* @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, new Square(5.0).perimeter());
    }
    */

    @Test
    void canCalculateArea() {
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.Area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.Perimeter();
        Assertions.assertEquals(12.0, result);
    }
}
