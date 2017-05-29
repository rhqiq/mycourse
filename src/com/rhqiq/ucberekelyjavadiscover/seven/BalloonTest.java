package com.rhqiq.ucberekelyjavadiscover.seven;

public class BalloonTest {

    public static void main(String[] args) {
        Balloon b = new Balloon(100);
        try{
            b.inflate(10);
            b.inflate(40);
            b.inflate(60);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
