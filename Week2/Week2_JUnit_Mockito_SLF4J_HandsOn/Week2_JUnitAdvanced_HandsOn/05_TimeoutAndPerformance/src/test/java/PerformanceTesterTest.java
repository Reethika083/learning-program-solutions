import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    public void testTaskCompletesWithin500ms() {
        PerformanceTester tester = new PerformanceTester();

        // ✅ Fails if task takes more than 500 milliseconds
        assertTimeout(Duration.ofMillis(500), tester::performTask);
    }

    @Test
    @Timeout(value = 1) // ✅ Fails if method takes > 1 second
    public void testWithAnnotationTimeout() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}
