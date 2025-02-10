import java.io.*;
import java.util.*;

class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return name + ", " + email;
    }
    
    public static User fromString(String data) {
        String[] parts = data.split(", ");
        return new User(parts[0], parts[1]);
    }
}

public class Task4 {
    private List<User> users = new ArrayList<>();
    
    public void addUser(String name, String email) {
        users.add(new User(name, email));
    }
    
    public void saveUsersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public void loadUsersFromFile(String filename) {
        users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(User.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    
    public void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    public static void main(String[] args) {
        Task4 userManager = new Task4();
        userManager.addUser("Alice", "alice@example.com");
        userManager.addUser("Bob", "bob@example.com");
        
        String filename = "users.txt";
        userManager.saveUsersToFile(filename);
        
        userManager.loadUsersFromFile(filename);
        userManager.displayUsers();
    }
}