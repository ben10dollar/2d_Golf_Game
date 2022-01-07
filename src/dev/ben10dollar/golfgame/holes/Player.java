package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.entities.Ball;

public class Player {

    private String name;
    private int totalScore;

    public Player(String name) {
        this.name = name;
        totalScore = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
