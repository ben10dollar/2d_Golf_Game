package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected double positionX, positionY;
    protected double mass;
    protected Rectangle bounds;

    public Entity(Handler handler, double positionX, double positionY, double mass) {
        this.handler = handler;
        this.positionX = positionX;
        this.positionY = positionY;
        this.mass = mass;
        bounds = new Rectangle();
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
