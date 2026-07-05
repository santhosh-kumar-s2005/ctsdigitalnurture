public class TaskMain {

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== Adding Tasks ===");
        taskList.addAtEnd(new Task(401, "Design Database Schema", "Pending"));
        taskList.addAtEnd(new Task(402, "Develop REST APIs", "In Progress"));
        taskList.addAtEnd(new Task(403, "Write Unit Tests", "Pending"));
        taskList.addAtBeginning(new Task(400, "Requirement Gathering", "Completed"));
        taskList.addAtPosition(new Task(404, "Code Review", "Pending"), 3);

        System.out.println("\n=== Traverse All Tasks ===");
        taskList.traverse();

        System.out.println("\n=== Search Tasks ===");
        long start = System.nanoTime();
        Task found = taskList.searchById(403);
        long end = System.nanoTime();
        System.out.println("Search ID 403: " + (found != null ? found : "Not Found"));
        System.out.println("Time taken: " + (end - start) + " ns");

        start = System.nanoTime();
        Task notFound = taskList.searchById(999);
        end = System.nanoTime();
        System.out.println("Search ID 999: " + (notFound != null ? notFound : "Not Found"));
        System.out.println("Time taken: " + (end - start) + " ns");

        System.out.println("\n=== Delete Tasks ===");
        taskList.deleteById(400);
        taskList.deleteById(402);
        taskList.deleteById(999);

        System.out.println("\n=== Traverse After Deletion ===");
        taskList.traverse();

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Add at Beginning  - O(1) : just re-point head");
        System.out.println("Add at End        - O(n) : must traverse to last node");
        System.out.println("Add at Position   - O(n) : traverse to position - 1");
        System.out.println("Search by ID      - O(n) : linear scan from head");
        System.out.println("Traverse          - O(n) : visits every node once");
        System.out.println("Delete by ID      - O(n) : scan to find predecessor node");

        System.out.println("\n=== Linked List vs Array ===");
        System.out.println("Dynamic sizing   : Linked list grows/shrinks at runtime; arrays are fixed");
        System.out.println("Insert at head   : O(1) in linked list vs O(n) shift in array");
        System.out.println("Delete any node  : O(n) search + O(1) pointer update vs O(n) shift in array");
        System.out.println("Random access    : O(n) in linked list vs O(1) by index in array");
        System.out.println("Memory           : Extra pointer per node in linked list vs contiguous in array");
        System.out.println("Best use case    : Frequent insertions/deletions at arbitrary positions");
    }
}
