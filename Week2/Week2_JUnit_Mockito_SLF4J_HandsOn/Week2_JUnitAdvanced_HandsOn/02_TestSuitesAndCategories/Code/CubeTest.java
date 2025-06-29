import org.junit.Test;
import static org.junit.Assert.*;

public class CubeTest {

    @Test
    public void testCube() {
        MathUtils math = new MathUtils();
        assertEquals(27, math.cube(3));
    }
}
