public class Main {
    public static void main(String[] args) {
        double principal = 1000.00;
        double rate = 5.0; // 5% interest
        int years = 5;

        System.out.println("📊 Financial Forecast:");
        FinanceCalculator.forecast(1, years, principal, rate);
    }
}
