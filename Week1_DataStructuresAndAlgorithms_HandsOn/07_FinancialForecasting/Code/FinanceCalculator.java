public class FinanceCalculator {

    // Recursive method to calculate compound interest
    public static double calculateCompoundInterest(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return calculateCompoundInterest(principal, rate, years - 1) * (1 + rate / 100);
    }

    // Recursive forecast with printout
    public static void forecast(int year, int totalYears, double principal, double rate) {
        if (year > totalYears)
            return;

        double amount = calculateCompoundInterest(principal, rate, year);
        System.out.printf("📆 Year %d: $%.2f\n", year, amount);
        forecast(year + 1, totalYears, principal, rate);
    }
}
