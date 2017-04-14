package com.rhqiq.bowling;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Client {

    public static void main(String[] args) throws ParseException{
        BowlingGame game1 = new BowlingGame("Reza", 20, new SimpleDateFormat("MM-dd-yyyy").parse("03-01-2017"));
        BowlingGame game2 = new BowlingGame("Nooshin", 30, new SimpleDateFormat("MM-dd-yyyy").parse("03-01-2017"));
        BowlingGame game3 = new BowlingGame("Reza", 25, new SimpleDateFormat("MM-dd-yyyy").parse("03-02-2017"));
        BowlingGame game4 = new BowlingGame("Nooshin", 40, new SimpleDateFormat("MM-dd-yyyy").parse("03-02-2017"));
        BowlingGame game5 = new BowlingGame("Reza", 35, new SimpleDateFormat("MM-dd-yyyy").parse("03-03-2017"));
        BowlingGame game6 = new BowlingGame("Nooshin", 35, new SimpleDateFormat("MM-dd-yyyy").parse("03-03-2017"));

        BowlingScoreTracker bowlingScoreTracker1 = new BowlingScoreTracker();
        bowlingScoreTracker1.addGame(game1);
        bowlingScoreTracker1.addGame(game2);
        bowlingScoreTracker1.addGame(game3);
        bowlingScoreTracker1.addGame(game4);
        bowlingScoreTracker1.addGame(game5);
        bowlingScoreTracker1.addGame(game6);

        bowlingScoreTracker1.printScoreTracker();
    }
}
