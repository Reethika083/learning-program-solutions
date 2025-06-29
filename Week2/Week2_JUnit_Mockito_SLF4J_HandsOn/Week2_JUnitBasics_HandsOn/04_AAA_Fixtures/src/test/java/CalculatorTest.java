import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // Arrange: create a Calculator instance before each test
        calc = new Calculator();
        System.out.println("Setup: Calculator created");
    }

    @After
    public void tearDown() {
        // Teardown: cleanup after each test (optional here)
        System.out.println("Teardown: Test complete");
    }

    @Test
    public void testAddition() {
        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        int result = calc.subtract(10, 4);

        // Assert
        assertEquals(6, result);
    }
}
