package com.derek;

public class MortgageCalculator {

    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    private double mortgage;
    private float monthlyInterest;
    private int numberOfPayments;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;

        setMonthlyInterest();
        setNumberOfPayments();
        calculateMortgage();
    }

    public double[] getRemainingBalances() {
        var balances = new double[numberOfPayments];

        for (var month = 1; month <= numberOfPayments; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

    private double calculateBalance(int numberOfPaymentsMade) {
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }


    public double getMortgage() {
        return mortgage;
    }

    private void setMonthlyInterest() {
        monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private void setNumberOfPayments() {
        numberOfPayments = years * MONTHS_IN_YEAR;
    }

    private void calculateMortgage() {
        mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
