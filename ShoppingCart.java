import javax.swing.JOptionPane;

public class ShoppingCart {

    // Define the available stock
    private int availableStock;

    // Constructor to initialize the stock
    public ShoppingCart(int stock) {
        this.availableStock = stock;
    }

    // Define a custom exception class without using `super(message)`
    public static class InvalidQuantityException extends Exception {
        // No-argument constructor with a default message
        public InvalidQuantityException() {
            JOptionPane.showMessageDialog(null, 
                "Invalid quantity detected. Please enter a valid quantity.",
                "Invalid Quantity", 
                JOptionPane.ERROR_MESSAGE);
        }

        // Constructor for specific scenarios (e.g., negative or exceeding stock)
        public InvalidQuantityException(boolean isNegative) {
            if (isNegative) {
                JOptionPane.showMessageDialog(null, 
                    "Quantity cannot be negative.", 
                    "Invalid Quantity", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Requested quantity exceeds available stock.", 
                    "Invalid Quantity", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to add product to the cart
    public void addToCart(int quantity) throws InvalidQuantityException {
        if (quantity < 0) {
            // Throw custom exception for negative quantity
            throw new InvalidQuantityException(true);
        } else if (quantity > availableStock) {
            // Throw custom exception for exceeding stock
            throw new InvalidQuantityException(false);
        } else {
            // Otherwise, reduce stock and confirm addition
            availableStock -= quantity;
            JOptionPane.showMessageDialog(null, 
                "Successfully added " + quantity + " item(s) to the cart.");
        }
    }

    // Method to display remaining stock
    public void displayAvailableStock() {
        JOptionPane.showMessageDialog(null, 
            "Available stock: " + availableStock);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of ShoppingCart with 20 items in stock
        ShoppingCart cart = new ShoppingCart(20);

        // Display initial stock
        cart.displayAvailableStock();

        try {
            // Prompt user to enter the quantity to add
            String input1 = JOptionPane.showInputDialog("Enter quantity to add to cart:");
            int quantity1 = Integer.parseInt(input1);
            cart.addToCart(quantity1);
            cart.displayAvailableStock();

            // Prompt user to enter another quantity to add
            String input2 = JOptionPane.showInputDialog("Enter another quantity to add to cart:");
            int quantity2 = Integer.parseInt(input2);
            cart.addToCart(quantity2);
            cart.displayAvailableStock();
        } catch (InvalidQuantityException e) {
            // Custom exceptions are handled internally, so no additional logic here
        } catch (NumberFormatException e) {
            // Handle invalid number inputs
            JOptionPane.showMessageDialog(null, 
                "Error: Please enter a valid number.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
