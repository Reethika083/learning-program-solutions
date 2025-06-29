import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // runs testA first, testB second, etc.
public class OrderedTests {

    @Test
    public void testA_initialize() {
        System.out.println("🅰️ testA: Initialization");
        assertTrue(true);
    }

    @Test
    public void testB_execute() {
        System.out.println("🅱️ testB: Execution");
        assertTrue(true);
    }

    @Test
    public void testC_cleanup() {
        System.out.println("🆑 testC: Cleanup");
        assertTrue(true);
    }
}
