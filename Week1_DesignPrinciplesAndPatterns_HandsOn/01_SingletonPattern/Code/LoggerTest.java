public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Logging first message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Logging second message");

        // Verify singleton behavior
        if (logger1 == logger2) {
            System.out.println("Same instance used. Singleton confirmed!");
        } else {
            System.out.println("Different instances. Singleton FAILED!");
        }
    }
}
