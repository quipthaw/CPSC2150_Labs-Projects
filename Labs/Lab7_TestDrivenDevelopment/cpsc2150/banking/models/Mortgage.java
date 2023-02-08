package cpsc2150.banking.models;

//what we have to implement

import jdk.jfr.Percentage;

import java.util.PrimitiveIterator;

public class Mortgage extends AbsMortgage implements IMortgage {


    /**
     * @invariant Payment = (Rate * Principal) / (1-(1+Rate)^ -NumberOfPayments) AND
     *            0 <= Rate <= 1 AND
     *            0 < DebtToIncomeRatio AND
     *            MIN_YEARS * 12 <= NumberOfPayments <= MAX_YEARS * 12 AND
     *            0 < Principal AND
     *            0 <= PercentDown < 1 AND
     *            InitRate = BASERATE * 100;
     *
     * Correspondence self.InitRate = InitRate AND
     *                self.Payment = Payment AND
     *                self.Rate = Rate AND
     *                self.Customer = c AND
     *                self.DebtToIncomeRatio = DebtToIncomeRatio AND
     *                self.Principal = Principle AND
     *                self.NumberOfPayments = NumberOfPayments AND
     *                self.PercentDown = PercentDown
     */


    private double InitRate = 2.5;
    private double CreditScore;
    private double Payment;
    private int Years;
    private double Rate;
    private ICustomer c;
    private double DebtToIncomeRatio;
    private double Principal;
    private int NumberOfPayments;
    private double PercentDown;

    /**
     * This creates a new object to keep track information for a mortgage.
     *
     * @param houseCost the price of the house for the mortgage
     * @param downPayment the down payment on the mortgage
     * @param years the number of years the mortgage is over
     * @param n The customer of the mortgage
     *
     * @pre houseCost >= 0 AND
     *      downPayment >= 0 AND
     *      years >=0 AND
     *      n is an existing customer
     *
     * @post Years = years AND
     *       CreditScore = n.getCreditScore() AND
     *       Principal = houseCost - downPayment AND
     *       PercentDown = downPayment / houseCost AND
     *       DebtToIncomeRatio = MonthlyDebtPayments / MonthlyIncome AND
     *       NumberOfPayment = Years * 12 AND
     *       Rate = Annual Percentage AND
     *       Payment = (Rate * Principal) / (1-(1+Rate)^ -NumberOfPayments)
     */
    public Mortgage(double houseCost,double downPayment, int years, ICustomer n){

        Years = years;
        Principal = houseCost - downPayment;
        DebtToIncomeRatio = n.getMonthlyDebtPayments()/(n.getIncome()/12);
        PercentDown = downPayment/houseCost;
        NumberOfPayments = years * 12;

        Rate = InitRate;
        if(years < 30){ Rate += 0.5; }
        else { Rate += 1.0; }
        if(PercentDown < 0.20) { Rate += 0.5; }
        CreditScore = n.getCreditScore();
        if(CreditScore < 500) { Rate += 10; }
        else if(CreditScore < 600) { Rate += 5; }
        else if(CreditScore < 700) { Rate += 1; }
        else if(CreditScore < 750) { Rate += 0.5; }

        Rate = Rate / 100;

        Payment = ((Rate/12)*Principal)/(1-(Math.pow(1+(Rate/12), -1*(NumberOfPayments))));
    }

    @Override
    public boolean loanApproved() {
        if((Rate < RATETOOHIGH) && (PercentDown >= MIN_PERCENT_DOWN) && (DebtToIncomeRatio < DTOITOOHIGH))
            return true;
        return false;
    }

    @Override
    public double getPayment() {
        return Payment;
    }

    @Override
    public double getRate() {
        return Rate;
    }

    @Override
    public double getPrincipal() {
        return Principal;
    }

    @Override
    public int getYears() {
        return Years;
    }
}
