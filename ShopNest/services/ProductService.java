package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added.");
    }

    public void deleteProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
        System.out.println("Product deleted.");
    }

    public void viewProducts() {
        for (Product p : products) {
            p.displayProduct();
            System.out.println("-------------");
        }
    }

    public Product findProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
