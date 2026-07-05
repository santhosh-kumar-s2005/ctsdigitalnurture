import java.util.Arrays;
import java.util.Comparator;

public class SearchMain {

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(102, "T-Shirt", "Clothing"),
            new Product(108, "Headphones", "Electronics"),
            new Product(101, "Running Shoes", "Footwear"),
            new Product(110, "Novel", "Books"),
            new Product(103, "Smartwatch", "Electronics"),
            new Product(107, "Jeans", "Clothing"),
            new Product(104, "Backpack", "Accessories")
        };

        System.out.println("=== Linear Search ===");

        long startTime = System.nanoTime();
        Product result1 = LinearSearch.searchById(products, 108);
        long endTime = System.nanoTime();
        System.out.println("Search by ID 108: " + (result1 != null ? result1 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Product result2 = LinearSearch.searchByName(products, "Backpack");
        endTime = System.nanoTime();
        System.out.println("Search by Name 'Backpack': " + (result2 != null ? result2 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Product result3 = LinearSearch.searchById(products, 999);
        endTime = System.nanoTime();
        System.out.println("Search by ID 999 (not exists): " + (result3 != null ? result3 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n=== Sorted Products for Binary Search ===");
        for (Product p : sortedProducts) {
            System.out.println(p);
        }

        System.out.println("\n=== Binary Search ===");

        startTime = System.nanoTime();
        Product result4 = BinarySearch.searchById(sortedProducts, 108);
        endTime = System.nanoTime();
        System.out.println("Search by ID 108: " + (result4 != null ? result4 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Product result5 = BinarySearch.searchById(sortedProducts, 101);
        endTime = System.nanoTime();
        System.out.println("Search by ID 101: " + (result5 != null ? result5 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Product result6 = BinarySearch.searchById(sortedProducts, 999);
        endTime = System.nanoTime();
        System.out.println("Search by ID 999 (not exists): " + (result6 != null ? result6 : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search  - Best: O(1) | Average: O(n) | Worst: O(n)");
        System.out.println("Binary Search  - Best: O(1) | Average: O(log n) | Worst: O(log n)");
        System.out.println("Binary Search requires a sorted array. Sorting costs O(n log n).");
        System.out.println("For large catalogs with frequent searches, Binary Search is preferred.");
    }
}
