package com.derek;

public class Main {

    public static void main(String[] args){

        var principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        var annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        var years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}