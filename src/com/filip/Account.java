package com.filip;

import java.math.*;

public class Account {

    private String name;
    private double balance;

    public Account(double balance) {
        this("default account", balance);
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit (double amount) {
        this.balance+=amount;
    }

    public void withdrawal (double amount) {
        if (amount > this.balance) {
            System.out.println("Not enough funds");
        } else {
            this.balance -= amount;
        }
    }

    //method for rounding the balance up to 2 decimal points
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //method for printing balance with 2 decimal points
    public String printBalance(){
        double balance = round(getBalance(),2);
        return String.format("%.2f", balance);

    }

    @Override
    public String toString() {
        return "Account named '" + this.getName() + "'  has "
                + printBalance() + " funds";
    }
}
