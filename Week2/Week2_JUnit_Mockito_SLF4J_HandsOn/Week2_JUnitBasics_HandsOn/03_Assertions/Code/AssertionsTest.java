package com.example.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testEquals() {
        assertEquals("Values should be equal", 5, 2 + 3);
    }

    @Test
    public void testTrueCondition() {
        assertTrue("Should be true", 10 > 1);
    }

    @Test
    public void testFalseCondition() {
        assertFalse("Should be false", 5 < 2);
    }

    @Test
    public void testNullCheck() {
        String value = null;
        assertNull("Value should be null", value);
    }

    @Test
    public void testNotNullCheck() {
        String value = "Hello";
        assertNotNull("Value should not be null", value);
    }
}
