import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void testSquare() {
        MathUtils math = new MathUtils();
        assertEquals(25, math.square(5));
    }
}
