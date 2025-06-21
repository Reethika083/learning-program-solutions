public class Main {
    public static void main(String[] args) {
        String[] products = { "Laptop", "Mouse", "Keyboard", "Monitor", "Charger" };

        String target1 = "Keyboard";
        String target2 = "Phone";

        // Linear Search
        int linearResult = ProductSearch.linearSearch(products, target1);
        System.out.println("🔍 Linear Search for '" + target1 + "': " +
                (linearResult >= 0 ? "Found at index " + linearResult : "Not found"));

        // Binary Search (sorted inside method)
        int binaryResult = ProductSearch.binarySearch(products, target1);
        System.out.println("⚡ Binary Search for '" + target1 + "': " +
                (binaryResult >= 0 ? "Found at index " + binaryResult : "Not found"));

        // Try a non-existent item
        int failResult = ProductSearch.linearSearch(products, target2);
        System.out.println("🔍 Linear Search for '" + target2 + "': " +
                (failResult >= 0 ? "Found at index " + failResult : "Not found"));
    }
}
