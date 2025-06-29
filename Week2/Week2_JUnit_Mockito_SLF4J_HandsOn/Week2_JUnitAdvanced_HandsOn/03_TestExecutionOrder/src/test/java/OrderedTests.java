import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    public void testC() {
        System.out.println("Running testC");
        assertTrue(true);
    }

    @Test
    @Order(1)
    public void testA() {
        System.out.println("Running testA");
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(2)
    public void testB() {
        System.out.println("Running testB");
        assertNotNull("JUnit");
    }
}
