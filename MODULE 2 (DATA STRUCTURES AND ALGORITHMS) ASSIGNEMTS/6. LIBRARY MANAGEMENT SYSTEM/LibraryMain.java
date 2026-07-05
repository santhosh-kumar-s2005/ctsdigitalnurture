import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LibraryMain {

    private static void printResult(String label, Book result, long timeNs) {
        System.out.println(label + ": " + (result != null ? result : "Not Found"));
        System.out.println("Time taken: " + timeNs + " ns");
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(601, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(602, "To Kill a Mockingbird", "Harper Lee"),
            new Book(603, "1984", "George Orwell"),
            new Book(604, "Animal Farm", "George Orwell"),
            new Book(605, "Brave New World", "Aldous Huxley"),
            new Book(606, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(607, "Of Mice and Men", "John Steinbeck"),
            new Book(608, "The Hobbit", "J.R.R. Tolkien"),
            new Book(609, "Fahrenheit 451", "Ray Bradbury"),
            new Book(610, "Jane Eyre", "Charlotte Bronte")
        };

        System.out.println("=== Library Catalog ===");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n=== Linear Search by Title ===");
        long start = System.nanoTime();
        Book result1 = LinearSearch.searchByTitle(books, "The Hobbit");
        long end = System.nanoTime();
        printResult("Search 'The Hobbit'", result1, end - start);

        start = System.nanoTime();
        Book result2 = LinearSearch.searchByTitle(books, "Dune");
        end = System.nanoTime();
        printResult("Search 'Dune' (not exists)", result2, end - start);

        System.out.println("\n=== Linear Search by Author ===");
        start = System.nanoTime();
        Book result3 = LinearSearch.searchByAuthor(books, "George Orwell");
        end = System.nanoTime();
        printResult("First book by 'George Orwell'", result3, end - start);

        System.out.println("\n=== Linear Search - All Books by Author ===");
        start = System.nanoTime();
        List<Book> orwellBooks = LinearSearch.searchAllByAuthor(books, "George Orwell");
        end = System.nanoTime();
        System.out.println("All books by 'George Orwell': ");
        for (Book b : orwellBooks) {
            System.out.println("  " + b);
        }
        System.out.println("Time taken: " + (end - start) + " ns");

        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.getTitle().toLowerCase()));

        System.out.println("\n=== Sorted Catalog for Binary Search ===");
        for (Book b : sortedBooks) {
            System.out.println(b);
        }

        System.out.println("\n=== Binary Search by Title ===");
        start = System.nanoTime();
        Book result4 = BinarySearch.searchByTitle(sortedBooks, "The Hobbit");
        end = System.nanoTime();
        printResult("Search 'The Hobbit'", result4, end - start);

        start = System.nanoTime();
        Book result5 = BinarySearch.searchByTitle(sortedBooks, "Jane Eyre");
        end = System.nanoTime();
        printResult("Search 'Jane Eyre'", result5, end - start);

        start = System.nanoTime();
        Book result6 = BinarySearch.searchByTitle(sortedBooks, "Dune");
        end = System.nanoTime();
        printResult("Search 'Dune' (not exists)", result6, end - start);

        System.out.println("\n=== Time Complexity Comparison ===");
        System.out.println("Linear Search - Best: O(1) | Average: O(n) | Worst: O(n)");
        System.out.println("Binary Search - Best: O(1) | Average: O(log n) | Worst: O(log n)");
        System.out.println("Sorting cost for Binary Search: O(n log n) one-time preprocessing");

        System.out.println("\n=== When to Use Each ===");
        System.out.println("Linear Search:");
        System.out.println("  - Unsorted or small datasets");
        System.out.println("  - Searching by fields that cannot be sorted (e.g., author with multiple books)");
        System.out.println("  - One-time or infrequent searches where sorting overhead is not worth it");
        System.out.println("Binary Search:");
        System.out.println("  - Large sorted datasets with frequent searches");
        System.out.println("  - Searching by a unique sortable field like title");
        System.out.println("  - When preprocessing cost (sorting) is amortized over many queries");
    }
}
