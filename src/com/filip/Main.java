package com.filip;

public class Main {

    public static void main(String[] args) {

        Account filip = new Account("Konto Filipa", 1.03);
        System.out.println(filip);
        System.out.println();
        filip.withdrawal(0.42);
//        filip.withdrawal(7000);
//        filip.deposit(5000);
        System.out.println(filip);
        System.out.println();
	// write your code here



        for (float f = 10f; f>0; f-=0.1) {
            System.out.println(f);
        }
    }
}
