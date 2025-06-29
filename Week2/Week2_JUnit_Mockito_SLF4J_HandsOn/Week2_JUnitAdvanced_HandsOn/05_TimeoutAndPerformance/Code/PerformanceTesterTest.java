import org.junit.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test(timeout = 1000) // 1 second max
    public void testPerformTaskFastEnough() {
        tester.performTask(); // ✅ should pass
    }

    @Test(timeout = 1000) // 1 second max
    public void testSlowTaskTimesOut() {
        tester.slowTask(); // ❌ will fail
    }
}
