public class EmployeeMain {

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        System.out.println("=== Adding Employees ===");
        manager.addEmployee(new Employee(201, "Alice", "Manager", 85000));
        manager.addEmployee(new Employee(202, "Bob", "Developer", 72000));
        manager.addEmployee(new Employee(203, "Charlie", "Designer", 65000));
        manager.addEmployee(new Employee(204, "Diana", "Analyst", 70000));
        manager.addEmployee(new Employee(205, "Eve", "Tester", 60000));

        System.out.println("\n=== Traverse All Employees ===");
        manager.traverse();

        System.out.println("\n=== Search Employee ===");
        long start = System.nanoTime();
        Employee found = manager.searchById(203);
        long end = System.nanoTime();
        System.out.println("Search ID 203: " + (found != null ? found : "Not Found"));
        System.out.println("Time taken: " + (end - start) + " ns");

        start = System.nanoTime();
        Employee notFound = manager.searchById(999);
        end = System.nanoTime();
        System.out.println("Search ID 999: " + (notFound != null ? notFound : "Not Found"));
        System.out.println("Time taken: " + (end - start) + " ns");

        System.out.println("\n=== Delete Employee ===");
        manager.deleteEmployee(202);
        manager.deleteEmployee(999);

        System.out.println("\n=== Traverse After Deletion ===");
        manager.traverse();

        System.out.println("\n=== Duplicate ID Test ===");
        manager.addEmployee(new Employee(201, "Duplicate Alice", "HR", 50000));

        System.out.println("\n=== Capacity Info ===");
        System.out.println("Current size: " + manager.getSize() + " / Capacity: " + manager.getCapacity());

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Add      - O(n) due to duplicate ID check before inserting");
        System.out.println("Search   - O(n) linear scan through the array");
        System.out.println("Traverse - O(n) visits every element once");
        System.out.println("Delete   - O(n) for search + O(n) for left-shift = O(n)");
        System.out.println("\nLimitations of Arrays:");
        System.out.println("- Fixed size: must declare capacity upfront");
        System.out.println("- Deletion is costly: requires shifting all subsequent elements");
        System.out.println("- No built-in dynamic resizing (use ArrayList for that)");
        System.out.println("- Insertion in the middle is O(n) due to shifting");
        System.out.println("\nBest used when:");
        System.out.println("- Size is known and fixed");
        System.out.println("- Fast index-based access (O(1)) is the priority");
        System.out.println("- Memory overhead of dynamic structures must be avoided");
    }
}
