public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("O003", "Zara", 220.50),
                new Order("O001", "Anna", 120.99),
                new Order("O002", "Liam", 150.00)
        };

        System.out.println("💳 Original Orders:");
        OrderSorter.printOrders(orders);

        System.out.println("\n🔢 Sorted by Amount (Bubble Sort):");
        OrderSorter.bubbleSortByAmount(orders);
        OrderSorter.printOrders(orders);

        System.out.println("\n🔠 Sorted by Customer Name:");
        OrderSorter.sortByName(orders);
        OrderSorter.printOrders(orders);

        System.out.println("\n🔡 Sorted by Order ID:");
        OrderSorter.sortById(orders);
        OrderSorter.printOrders(orders);
    }
}
