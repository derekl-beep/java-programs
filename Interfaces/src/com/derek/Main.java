package com.derek;

public class Main {

    public static void main(String[] args) {
	// write your code here

        var calculator = new TaxCalculator2018(100_000);
        var report = new TaxReport(calculator);
        report.show();

        report.setCalculator(new TaxCalculator2019());
        report.show();
    }
}
