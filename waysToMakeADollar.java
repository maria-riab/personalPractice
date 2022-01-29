package com.company;

public class Main {

    public static void main(String[] args) {
        int numberOfNickles = 0;
        int numberOfDimes = 0;
        int numberOfQuarters = 4;
        int numberOfWaysToMakeADollar = 0;
        int total = 100;

        while (5 * numberOfNickles <= total){
            if (numberOfQuarters * 25 + numberOfDimes * 10 + numberOfNickles * 5 == total){
                numberOfWaysToMakeADollar++;
            printNumberOfCoins(numberOfDimes, numberOfNickles, numberOfQuarters, total);
        }
            if (numberOfDimes > 0){
                numberOfDimes--;
                numberOfNickles+=2;
            } else if (numberOfQuarters > 0){
                numberOfQuarters--;
                numberOfDimes+=2;
                numberOfNickles++;
            } else {
                numberOfNickles++;
            }

            if (numberOfQuarters < 1) numberOfQuarters = 0;
            if (numberOfDimes < 1) numberOfDimes = 0;

        }
        System.out.println("There are " + numberOfWaysToMakeADollar + " number of ways to make " + total);


    }
    static void printNumberOfCoins(int dimes, int nickles, int quarters, int total){
        String numberOfCoinsInString = total + " = ";
        if (quarters > 0) numberOfCoinsInString += quarters + " number of quarters; ";
        if (dimes > 0) numberOfCoinsInString += dimes + " number of dimes; ";
        if (nickles > 0) numberOfCoinsInString += nickles + " number of nickles; ";

        System.out.println(numberOfCoinsInString);
    }

}
