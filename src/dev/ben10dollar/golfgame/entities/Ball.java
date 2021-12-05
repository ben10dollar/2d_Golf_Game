package dev.ben10dollar.golfgame.entities;

import java.awt.*;

public abstract class Ball extends Entity {

    protected double radius;

    public Ball(double positionX, double positionY, double mass, double radius) {
        super(positionX, positionY, mass);
        this.radius = radius;
    }

}
