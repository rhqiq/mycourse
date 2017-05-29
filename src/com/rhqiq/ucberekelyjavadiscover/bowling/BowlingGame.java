package com.rhqiq.ucberekelyjavadiscover.bowling;

import java.util.Date;

public class BowlingGame {

    private String bowlerName;
    private int gameScore;
    private Date gameDate;


    public BowlingGame(String bowlerName, int gameScore, Date gameDate) {
        this.bowlerName = bowlerName;
        this.gameScore = gameScore;
        this.gameDate = gameDate;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
}
