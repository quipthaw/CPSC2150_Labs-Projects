package cpsc2150.banking.controllers;

import cpsc2150.banking.models.Customer;
import cpsc2150.banking.models.ICustomer;
import cpsc2150.banking.models.Mortgage;
import cpsc2150.banking.views.*;

public class MortgageGUIController implements IMortgageController {
    private IMortgageView view;

    public MortgageGUIController(IMortgageView v) {
        view = v;
    }

    //Called by MortgageGUIView
    public void submitApplication() {
        String name = view.getName();
        Double yearIn = 0.0;
        yearIn = view.getYearlyIncome();
        if(yearIn<=0)
            view.printToUser("Income Must be Greater than 0");

        Double monthlyDebt = 0.0;
        monthlyDebt = view.getMonthlyDebt();
        if(monthlyDebt<0)
            view.printToUser("Debt must be greater than or equal to 0");

        int creditScore = 0;
        creditScore = view.getCreditScore();
            if(creditScore <= 0 || creditScore > 850)
                view.printToUser("Credit Score must be greater than 0 and less than 850");

        Double houseCost = 0.0;
        houseCost = view.getHouseCost();
        if(houseCost<=0)
            view.printToUser("House cost Must be Greater than 0");

        Double downPayment = 0.0;
        downPayment = view.getDownPayment();
        if(downPayment<=0 || downPayment > houseCost)
            view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");

        int years = 0;
            years = view.getYears();
            if(years<=0)
                view.printToUser("Years must be greater than 0");


        ICustomer c = new Customer(monthlyDebt, yearIn, creditScore, name);
        Mortgage m = new Mortgage(houseCost, downPayment, years, c);
        //Display approved messages
        view.displayApproved(m.loanApproved());
        view.displayPayment(m.getPayment());
        view.displayRate(m.getRate());
    }
}
