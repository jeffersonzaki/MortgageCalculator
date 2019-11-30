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

package JavaMasteryCourse.Mortgage;


public class RunMortgageCalculator {

    // ---------------------------------Static Fields-----------------------------------------------------------------
    // Belongs to a class, not an object

    final static double principal = Console.readNumber("Principal: ", 1000, 1_000_000);
    final static int annualInterestRate = (int) Console.readNumber("APR(%): ", 1, 30);
    final static int periodInYears = (int) Console.readNumber("Period: ", 1, 30);

    // ---------------------------------------------------------------------------------------------------------------


    // * Main Method * //
    public static void main(String[] args) {
        var calculator = new Calculations(principal, annualInterestRate, periodInYears);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printRemainingBalance();
    }
}
