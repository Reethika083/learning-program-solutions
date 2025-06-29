import java.util.Arrays;
import java.util.Comparator;

public class OrderSorter {

    // Bubble sort by amount
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

    // Built-in sort by name
    public static void sortByName(Order[] orders) {
        Arrays.sort(orders, Comparator.comparing(Order::getCustomerName));
    }

    // Built-in sort by order ID
    public static void sortById(Order[] orders) {
        Arrays.sort(orders, Comparator.comparing(Order::getOrderId));
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
