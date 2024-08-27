import java.util.Arrays;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book[ID=" + bookId + ", Title=" + title + ", Author=" + author + "]";
    }
}

public class LibraryManagement {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = title.compareToIgnoreCase(books[mid].getTitle());

            if (result == 0) {
                return books[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell")
        };

        // Linear Search
        System.out.println("Searching for '1984' using Linear Search:");
        Book foundBook = linearSearch(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        // Binary Search
        // Sorting the array before binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        System.out.println("\nSearching for 'To Kill a Mockingbird' using Binary Search:");
        foundBook = binarySearch(books, "To Kill a Mockingbird");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }
}
