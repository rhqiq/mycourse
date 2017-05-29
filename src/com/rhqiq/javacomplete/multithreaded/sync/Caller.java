package com.rhqiq.javacomplete.multithreaded.sync;

public class Caller implements Runnable {

    String msg;
    Thread t;
    Callme target;

    public Caller(Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.run();
    }

    public void run(){
        synchronized (target){
            target.call(msg);
        }
    }
}
