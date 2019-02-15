package com.filip;

import java.math.*;
import static com.filip.HelperMethods.*;

public class SavingAccount extends Account {

    private BigDecimal interestRate;
    private int availWithdrawals;

    public SavingAccount(String owner, String currency, double balance, double interestRate,
                         int availWithdrawals) throws IllegalArgumentException {
        super("Saving Account", owner, currency, balance );

        if (availWithdrawals>0 || interestRate>0) {
            this.availWithdrawals = availWithdrawals;
            this.interestRate = round(interestRate);
        }
        else {
            throw new IllegalArgumentException("InterestRate and availWithdrawals must be greater than 0");
        }
    }

    @Override
    public void withdrawal(double amount) {
        if (this.availWithdrawals==0) {
            System.out.println("You've exceeded withdrawals limit.");
        }
        else if (amount>this.getBalance().doubleValue()/100) {
            System.out.println("Not enough funds.");
        }
        else {
            super.withdrawal(amount);
            this.availWithdrawals--;
        }
    }

    public String toString() {

        return "\n" + super.toString() + "\nInterest Rate: " + this.interestRate +
                "\nAvailable withdrawals: " + availWithdrawals;
    }

}
