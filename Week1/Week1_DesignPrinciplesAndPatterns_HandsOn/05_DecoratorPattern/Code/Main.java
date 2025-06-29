public class Main {
    public static void main(String[] args) {
        Notifier basicNotifier = new EmailNotifier();

        // Add SMS
        Notifier smsNotifier = new SMSNotifierDecorator(basicNotifier);

        // Add Slack on top
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        fullNotifier.send("You have a new message, darling!");
    }
}
