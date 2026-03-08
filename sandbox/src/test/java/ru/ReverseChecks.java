package ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseChecks {

    @Test

    void testSqrt() {
        var input = 5.0;
        var result = Math.sqrt(input);
        var reverse = result * result;
        Assertions.assertEquals(input,reverse, 0.000001);
    }
}
