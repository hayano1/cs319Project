package com.iqpuzzler.model;

public class CurrentGameScorer {
    private int currentScore;
    private int currentMultiplier;
    private boolean gameOn;

    CurrentGameScorer(){
        this.currentScore = 0;
        this.currentMultiplier = 1;
        this.gameOn  = true;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    //public int saveScore(){}

    public void incrementScore(){
    this.currentScore = this.currentScore + currentMultiplier;
    }

    public void doubleCurrentMultiplier(){
        this.currentMultiplier = 2 * this.currentMultiplier;
    }

    public void halveCurrentMultiplier(){
        this.currentMultiplier = this.currentMultiplier / 2;
    }

    private void finalScoreIncrement(double timeLeft){
        int time = (int) Math.round(timeLeft);
        currentScore = currentScore + (currentMultiplier * time);
    }

    public int getFinalScore(double timeLeft){
        if(!this.gameOn){
            finalScoreIncrement(timeLeft);
            return currentScore;
        }
        return -1;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }
}
