package com.filip;

import java.math.*;

public class Account {

    private String currency;
    private String name;
    private BigInteger balance; // balance in cents

    public Account()    {
        this("$$$", "default", 0);
    }

    public Account(String currency, String name, double balance) throws IllegalArgumentException {

        if (currency.length()==3)   {
            this.currency=currency.toUpperCase();
        }
        else {
            throw new IllegalArgumentException("Wrong currency. Currency must contain 3 " +
                    "letters (eg. PLN, EUR, USD)");
        }

        this.name = name;
        this.balance = convert(balance);

    }

    //method for rounding the balance up to 2 decimal points
    public static BigDecimal round(double value) {

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    // method for converting the double value to BigInteger value
    public static BigInteger convert(double value) {

        BigDecimal bd = new BigDecimal(100);
        return round(value).multiply(bd).toBigInteger();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Wrong value.");
        } else {
            this.balance = getBalance().add(convert(amount));
        }
    }

    public void withdrawal(double amount) {
        if (this.balance.doubleValue() / 100 < amount) {
            System.out.println("Not enough funds.");
        } else {
            this.balance = getBalance().subtract(convert(amount));
        }
    }

    //method for printing balance with 2 decimal points
    public String printBalance() {
        double doubleBalance = this.balance.doubleValue() / 100;
        return String.format("%.2f", doubleBalance);
    }

    @Override
    public String toString() {
        return "Account named '" + this.name + "' has "
                + printBalance() + " " + this.currency + ".";
    }
}
