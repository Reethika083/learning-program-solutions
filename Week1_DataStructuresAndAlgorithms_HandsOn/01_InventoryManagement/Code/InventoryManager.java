import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("✅ Product added: " + product);
    }

    public void updateProduct(String productId, int newQty, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQty);
            product.setPrice(newPrice);
            System.out.println("🔄 Product updated: " + product);
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("🗑️ Product removed: " + productId);
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    public void viewAll() {
        System.out.println("📦 Current Inventory:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
