package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.entities.Ball;

public class Player {

    private String name;
    private int strokes;
    private int totalScore;

    public Player(String name) {
        this.name = name;
        totalScore = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }
    public int getStrokes() {
        return strokes;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }
}
