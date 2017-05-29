package com.rhqiq.ucberekelyjavadiscover.seven;


public class SampleThreads {
    int data = 0;

    synchronized void insert(int s) {
        try {
            while (data != 0) {
                // data already holds a string
                // wait for some other Thread
                //to remove it!
                // awaken one other waiting Thread
                notify();
                // release the monitor
                wait();
            }
        } catch (InterruptedException e) {
        }
        // data is now null
        data = s;
        notify();
    }

    synchronized int extract() {
        try {
            while (data == 0) {
                // no data to extract
                // wait for some to arrive
                // awaken one other waiting Thread
                notify();
                // release the monitor and go to sleep
                wait();
            }
        } catch (InterruptedException e) {
        }

        // data is now not full
        int temp = data;
        data = 0;
        notify();
        return temp;
    }
    // more methods
}