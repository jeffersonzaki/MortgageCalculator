package JavaMasteryCourse.Mortgage;

import java.text.NumberFormat;

public class MortgageReport {

    // Object Fields
    private final NumberFormat currency;
    private Calculations calculator;    // Creating a Calculations object b/c calculateBalance is static in its class

    // Constructor
    public MortgageReport(Calculations calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    // Prints out a format of remainingBalance method
    public void printRemainingBalance() {

        //calling balance method
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= RunMortgageCalculator.periodInYears * Calculations.monthInAYear; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(currency.format(balance));
        }
    }

    // Prints out a format for calculating mortgage
    public void printMortgage() {

        //calling the mortgage method
        double mortgage = calculator.calculateMortgage();   // Using calculator object
        System.out.println("\nMORTGAGE");
        System.out.print("--------");
        String mortgageFormatted = currency.format(mortgage);     //formatting mortgage to currency
        System.out.println("\nMonthly Payments: " + mortgageFormatted);      //print estimated mortgage. Display as currency
    }
}
