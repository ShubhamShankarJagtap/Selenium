package com.basic;

public class Factorial {

    static private int factorial(int number) {

        int fact = 1;

        for (int i = 1; i <= number; i++) {

            fact = number * i;
        }

        return fact;
    }

    public static void main(String[] args) {

        int Fact = factorial(22);

        System.out.println("Factorial of given number is : " + Fact);
    }
}
