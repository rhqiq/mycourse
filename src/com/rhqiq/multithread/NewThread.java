package com.rhqiq.multithread;

public class NewThread  implements Runnable {

    Thread t;

    public NewThread(String threadName){
        t = new Thread(this, threadName);
        System.out.println("child thread: " + t);
        t.start();
    }

    public void run(){
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(t.getName() + " Thread: " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Exiting " + t.getName() + " thread.");
    }
}
