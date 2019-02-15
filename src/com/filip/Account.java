package com.filip;

import java.math.*;
import static com.filip.HelperMethods.*;

public class Account {

    private String type;
    private String owner;
    private String currency;
    private BigInteger balance; //balance in cents

    //default constructor
    public Account() {
        this("default", "Jon Doe", "$$$", 0);
    }

    //constructor
    public Account(String type, String owner, String currency, double balance ) throws IllegalArgumentException {
        this.type=type;
        this.owner=owner;

        if (balance>=0) {
            this.balance = convert(balance);
        }
        else {throw new IllegalArgumentException("Balance can not be negative.");

        }
        if (currency.length()==3)   {
            this.currency=currency.toUpperCase();
        }
        else {
            throw new IllegalArgumentException("Wrong currency. Currency must contain 3 " +
                    "letters (eg. PLN, EUR, USD)");
        }
    }



    public String getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    public String getCurrency() {
        return currency;
    }

    public BigInteger getBalance() {
        return balance;
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
        return "Account: " + this.type + "\nOwner: " + this.owner + "\nbalance: "
                + printBalance() + " " + this.currency;
    }
}
