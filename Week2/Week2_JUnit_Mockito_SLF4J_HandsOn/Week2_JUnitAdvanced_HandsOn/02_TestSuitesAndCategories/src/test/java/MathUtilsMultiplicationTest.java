import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsMultiplicationTest {

    @Test
    public void testMultiplyPositiveNumbers() {
        MathUtils math = new MathUtils();
        assertEquals(12, math.multiply(3, 4));
    }

    @Test
    public void testMultiplyByZero() {
        MathUtils math = new MathUtils();
        assertEquals(0, math.multiply(5, 0));
    }
}
