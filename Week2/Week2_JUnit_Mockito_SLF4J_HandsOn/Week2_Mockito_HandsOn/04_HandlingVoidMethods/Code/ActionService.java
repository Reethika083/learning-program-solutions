public class ActionService {
    private Logger logger;

    public ActionService(Logger logger) {
        this.logger = logger;
    }

    public void performAction(String input) {
        // some logic
        logger.log("Action performed: " + input);
    }
}
