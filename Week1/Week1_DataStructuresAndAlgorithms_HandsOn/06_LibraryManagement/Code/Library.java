import java.util.Arrays;
import java.util.Comparator;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("📚 Library Catalog:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public int linearSearch(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        return Arrays.binarySearch(books, new Book(title, "", ""),
                Comparator.comparing(Book::getTitle));
    }
}
