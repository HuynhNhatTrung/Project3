package com.example.btchuong4_;

// MortgageCalculator.java
public class MortgageCalculator {
    public static double calculateMortgage(double loanAmount, double annualInterestRate, int loanTermInYears) {
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int loanTermInMonths = loanTermInYears * 12;
        double monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths)) / (Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1);
        return monthlyPayment;
    }

    public static double calculateTotalPayment(double monthlyPayment, int loanTermInYears) {
        return monthlyPayment * loanTermInYears * 12;
    }
}
