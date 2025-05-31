package services;

import models.Admin;
import models.User;

import java.util.HashMap;

public class AuthService {
    private HashMap<String, User> users = new HashMap<>();

    public void registerUser(String id, String name, String email, String password) {
        User user = new User(id, name, email, password);
        users.put(email, user);
        System.out.println("User registered successfully!");
    }

    public User login(String email, String password) {
        if (users.containsKey(email)) {
            User user = users.get(email);
            if (user.checkPassword(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }

    public void registerAdmin(String id, String name, String email, String password) {
        Admin admin = new Admin(id, name, email, password);
        users.put(email, admin);
        System.out.println("Admin registered successfully!");
    }
}
