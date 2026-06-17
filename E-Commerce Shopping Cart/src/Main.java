

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();

        while (true) {

            System.out.println("\n===== E-COMMERCE SHOPPING CART =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(id, name, price);

                    cart.addProduct(product, quantity);

                    break;

                case 2:

                    System.out.print("Enter Product ID to remove: ");

                    int removeId = sc.nextInt();

                    cart.removeProduct(removeId);

                    break;

                case 3:

                    cart.displayCart();

                    break;

                case 4:

                    cart.checkout();

                    break;

                case 5:

                    System.out.println("Thank you for shopping!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}