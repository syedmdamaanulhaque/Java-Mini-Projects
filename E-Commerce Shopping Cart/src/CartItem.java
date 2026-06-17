

public class CartItem {

    private Product product;
    private int quantity;

    // Constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate total price of this item
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // Display cart item
    public void displayCartItem() {
        System.out.println("----------------------------");
        System.out.println("Product ID   : " + product.getProductId());
        System.out.println("Product Name : " + product.getProductName());
        System.out.println("Price        : ₹" + product.getPrice());
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total        : ₹" + getTotalPrice());
    }
}