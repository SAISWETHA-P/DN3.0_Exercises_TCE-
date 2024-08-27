import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

class Search {

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = productName.compareToIgnoreCase(products[mid].getProductName());

            if (result == 0) {
                return products[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Book", "Literature")
        };

        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.print("\nEnter the product name to search: ");
        String productName = scanner.nextLine();

        System.out.println("\nSearching for '" + productName + "' using Linear Search:");
        Product result = linearSearch(products, productName);
        System.out.println(result != null ? result : "Product not found");

        // Sort products by name for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("\nSearching for '" + productName + "' using Binary Search:");
        result = binarySearch(products, productName);
        System.out.println(result != null ? result : "Product not found");

        scanner.close();
    }
}
