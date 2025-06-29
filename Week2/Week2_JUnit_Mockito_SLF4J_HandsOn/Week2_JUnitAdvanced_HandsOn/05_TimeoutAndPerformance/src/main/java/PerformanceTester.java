public class PerformanceTester {

    public void performTask() {
        try {
            // Simulate time-consuming task (e.g., 300 ms)
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
