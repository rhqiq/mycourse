package com.rhqiq.assignment;

import java.util.Scanner;

public class SortString {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("please enter the number of strings you want to sort: ");
        int itemNum = sc.nextInt();

        String[] list = new String[itemNum];
        for (int i = 0; i < itemNum; i++){
            System.out.println("please enter your String : ");
            String inputString = sc.next();
            list[i] = inputString;
        }

        sortArray(list);

        System.out.println("\n\nThe Sorted list is: ");

        for (int i = 0; i < itemNum; i++){
            System.out.println(list[i]);
        }
    }

    //insertion sort implementation
    public static void sortArray(Comparable[] list){

        for (int i = 0;  i < list.length; i++){
            for (int j = i; j > 0; j--){
                if (list[j].compareTo(list[j-1]) < 0){
                    swap(list, j, j-1);
                }else {
                    break;
                }
            }
        }
    }

    //swap two element in an array
    public static void swap(Comparable[] list, int i, int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
