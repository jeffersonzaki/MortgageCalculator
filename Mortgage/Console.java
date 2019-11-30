package JavaMasteryCourse.Mortgage;

import java.util.Scanner;

public class Console {
    private static Scanner userInput = new Scanner(System.in);

    // public method that reads the number and sets the min and max
    public static double readNumber(String prompt, double min, double max) {
        double value;

        // While loop that repeats prompt until min and max are followed
        while (true) {
            System.out.print(prompt);           //giving user a prompt/question
            value = userInput.nextDouble();      //user will enter a value that's read as a double
            if ((value >= min) && (value <= max))
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;    //post-condition: reads user's input value
    }

    // Overload public method that reads the number and sets the min and max
    public static double readNumber(String prompt) {
        return userInput.nextDouble();
    }
}
