import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsAdditionTest {

    @Test
    public void testAddPositiveNumbers() {
        MathUtils math = new MathUtils();
        assertEquals(7, math.add(3, 4));
    }

    @Test
    public void testAddZero() {
        MathUtils math = new MathUtils();
        assertEquals(5, math.add(5, 0));
    }
}
