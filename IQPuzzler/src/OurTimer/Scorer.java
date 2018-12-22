package OurTimer;


public class Scorer {
    private int score;
    private int numOfMoves;
    private double multiplier;
    private int difficultyLevel;
    private int timeLeft;

    public Scorer(int difficultyLevel, int timeLeft) {
        score = 0;
        numOfMoves = 0;
        multiplier = 0;
        this.difficultyLevel = difficultyLevel;
        this.timeLeft = timeLeft;

    }

    public int getFinalScore(int numOfMoves) {
        setMultiplier();
        setNumOfMoves(numOfMoves);
        return calculateScore(this.numOfMoves, this.timeLeft);
    }

    private void setNumOfMoves(int numOfMoves) {
        this.numOfMoves = numOfMoves;
    }

    private void setMultiplier(){

        if (difficultyLevel == 1){
            multiplier = 0.5;
        }
        else if(difficultyLevel == 2) {
            multiplier = 1;
        }
        else if(difficultyLevel == 3) {
            multiplier = 2;
        }
        else if(difficultyLevel == 4) {
            multiplier = 4;
        }
        else if(difficultyLevel == 5) {
            multiplier = 8;
        }
        else if(difficultyLevel == 6) {
            multiplier = 16;
        }
    }

    private int calculateScore(int numOfMoves, int timeLeft) {
        int bonus = 0;
        this.score = 0;
        if(numOfMoves <= 15){
            bonus = 30;
        }
        else if (numOfMoves <= 20){
            bonus = 20;
        }
        else if (numOfMoves <= 30){
            bonus = 15;
        }

        if(timeLeft > 0){
            score =(int) ((timeLeft * multiplier) + bonus);
            return score;
        }
        score = bonus;
        return score;
    }
}
