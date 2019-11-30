package JavaMasteryCourse.Mortgage;

public class Calculations {

    final private static double percent = 100;
    final static double monthInAYear = 12;

    private double principal;
    private int annualInterestRate;
    private int periodInYears;


    // Constructor
    public Calculations(double principal, int annualInterest, int periodInYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterest;
        this.periodInYears = periodInYears;
    }

    // Public method that calculates the user's mortgage with the information provided from user input
    public double calculateMortgage() {

        double monthlyInterestRate = getMonthlyInterestRate(); //find monthly interest rate
        double numberOfPayments = getNumberOfPayments();              //number of payments

        //calculate mortgage
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return mortgage;
    }


    // Calculates the user's balance using the information that is provided from the user
    public double calculateBalance (int numberOfPaymentsMade) {

        double monthlyInterestRate = getMonthlyInterestRate(); //find monthly interest rate
        double numberOfPayments = getNumberOfPayments();              //number of payments

        double balance = principal * ((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                                    - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return balance;
    }


    // Declared as private b/c they're implementation detail
    private double getMonthlyInterestRate() {
        return annualInterestRate / percent / monthInAYear;
    }

    private double getNumberOfPayments() {
        return periodInYears * monthInAYear;
    }
}
