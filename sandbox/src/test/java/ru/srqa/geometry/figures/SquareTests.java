package ru.srqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateArea() {
        var s = new Square(6.0); //Вызов конструктора объекта. Передаём в кач-ве параметра сторону квадрата
        var result = s.Area(); // Вызов метода (функции) Area в этом объекте. Метод берёт необходимый параметр из объекта, в котором он вызывается
        //Assertions.assertEquals(25.0, result);
        if (result != 25.0) {
            throw new AssertionError(String.format("expect %f, actual %f", 25.0, result));
        }
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, new Square(5.0).perimeter());
    }

    @Test
    void cannotCreateSquareWithNegativeSide() {
        try {
            new Square(-5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test

    void testEquality() {
        var s1 = new Square(5.0);
        var s2 = new Square(4.0);
        Assertions.assertNotEquals(s1, s2);
    }

    @Test

    void testFail() {
        var s1 = new Square(5.0);
        var s2 = new Square(5.0);
        Assertions.assertTrue(s1.equals(s2));
    }
}
