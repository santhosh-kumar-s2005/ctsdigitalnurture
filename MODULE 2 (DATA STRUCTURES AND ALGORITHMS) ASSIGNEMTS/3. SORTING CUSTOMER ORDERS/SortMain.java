import java.util.Arrays;

public class SortMain {

    private static Order[] getSampleOrders() {
        return new Order[]{
            new Order(301, "Alice", 4500.00),
            new Order(302, "Bob", 1200.50),
            new Order(303, "Charlie", 8999.99),
            new Order(304, "Diana", 300.00),
            new Order(305, "Eve", 15000.00),
            new Order(306, "Frank", 750.75),
            new Order(307, "Grace", 5600.00),
            new Order(308, "Hank", 2300.00)
        };
    }

    private static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] ordersForBubble = getSampleOrders();
        Order[] ordersForQuick = getSampleOrders();

        System.out.println("=== Original Orders ===");
        printOrders(ordersForBubble);

        System.out.println("\n=== Bubble Sort ===");
        long start = System.nanoTime();
        BubbleSort.sort(ordersForBubble);
        long end = System.nanoTime();
        printOrders(ordersForBubble);
        System.out.println("Time taken: " + (end - start) + " ns");

        System.out.println("\n=== Quick Sort ===");
        start = System.nanoTime();
        QuickSort.sort(ordersForQuick, 0, ordersForQuick.length - 1);
        end = System.nanoTime();
        printOrders(ordersForQuick);
        System.out.println("Time taken: " + (end - start) + " ns");

        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Bubble Sort - Best: O(n) | Average: O(n^2) | Worst: O(n^2) | Space: O(1)");
        System.out.println("Quick Sort  - Best: O(n log n) | Average: O(n log n) | Worst: O(n^2) | Space: O(log n)");
        System.out.println("Quick Sort is preferred for large datasets due to O(n log n) average performance.");
        System.out.println("Bubble Sort is simple but inefficient beyond small arrays.");
    }
}
