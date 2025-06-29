package com.example.demo.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8, 10 })
    void testIsEvenWithEvenNumbers(int input) {
        assertTrue(MathUtil.isEven(input), input + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9 })
    void testIsEvenWithOddNumbers(int input) {
        assertFalse(MathUtil.isEven(input), input + " should be odd");
    }
}
