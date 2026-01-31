package ru.srqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

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

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 4.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithSuchSides() {
        try {
            new Triangle(20.0, 4.0, 90.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test

    void testEquality() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test

    void testEquality2() {
        var t1 = new Triangle(4.0, 3.0, 5.0);
        var t2 = new Triangle(0.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }
}
