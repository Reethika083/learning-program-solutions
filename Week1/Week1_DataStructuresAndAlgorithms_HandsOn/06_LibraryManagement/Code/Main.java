public class Main {
    public static void main(String[] args) {
        Book[] bookArray = {
                new Book("The Alchemist", "Paulo Coelho", "ISBN123"),
                new Book("Harry Potter", "J.K. Rowling", "ISBN456"),
                new Book("The Hobbit", "J.R.R. Tolkien", "ISBN789")
        };

        Library library = new Library(bookArray);

        library.displayBooks();

        String searchTitle = "The Hobbit";
        int linearResult = library.linearSearch(searchTitle);
        System.out.println("\n🔍 Linear Search for \"" + searchTitle + "\": " +
                (linearResult >= 0 ? "Found at index " + linearResult : "Not found"));

        int binaryResult = library.binarySearch(searchTitle);
        System.out.println("⚡ Binary Search for \"" + searchTitle + "\": " +
                (binaryResult >= 0 ? "Found at index " + binaryResult : "Not found"));
    }
}
