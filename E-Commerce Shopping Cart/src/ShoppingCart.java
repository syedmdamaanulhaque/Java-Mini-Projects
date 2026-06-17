

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<CartItem> cartItems;

    // Constructor
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product, int quantity) {

        // Check if product already exists
        for (CartItem item : cartItems) {

            if (item.getProduct().getProductId() == product.getProductId()) {

                item.setQuantity(item.getQuantity() + quantity);

                System.out.println("Quantity updated successfully!");

                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));

        System.out.println("Product added to cart successfully!");
    }

    // Remove product
    public void removeProduct(int productId) {

        for (CartItem item : cartItems) {

            if (item.getProduct().getProductId() == productId) {

                cartItems.remove(item);

                System.out.println("Product removed successfully!");

                return;
            }
        }

        System.out.println("Product not found!");
    }

    // View cart
    public void displayCart() {

        if (cartItems.isEmpty()) {

            System.out.println("Cart is empty.");

            return;
        }

        for (CartItem item : cartItems) {

            item.displayCartItem();
        }
    }

    // Calculate total bill
    public double calculateTotal() {

        double total = 0;

        for (CartItem item : cartItems) {

            total += item.getTotalPrice();
        }

        return total;
    }

    // Checkout
    public void checkout() {

        if (cartItems.isEmpty()) {

            System.out.println("Cart is empty.");

            return;
        }

        displayCart();

        System.out.println("----------------------------");
        System.out.println("Grand Total : ₹" + calculateTotal());
        System.out.println("Thank you for shopping!");
    }
}