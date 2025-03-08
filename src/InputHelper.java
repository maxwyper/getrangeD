import java.util.Scanner;

public class InputHelper {

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result = 0.0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: "); // Append the range to the prompt
            if (pipe.hasNextDouble()) { // Check if the input is a valid double
                result = pipe.nextDouble(); // Read the double
                pipe.nextLine(); // Clear the input buffer (newline fix)
                if (result >= low && result <= high) { // Check if the value is within the range
                    validInput = true; // Valid input received
                } else {
                    System.out.println("Invalid input: " + result + " is out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard the invalid input
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid double.");
            }
        } while (!validInput);

        return result;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double userDouble = getRangedDouble(console, "Enter a double value", 1.0, 10.0);
        System.out.println("You entered: " + userDouble);
    }
}
