import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static Book searchByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public static Book searchByAuthor(Book[] books, String author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                return books[i];
            }
        }
        return null;
    }

    public static List<Book> searchAllByAuthor(Book[] books, String author) {
        List<Book> results = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                results.add(books[i]);
            }
        }
        return results;
    }
}
