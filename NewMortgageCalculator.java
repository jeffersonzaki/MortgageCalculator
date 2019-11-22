/*
 * Project:     Mortgage Calculator
 * Description: Takes user input and prints out
 *              their mortgage. As well as
 *              making their remaining
 *              balance visible after each month
 *              of payment.
 *
 * // Pre-Condition: All input variables must me positive
 * // Post-Condition: Will print out user's mortgage and remaining balance in USD
 *
 */

package JavaMasteryCourse.PracticeProjects;

import java.text.NumberFormat;
import java.util.*;


public class NewMortgageCalculator {
    static double percent = 100;
    static double monthInAYear = 12;

    //public method that reads the number and sets the min and max
    public static double readNumber(String prompt, double min, double max) {
        Scanner userInput = new Scanner(System.in);
        double value;

        //while loop that repeats prompt until min and max are followed
        while (true) {
            System.out.print(prompt);           //giving user a prompt/question
            value = userInput.nextDouble();      //user will enter a value that's read as a double
            if ((value >= min) && (value <= max))
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;    //post-condition: reads user's input value
    }

    //public method that returns mortgage
    public static double calculateMortgage(double principal, int annualInterestRate, int periodInYears) {

        double monthlyInterestRate = annualInterestRate / percent / monthInAYear; //find monthly interest rate
        double numberOfPayments = periodInYears * monthInAYear;              //number of payments

        //calculate mortgage
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return mortgage;
    }

    public static double calculateBalance (double principal, int annualInterestRate, int periodInYears, int numberOfPaymentsMade) {

        double monthlyInterestRate = annualInterestRate / percent / monthInAYear; //find monthly interest rate
        double numberOfPayments = periodInYears * monthInAYear;              //number of payments

        double balance = principal * ((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                                    - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return balance;
    }


    // * Main Method * //
    public static void main(String[] args) {

        double principal = readNumber("Principal: ", 1000, 1_000_000);
        int annualInterestRate = (int) readNumber("APR(%): ", 1, 30);
        int periodInYears = (int) readNumber("Period: ", 1, 30);

        //calling the mortgage method
        double mortgage = calculateMortgage(principal, annualInterestRate, periodInYears);
        System.out.println("\nMORTGAGE");
        System.out.print("--------");
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);     //formatting mortgage to currency
        System.out.println("\nMonthly Payments: " + mortgageFormatted);      //print estimated mortgage. Display as currency

        //calling balance method
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= periodInYears * monthInAYear; month++) {
            double balance = calculateBalance(principal, annualInterestRate, periodInYears, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
