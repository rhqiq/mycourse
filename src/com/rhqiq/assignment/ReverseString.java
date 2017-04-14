package com.rhqiq.assignment;

import java.util.Scanner;

public class ReverseString {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("please enter your String:");
        String str = sc.next();
        System.out.println("The reverse of " + str + " is: " + reverse(str));


    }

    public static String reverse(String str){

        if (str.length() == 1 ){
            return str;
        }

        char firstChar = str.charAt(0);
        String res = reverse(str.substring(1));

        return res + firstChar;
    }
}
