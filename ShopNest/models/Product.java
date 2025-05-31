package models;

public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private String description;

    public Product(String id, String name, String category, double price, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + " | Category: " + category +
                " | Price: $" + price + "\nDescription: " + description);
    }
}
