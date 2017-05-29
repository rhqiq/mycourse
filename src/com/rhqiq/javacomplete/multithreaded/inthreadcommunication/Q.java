package com.rhqiq.javacomplete.multithreaded.inthreadcommunication;

public class Q {
    int n;
    boolean valueSet = false;

    public synchronized int get() {

        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;

        notify();
        return n;

    }

    public synchronized void put(int n) {
        
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true;
        notify();
    }
}
