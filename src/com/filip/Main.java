package com.filip;


public class Main {


    public static void main(String[] args) {

        Account test = new Account("PLN","Test account", 100);

        System.out.println(test);
        System.out.println(test.getBalance());

        test.deposit(50.6);
        System.out.println(test);
        System.out.println(test.getBalance());

        test.withdrawal(200);
        System.out.println(test);
        System.out.println(test.getBalance());

        test.withdrawal(70.594999999999);
        System.out.println(test);
        System.out.println(test.getBalance());





        }
    }

