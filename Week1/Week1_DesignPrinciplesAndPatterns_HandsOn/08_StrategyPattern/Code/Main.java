public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay with credit card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9999"));
        context.executePayment(150.0);

        // Switch to PayPal
        context.setPaymentStrategy(new PayPalPayment("cutie@example.com"));
        context.executePayment(200.0);
    }
}
