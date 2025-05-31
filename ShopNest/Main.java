import models.*;
import services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        // Sample Admin & Products
        authService.registerAdmin("A1", "Admin", "admin@shopnest.com", "admin123");
        productService.addProduct(new Product("P1", "Shirt", "Clothing", 999.0, "Cotton shirt"));
        productService.addProduct(new Product("P2", "Watch", "Accessories", 1500.0, "Waterproof watch"));

        System.out.println("Welcome to ShopNest");
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                authService.registerUser("U" + email.hashCode(), name, email, password);
            } else if (choice == 2) {
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                User user = authService.login(email, password);

                if (user != null) {
                    Cart cart = new Cart();
                    boolean isAdmin = user instanceof Admin;

                    while (true) {
                        System.out.println("\n-- MENU --");
                        if (isAdmin) {
                            System.out.println("1. Add Product\n2. Delete Product\n3. View Products\n4. Logout");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (adminChoice == 1) {
                                System.out.print("ID: "); String id = scanner.nextLine();
                                System.out.print("Name: "); String name = scanner.nextLine();
                                System.out.print("Category: "); String cat = scanner.nextLine();
                                System.out.print("Price: "); double price = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Description: "); String desc = scanner.nextLine();
                                productService.addProduct(new Product(id, name, cat, price, desc));
                            } else if (adminChoice == 2) {
                                System.out.print("Product ID: ");
                                productService.deleteProduct(scanner.nextLine());
                            } else if (adminChoice == 3) {
                                productService.viewProducts();
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout");
                            int userChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (userChoice == 1) {
                                productService.viewProducts();
                            } else if (userChoice == 2) {
                                System.out.print("Enter Product ID: ");
                                String pid = scanner.nextLine();
                                Product p = productService.findProductById(pid);
                                if (p != null) cart.addItem(p);
                                else System.out.println("Product not found.");
                            } else if (userChoice == 3) {
                                cart.viewCart();
                            } else if (userChoice == 4) {
                                orderService.placeOrder(user, cart.getItems());
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}
