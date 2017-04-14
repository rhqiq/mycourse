package com.rhqiq.learn;

public class StaticTest {

    public static int a = 2;
    public static int b;

    static {
        System.out.println("I am in static!");
        b = a + 4;
     }
}
