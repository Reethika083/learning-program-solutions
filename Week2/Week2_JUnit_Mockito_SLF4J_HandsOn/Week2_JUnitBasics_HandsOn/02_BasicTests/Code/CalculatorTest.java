package com.example.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calc.add(7, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(4, calc.subtract(7, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(21, calc.multiply(7, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calc.divide(5, 0);
    }
}
