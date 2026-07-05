import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        }
    }

    public void updateProduct(int productId, String productName, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            Product removed = products.remove(productId);
            System.out.println("Product deleted: " + removed);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public Product getProduct(int productId) {
        return products.getOrDefault(productId, null);
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}
