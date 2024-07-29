import java.util.ArrayList;
import java.util.Iterator;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
    }
}

class Inventory {
    private ArrayList<Product> products;

    // Constructor
    public Inventory() {
        this.products = new ArrayList<>();
    }

    // Add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Update product
    public boolean updateProduct(int productId, String productName, int quantity, double price) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setPrice(price);
                return true;
            }
        }
        return false;
    }

    // Delete product
    public boolean deleteProduct(int productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Display all products
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        inventory.addProduct(new Product(1, "Laptop", 10, 999.99));
        inventory.addProduct(new Product(2, "Smartphone", 20, 499.99));
        inventory.addProduct(new Product(3, "Tablet", 15, 299.99));

        // Displaying all products
        System.out.println("Initial Inventory:");
        inventory.displayProducts();

        // Updating a product
        inventory.updateProduct(2, "Smartphone", 25, 459.99);
        System.out.println("\nInventory after updating product with ID 2:");
        inventory.displayProducts();

        // Deleting a product
        inventory.deleteProduct(1);
        System.out.println("\nInventory after deleting product with ID 1:");
        inventory.displayProducts();
    }
}
