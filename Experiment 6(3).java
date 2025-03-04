import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("Tablet", "Electronics", 600),
            new Product("Sofa", "Furniture", 1500),
            new Product("Chair", "Furniture", 300),
            new Product("Bed", "Furniture", 2000),
            new Product("Shirt", "Clothing", 50),
            new Product("Jacket", "Clothing", 120)
        );

        // 1. Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(groupingBy(Product::getCategory));

        System.out.println("\nProducts Grouped by Category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + " -> " + productList));

        // 2. Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(groupingBy(Product::getCategory, maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + product.orElse(null)));

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
            .collect(averagingDouble(Product::getPrice));

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
