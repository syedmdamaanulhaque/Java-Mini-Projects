package src;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();

                    Book foundBook = library.searchBook(searchId);

                    if (foundBook != null) {
                        foundBook.displayBook();
                    }
                    else {
                        System.out.println("Book not found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();

                    library.borrowBook(borrowId);

                    break;

                case 5:

                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                case 6:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}