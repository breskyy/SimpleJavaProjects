import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;

        while (runAgain) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operation (+, -, *, /): ");
            String operation = scanner.next();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case "-":
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case "*":
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero!");
                    } else {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
            }

            System.out.print("Do you want to calculate again? (y/n): ");
            String answer = scanner.next();

            if(!answer.equalsIgnoreCase("y")) {
                runAgain = false;
                System.out.println("Goodbye!");
            }
        }

        scanner.close();
    }
}
