

import java.sql.*;
import java.util.Scanner;

class AccountantModule {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void manageStudents(Connection connection) throws SQLException {
        System.out.println("Select an option: ");
        System.out.println("1. Register Student\n2. View Students\n3. Update Student Details\n4. Remove Student\n5. Check Pending Fees\n6. Logout");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addStudent(connection);
                break;
            case 2:
                displayStudents(connection);
                break;
            case 3:
                updateStudentInfo(connection);
                break;
            case 4:
                deleteStudent(connection);
                break;
            default:
                System.out.println("Logging out...");
        }
    }

    private static void addStudent(Connection connection) throws SQLException {
        System.out.println("Enter Student ID: ");
        int studentId = scanner.nextInt();
        
        System.out.println("Enter Name: ");
        String studentName = scanner.next();
        
        System.out.println("Enter Email: ");
        String studentEmail = scanner.next();
        
        System.out.println("Enter Course: ");
        String courseName = scanner.next();
        
        System.out.println("Enter Total Fee: ");
        double totalFee = scanner.nextDouble();
        
        System.out.println("Enter Paid Amount: ");
        double amountPaid = scanner.nextDouble();
        
        double dueAmount = totalFee - amountPaid;
        
        System.out.println("Enter Address: ");
        String address = scanner.next();
        
        System.out.println("Enter Phone Number: ");
        long phoneNumber = scanner.nextLong();

        String sql = "INSERT INTO student (id, name, email, course, fee, paid, due, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, studentId);
        statement.setString(2, studentName);
        statement.setString(3, studentEmail);
        statement.setString(4, courseName);
        statement.setDouble(5, totalFee);
        statement.setDouble(6, amountPaid);
        statement.setDouble(7, dueAmount);
        statement.setString(8, address);
        statement.setLong(9, phoneNumber);
        
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Student added successfully!");
        }
    }

    private static void displayStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM student";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt(1) + " | Name: " + resultSet.getString(2) +
                    " | Email: " + resultSet.getString(3) + " | Course: " + resultSet.getString(4) +
                    " | Fee: " + resultSet.getDouble(5) + " | Paid: " + resultSet.getDouble(6) +
                    " | Due: " + resultSet.getDouble(7) + " | Address: " + resultSet.getString(8) +
                    " | Phone: " + resultSet.getLong(9));
        }
    }
    
    private static void updateStudentInfo(Connection connection) throws SQLException {
        System.out.println("Enter Student ID to Update: ");
        int studentId = scanner.nextInt();
        
        System.out.println("Choose field to update: 1. Name 2. Email 3. Phone");
        int option = scanner.nextInt();
        
        String updateQuery = "";
        String newValue = "";
        
        switch (option) {
            case 1:
                System.out.println("Enter new name: ");
                newValue = scanner.next();
                updateQuery = "UPDATE student SET name = ? WHERE id = ?";
                break;
            case 2:
                System.out.println("Enter new email: ");
                newValue = scanner.next();
                updateQuery = "UPDATE student SET email = ? WHERE id = ?";
                break;
            case 3:
                System.out.println("Enter new phone number: ");
                newValue = scanner.next();
                updateQuery = "UPDATE student SET phone = ? WHERE id = ?";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, newValue);
        statement.setInt(2, studentId);
        
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Update successful!");
        }
    }
    
    private static void deleteStudent(Connection connection) throws SQLException {
        System.out.println("Enter Student ID to Delete: ");
        int studentId = scanner.nextInt();
        
        String query = "DELETE FROM student WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentId);
        
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Student record deleted successfully!");
        }
    }
}

public class MainApplication {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/softdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Scanner scanner = new Scanner(System.in);
            
            int option;
            do {
                System.out.println("Select Access Type: 1. Accountant 2. Exit");
                option = scanner.nextInt();
                
                if (option == 1) {
                    AccountantModule.manageStudents(connection);
                }
            } while (option != 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
