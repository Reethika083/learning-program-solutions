public class OrderProcessor {
    private NotificationService notifier;

    public OrderProcessor(NotificationService notifier) {
        this.notifier = notifier;
    }

    public void processOrder() {
        notifier.sendEmail("Order confirmed");
        notifier.sendSMS("Order shipped");
    }
}
