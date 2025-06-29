public class PerformanceTester {

    public void performTask() {
        // Simulate some work (e.g., delay for 500ms)
        try {
            Thread.sleep(500); // <-- This is within limit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void slowTask() {
        // Simulate slower work (over 1s)
        try {
            Thread.sleep(1500); // <-- This will exceed timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
