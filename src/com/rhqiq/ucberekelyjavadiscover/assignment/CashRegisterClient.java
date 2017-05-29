    package com.rhqiq.ucberekelyjavadiscover.assignment;

    public class CashRegisterClient {

        public static void main(String[] args) {

            CashRegister cr1 = new CashRegister();
            System.out.println("first cash register is created.");
            cr1.addTransaction(33.5);
            System.out.println("33.5 added to first cash register.");
            cr1.addTransaction(56.4);
            System.out.println("56.4 added to first cash register.");
            cr1.addTransaction(84.2);
            System.out.println("84.2 added to first cash register.");

            System.out.format("total amount of first cash register is: %.2f \n", cr1.total());
            System.out.println("number of received transactions for first cash register is: " + cr1.transactionCount());

            CashRegister cr2 = new CashRegister();
            System.out.println("second cash register is created.");
            cr2.addTransaction(24.3);
            System.out.println("24.3 added to second cash register.");
            cr2.addTransaction(12.6);
            System.out.println("12.6 added to second cash register.");
            cr2.addTransaction(29.1);
            System.out.println("29.1 added to second cash register.");

            System.out.format("total amount of second cash register is: %.2f \n" , cr2.total());
            System.out.println("number of received transactions for second cash register is: " + cr2.transactionCount());

            System.out.println(" number of cash registers created is: " + CashRegister.registerCount());

            cr1.resetTransactions();
            System.out.format("total amount of first cash register after reset is: %.2f \n", cr1.total());
            System.out.println("number of received transactions for first cash register after reset is: " + cr1.transactionCount());

            cr2.resetTransactions();
            System.out.format("total amount of second cash register after reset is: %.2f \n" , cr2.total());
            System.out.println("number of received transactions for second cash register after reset is: " + cr2.transactionCount());
        }
    }
