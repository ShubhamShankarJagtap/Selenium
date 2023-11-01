package com.basic;

public class PrimeNumber {

    static private void getPrimeNumber(int number) {

        boolean flag = false;

        for (int i = 1; i <= number / 2; i++) {

            if (number % i == 0) {

                flag = true;
            }
        }

        if (flag) {

            System.out.println(number + " is not a prime number");
        } else {
            System.out.println(number + " is a prime number");
        }
    }

    public static void main(String[] args) {

        getPrimeNumber(2211);

    }
}
