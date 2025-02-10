import java.util.Scanner;

public class Task3 {
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt user for input
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            
            // Calculate reciprocal
            double reciprocal = 1 / num;
            
            System.out.println("The reciprocal of " + num + " is " + reciprocal);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    public static void main(String[] args) {
        processInput();
    }
}
