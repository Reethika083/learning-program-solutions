import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    public void testThrowsExceptionWhenInputIsNull() {
        ExceptionThrower thrower = new ExceptionThrower();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });

        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testThrowsExceptionWhenInputIsEmpty() {
        ExceptionThrower thrower = new ExceptionThrower();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("");
        });

        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testNoExceptionWhenInputIsValid() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertDoesNotThrow(() -> thrower.throwException("Hello JUnit"));
    }
}
