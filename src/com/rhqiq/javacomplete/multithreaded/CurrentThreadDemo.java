package com.rhqiq.javacomplete.multithreaded;

public class CurrentThreadDemo {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println("current thread is " + t);

        t.setName("My Thread");
        System.out.println("After changing name + " + t);

        try {
            for (int i = 0; i < 5; i++ ){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
