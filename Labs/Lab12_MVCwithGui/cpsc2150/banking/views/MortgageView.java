package cpsc2150.banking.views;

import cpsc2150.banking.controllers.IMortgageController;

import java.util.Scanner;

public class MortgageView implements IMortgageView {
    Scanner in = new Scanner(System.in);
    IMortgageController controller;
    public MortgageView()
    { }

    @Override
    public void setController(IMortgageController c) {
        controller = c;
    }

    @Override
    public double getHouseCost() {
        System.out.println("How much does the house cost?");
        return in.nextDouble();
    }

    @Override
    public double getDownPayment() {
        System.out.println("What is the Down Payment");
        return in.nextDouble();
    }

    @Override
    public int getYears() {
        System.out.println("How many years is the loan?");
        return in.nextInt();
    }

    @Override
    public double getMonthlyDebt() {
        System.out.println("Mow much is the Monthly Debt?");
        return in.nextDouble();
    }

    @Override
    public double getYearlyIncome() {
        System.out.println("How much is your yearly income?");
        return in.nextDouble();
    }

    @Override
    public int getCreditScore() {
        System.out.println("What is the credit score?");
        return in.nextInt();
    }

    @Override
    public String getName() {
        System.out.println("What is your name?");
        return in.nextLine();
    }

    @Override
    public void printToUser(String s) {
        System.out.println(s);
    }

    @Override
    public void displayPayment(double p) {
        System.out.println("Monthly Payment: " + p);
    }

    @Override
    public void displayRate(double r) {
        System.out.println("Rate: " + r);
    }

    @Override
    public void displayApproved(boolean a) {
        System.out.println("Approved: " + a);

    }

    @Override
    public boolean getAnotherMortgage() {
        int count = 0;
        while (true) {
            if(count==0){
                System.out.println("Would you like to apply for another mortgage? (Y/N)");
            }
            count++;
            String res = in.nextLine();
            if (res.equals("Y") || res.equals("y")) {
                //test = 0;
                return true;
            }
            else if (res.equals("N") || res.equals("n")) {
                //test = 0;
                return false;
            }
        }
    }

    @Override
    public boolean getAnotherCustomer() {
        int test = 1;
        while (test == 1) {
            System.out.println("Would you like another Customer? (Y/N)");
            String res = in.nextLine();
            if (res.equals("Y") || res.equals("y")) {
                test = 0;
                return true;
            }
            if (res.equals("N") || res.equals("n")) {
                test = 0;
                return false;
            }
        }
        return false;
    }
}
