package com.rhqiq.ucberekelyjavadiscover.bowling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BowlingScoreTracker {

        private HashMap<String,BowlingScoreData> scoreTrackerCollection;

    public BowlingScoreTracker(){
        scoreTrackerCollection = new HashMap<>();
    }

    public static final class BowlingScoreData {

        int numOfGame;
        float aveScore;
        int lastScore;
        Date lastGameDate;

        public BowlingScoreData(int numOfGame, float aveScore, int lastScore, Date lastGameDate) {
            this.numOfGame = numOfGame;
            this.aveScore = aveScore;
            this.lastScore = lastScore;
            this.lastGameDate = lastGameDate;
        }
    }

    public void addGame(BowlingGame game){
        BowlingScoreData bowlingScoreData;
        if (scoreTrackerCollection.containsKey(game.getBowlerName())){
            bowlingScoreData = scoreTrackerCollection.get(game.getBowlerName());
            bowlingScoreData.aveScore = ((bowlingScoreData.aveScore * bowlingScoreData.numOfGame) + game.getGameScore()) / (bowlingScoreData.numOfGame + 1);
            bowlingScoreData.numOfGame ++;
            bowlingScoreData.lastGameDate  = game.getGameDate();
            bowlingScoreData.lastScore = game.getGameScore();

            scoreTrackerCollection.put(game.getBowlerName(),bowlingScoreData);
        }else{
            bowlingScoreData = new BowlingScoreData(1, game.getGameScore(), game.getGameScore(),game.getGameDate());
            scoreTrackerCollection.put(game.getBowlerName(), bowlingScoreData);
        }
    }

    public void printScoreTracker(){
        System.out.println("Bowler Name | Number Of Games | Ave Score | Last Game Score | Date of Last Game" );
        System.out.println("----------- | --------------- | --------- | --------------- | -----------------" );
        Iterator it = scoreTrackerCollection.entrySet().iterator();
        BowlingScoreData bowlingScoreData;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            bowlingScoreData = (BowlingScoreData) pair.getValue();
            System.out.printf("%11s | %15s | %9s | %15s | %12s \n", pair.getKey(), bowlingScoreData.numOfGame,
                    bowlingScoreData.aveScore, bowlingScoreData.lastScore , new SimpleDateFormat("MM-dd-yyyy").format(bowlingScoreData.lastGameDate));
            it.remove();
        }
    }

}
