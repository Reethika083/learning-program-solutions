import java.util.Arrays;

public class ProductSearch {
    // Linear Search
    public static int linearSearch(String[] items, String target) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(String[] items, String target) {
        Arrays.sort(items); // Make sure list is sorted
        return Arrays.binarySearch(items, target);
    }
}
