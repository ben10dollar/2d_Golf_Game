package dev.ben10dollar.golfgame.entities;

import java.awt.*;

public abstract class Entity {

    protected double positionX, positionY;
    protected double mass;

    public Entity(double positionX, double positionY, double mass) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.mass = mass;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
