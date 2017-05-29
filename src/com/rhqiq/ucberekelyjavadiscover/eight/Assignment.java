package com.rhqiq.ucberekelyjavadiscover.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("please enter your full url:");
        //example: http://csb.stanford.edu/class/public/pages/sykes_webdesign/05_simple.html

        String urlStr = sc.next();

        System.out.println("please enter your line number:");
        int lineNum = sc.nextInt();

        System.out.println(fetchData(urlStr, lineNum));
    }

    public static String fetchData(String urlStr, int lineNum)
    {
        String thisLine = null;
        ArrayList<String> sl = new ArrayList<>();

        try {
            URL u = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

            int counter = 0;
            while ((thisLine = br.readLine()) != null) {

                if (lineNum > 0 && lineNum == counter )
                    break;
                sl.add(thisLine);
                counter ++;
            }

            return buildMyString(sl, lineNum);

        }catch (MalformedURLException e){
            return e.getMessage();
        }catch (IOException e){
            return e.getMessage();
        }
    }

    public static String buildMyString(ArrayList<String> sl, int lineNum)
    {
        StringBuilder result = new StringBuilder("");

        int start;
        int end;

        if (lineNum >= 0){
            start = 0;
            end = sl.size();
        }else {
            start = sl.size() + lineNum;
            end = sl.size();
        }

        while (start < end){
            result.append(sl.get(start ++) + "\n");
        }

        return result.toString();
    }


}
