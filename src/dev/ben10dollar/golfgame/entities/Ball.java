package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;

import java.awt.*;

public abstract class Ball extends Entity {

    protected double radius;

    public Ball(Game game, double positionX, double positionY, double mass, double radius) {
        super(game, positionX, positionY, mass);
        this.radius = radius;
    }

}
