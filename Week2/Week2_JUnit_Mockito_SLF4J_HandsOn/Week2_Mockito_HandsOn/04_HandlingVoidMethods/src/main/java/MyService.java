public class MyService {
    private final ExternalLogger logger;

    public MyService(ExternalLogger logger) {
        this.logger = logger;
    }

    public void process() {
        // business logic
        logger.log("Processing completed");
    }
}
