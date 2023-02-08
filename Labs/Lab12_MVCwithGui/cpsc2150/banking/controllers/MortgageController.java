package cpsc2150.banking.controllers;

import cpsc2150.banking.controllers.IMortgageController;
import cpsc2150.banking.models.*;
import cpsc2150.banking.views.IMortgageView;

public class MortgageController implements IMortgageController {

    private IMortgageView view;

    public MortgageController(IMortgageView v) {
        view = v;

    }

    @Override
    public void submitApplication() {
        boolean test = true;

        String name = view.getName();

        Double yearIn = 0.0;
        while(yearIn <= 0){
            yearIn = view.getYearlyIncome();
            if(yearIn>0)
                break;
            else{
                view.printToUser("Income Must be Greater than 0");
            }
        }


        Double monthlyDebt = 0.0;
        while(monthlyDebt <= 0){
            monthlyDebt = view.getMonthlyDebt();
            if(monthlyDebt>0)
                break;
            else{
                view.printToUser("Debt must be greater than or equal to 0");
            }
        }

        int creditScore = -1;
        while(creditScore < 0 || creditScore > 850){
            creditScore = view.getCreditScore();
            if(creditScore > 0 && creditScore < 850)
                break;
            else{
                view.printToUser("Credit Score must be greater than 0 and less than 850");
            }
        }
        Double houseCost = 0.0;
        while(houseCost <= 0){
            houseCost = view.getHouseCost();
            if(houseCost>0)
                break;
            else{
                view.printToUser("Cost must be greater than 0");
            }
        }
        Double downPayment = 0.0;
        while(downPayment <= 0 || downPayment > houseCost){
            downPayment = view.getDownPayment();
            if(downPayment>0 && downPayment < houseCost)
                break;
            else{
                view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
            }
        }
        int years = 0;
        while(years <= 0){
            years = view.getYears();
            if(years>0)
                break;
            else{
                view.printToUser("Years must be greater than 0");
            }
        }



        ICustomer c = new Customer(monthlyDebt, yearIn, creditScore, name);
        Mortgage m = new Mortgage(houseCost, downPayment, years, c);



        while (test == true) {
            // public Mortgage(double houseCost,double downPayment, int years, ICustomer n){
            view.printToUser("Name: " + c.getName());
            view.printToUser("Income: " + c.getIncome());
            view.printToUser("Credit Score:" + c.getCreditScore());
            view.printToUser("Monthly Debt: " + c.getMonthlyDebtPayments());
            view.printToUser("Mortgage Info:");
            view.printToUser("Principal Amount: " + m.getPrincipal());
            view.displayRate(m.getRate());
            view.printToUser("Term: " + m.getYears());
            view.displayPayment(m.getPayment());

            if (view.getAnotherMortgage())
            {

                houseCost = 0.0;
                while(houseCost <= 0){
                    houseCost = view.getHouseCost();
                    if(houseCost>0)
                        break;
                    else{
                        view.printToUser("Cost must be greater than 0");
                    }
                }

                downPayment = 0.0;
                while(downPayment <= 0 || downPayment > houseCost){
                    downPayment = view.getDownPayment();
                    if(downPayment>0 && downPayment < houseCost)
                        break;
                    else{
                        view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
                    }
                }
                years = 0;
                while(years <= 0){
                    years = view.getYears();
                    if(years>0)
                        break;
                    else{
                        view.printToUser("Years must be greater than 0");
                    }
                }

                m = new Mortgage(houseCost, downPayment, years, c);
            }





            else if (view.getAnotherCustomer()) {

                name = view.getName();

                yearIn = 0.0;
                while(yearIn <= 0){
                    yearIn = view.getYearlyIncome();
                    if(yearIn>0)
                        break;
                    else{
                        view.printToUser("Income Must be Greater than 0");
                    }
                }

                monthlyDebt = 0.0;
                while(monthlyDebt <= 0){
                    monthlyDebt = view.getMonthlyDebt();
                    if(monthlyDebt>0)
                        break;
                    else{
                        view.printToUser("Debt must be greater than or equal to 0");
                    }
                }

                creditScore = -1;
                while(creditScore < 0 || creditScore > 850){
                    creditScore = view.getCreditScore();
                    if(creditScore > 0 && creditScore < 850)
                        break;
                    else{
                        view.printToUser("Credit Score must be greater than 0 and less than 850");
                    }
                }
                houseCost = 0.0;
                while(houseCost <= 0){
                    houseCost = view.getHouseCost();
                    if(houseCost>0)
                        break;
                    else{
                        view.printToUser("Cost must be greater than 0");
                    }
                }
                downPayment = 0.0;
                while(downPayment <= 0 || downPayment > houseCost){
                    downPayment = view.getDownPayment();
                    if(downPayment>0 && downPayment < houseCost)
                        break;
                    else{
                        view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
                    }
                }
                years = 0;
                while(years <= 0){
                    years = view.getYears();
                    if(years>0)
                        break;
                    else{
                        view.printToUser("Years must be greater than 0");
                    }
                }



                c = new Customer(monthlyDebt, yearIn, creditScore, name);
                m = new Mortgage(houseCost, downPayment, years, c);
            }
            else test = false;
        }
    }
}
