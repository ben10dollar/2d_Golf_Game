package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Handler;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public static final double DEFAULT_MASS = 10;

    protected Handler handler;
    protected double x, y, lastX, lastY, mass;
    protected int width, height;
    protected Hole hole;
    protected Rectangle bounds;
    protected BufferedImage skin;

    public Entity(Handler handler, Hole hole, int width, int height, double mass, BufferedImage skin) {
        this.handler = handler;
        x = hole.getSpawnX() - width/2;
        y = hole.getSpawnY() - height/2;
        lastX = x;
        lastY = y;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.skin = skin;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public double getMass() {
        return mass;
    }
    public int getHeight() {
        return height;
    }
    public Rectangle getBounds() {
        return bounds;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
