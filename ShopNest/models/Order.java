package models;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private User user;
    private List<Product> products;
    private Date orderDate;

    public Order(String orderId, User user, List<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.orderDate = new Date();
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + user.getName());
        System.out.println("Order Date: " + orderDate);
        System.out.println("Ordered Items:");
        for (Product p : products) {
            p.displayProduct();
        }
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total: $" + total);
    }
}
