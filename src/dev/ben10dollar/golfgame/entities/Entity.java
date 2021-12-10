package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;

import java.awt.*;

public abstract class Entity {

    protected Game game;
    protected double positionX, positionY;
    protected double mass;

    public Entity(Game game, double positionX, double positionY, double mass) {
        this.game = game;
        this.positionX = positionX;
        this.positionY = positionY;
        this.mass = mass;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public double getPositionX() {
        return positionX;
    }
    public double getPositionY() {
        return positionY;
    }

}
