import org.junit.Test;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForNull() {
        thrower.throwException(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForEmpty() {
        thrower.throwException("");
    }

    @Test
    public void testNoExceptionForValidInput() {
        thrower.throwException("Hello babee 💖");
    }
}
