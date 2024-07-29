import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Product class
    public static class Product {
        private int productId;
        private String productName;
        private String category;

        // Constructor
        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters
        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        // toString() method for easy printing
        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // ProductSearch class
    public static class ProductSearch {

        // Linear search for Product by productId
        public static Product linearSearch(Product[] products, int productId) {
            for (Product product : products) {
                if (product.getProductId() == productId) {
                    return product;
                }
            }
            return null; // Not found
        }

        // Binary search for Product by productId
        public static Product binarySearch(Product[] products, int productId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Product midProduct = products[mid];

                if (midProduct.getProductId() == productId) {
                    return midProduct;
                } else if (midProduct.getProductId() < productId) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return null; // Not found
        }

        // Helper method to sort products by productId
        public static void sortByProductId(Product[] products) {
            Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create some sample products
        Product[] products = {
                new Product(3, "Product C", "Category 1"),
                new Product(1, "Product A", "Category 2"),
                new Product(2, "Product B", "Category 1")
        };

        // Test linear search
        Product resultLinear = ProductSearch.linearSearch(products, 2);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Not Found"));

        // Sort products by productId for binary search
        ProductSearch.sortByProductId(products);

        // Test binary search
        Product resultBinary = ProductSearch.binarySearch(products, 2);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Not Found"));
    }
}
