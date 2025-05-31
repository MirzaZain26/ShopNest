package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeItem(String productId) {
        items.removeIf(p -> p.getId().equals(productId));
        System.out.println("Item removed from cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Items in Cart:");
        for (Product p : items) {
            p.displayProduct();
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
