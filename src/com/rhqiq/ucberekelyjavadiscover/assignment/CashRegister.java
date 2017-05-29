package com.rhqiq.ucberekelyjavadiscover.assignment;

public class CashRegister {

    private int transaction;
    private double totalAmount;
    private static int register = 0;

    public CashRegister() {
        transaction = 0;
        totalAmount = 0;
        register ++;
    }

    public void addTransaction(double amount){
        transaction ++;
        totalAmount += amount;
    }

    public int transactionCount(){
        return transaction;
    }

    public double total(){
        return totalAmount;
    }

    public void resetTransactions(){
        transaction = 0;
        totalAmount = 0;
    }

    public static int registerCount(){
        return register;
    }
}
