import java.util.Arrays;
import java.util.Comparator;

public class OrderSorter {

    // Sort by amount (ascending) using bubble sort (for learning)
    public static void bubbleSortByAmount(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getAmount() > orders[j + 1].getAmount()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Sort by customer name (built-in sort)
    public static void sortByName(Order[] orders) {
        Arrays.sort(orders, Comparator.comparing(Order::getCustomerName));
    }

    // Sort by order ID (built-in sort)
    public static void sortById(Order[] orders) {
        Arrays.sort(orders, Comparator.comparing(Order::getOrderId));
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
