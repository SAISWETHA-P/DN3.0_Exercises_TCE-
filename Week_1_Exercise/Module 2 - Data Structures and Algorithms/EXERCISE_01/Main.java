import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Product class to represent each product in the inventory
class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor to initialize product attributes
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters for the product attributes
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}

// Inventory class to manage the collection of products
class Inventory {
    private Map<Integer, Product> products;

    // Constructor initializes the product map
    public Inventory() {
        products = new HashMap<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product ID already exists.");
        }
        products.put(product.getProductId(), product);
    }

    // Method to update product details
    public void updateProduct(int productId, Integer quantity, Double price) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }
        if (quantity != null) {
            product.setQuantity(quantity);
        }
        if (price != null) {
            product.setPrice(price);
        }
    }

    // Method to delete a product from the inventory
    public void deleteProduct(int productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found.");
        }
        products.remove(productId);
    }

    // Method to retrieve a product by its ID
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    // Method to display all products in the inventory
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}

// Main class containing the entry point of the application
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to keep the program running until user decides to exit
        while (true) {
            // Display menu options to the user
            System.out.println("Inventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            // Switch case to handle the user's choice
            switch (choice) {
                case 1:
                    // Adding a new product
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(productId, productName, quantity, price);
                    inventory.addProduct(product);
                    break;
                case 2:
                    // Updating an existing product
                    System.out.print("Enter Product ID to update: ");
                    productId = scanner.nextInt();
                    System.out.print("Enter new Quantity (or -1 to skip): ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new Price (or -1 to skip): ");
                    price = scanner.nextDouble();
                    inventory.updateProduct(productId, quantity == -1 ? null : quantity, price == -1 ? null : price);
                    break;
                case 3:
                    // Deleting a product
                    System.out.print("Enter Product ID to delete: ");
                    productId = scanner.nextInt();
                    inventory.deleteProduct(productId);
                    break;
                case 4:
                    // Viewing a specific product
                    System.out.print("Enter Product ID to view: ");
                    productId = scanner.nextInt();
                    Product p = inventory.getProduct(productId);
                    if (p != null) {
                        System.out.println(p);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    // Displaying all products
                    inventory.displayProducts();
                    break;
                case 6:
                    // Exiting the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    // Handling invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
