package services;

import models.Order;
import models.Product;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(User user, List<Product> items) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, user, items);
        orders.add(order);
        System.out.println("Order placed successfully!");
        order.displayOrder();
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order o : orders) {
            o.displayOrder();
            System.out.println("------------");
        }
    }
}
