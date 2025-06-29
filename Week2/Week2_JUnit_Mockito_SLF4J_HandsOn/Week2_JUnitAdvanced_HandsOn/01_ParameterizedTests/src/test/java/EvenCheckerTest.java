import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8, 10, 100 })
    public void testIsEven_withEvenNumbers(int input) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(input), input + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9 })
    public void testIsEven_withOddNumbers(int input) {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(input), input + " should be odd");
    }
}
