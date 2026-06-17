package src;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public Book searchBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public void borrowBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        }
        else if (!book.isAvailable()) {
            System.out.println("Book already borrowed!");
        }
        else {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        }
    }

    public void returnBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        }
        else if (book.isAvailable()) {
            System.out.println("Book is already available!");
        }
        else {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        }
    }
}