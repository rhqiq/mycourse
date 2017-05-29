package com.rhqiq.ucberekelyjavadiscover.seven;

class Opt {
    int n;
    boolean valChk = false;

    synchronized int extract() {
        while (!valChk)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        System.out.println("Extracted: " + n);
        valChk = false;
        notify();
        return n;
    }

    synchronized void insert(int n) {
        while (valChk)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        this.n = n;
        valChk = true;
        System.out.println("Inserted: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Opt opt;

    Producer(Opt opt) {
        this.opt = opt;
        new Thread(this).start();
    }

    public void run() {
        int i = 1;
        while (i <= 10) {
            opt.insert(i++);
        }
    }
}

class Consumer implements Runnable {
    Opt opt;

    Consumer(Opt opt) {
        this.opt = opt;
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            opt.extract();
        }
    }
}

class ThreadTest {
    public static void main(String args[]) {
        Opt opt = new Opt();
        new Producer(opt);
        new Consumer(opt);
    }
}
