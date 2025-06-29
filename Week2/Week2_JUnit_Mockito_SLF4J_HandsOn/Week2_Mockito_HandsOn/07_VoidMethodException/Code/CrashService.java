public class CrashService {
    private Logger logger;

    public CrashService(Logger logger) {
        this.logger = logger;
    }

    public void crashOperation() {
        logger.log("CRITICAL ERROR"); // This will throw in test
    }
}
