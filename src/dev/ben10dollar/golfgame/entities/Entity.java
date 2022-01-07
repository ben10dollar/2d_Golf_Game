package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.holes.Player;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public static final double DEFAULT_MASS = 10;

    protected Player player;
    protected Handler handler;
    protected double x, y, lastX, lastY, mass;
    protected int width, height;
    protected Hole hole;
    protected Rectangle bounds;
    protected BufferedImage skin;
    protected boolean visible;

    public Entity(Handler handler, Player player, int width, int height, double mass, BufferedImage skin) {
        this.handler = handler;
        this.player = player;
        if(hole != null) {
            x = hole.getSpawnX() - width / 2;
            y = hole.getSpawnY() - height / 2;
        }
        lastX = x;
        lastY = y;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.skin = skin;
        visible = true;

//        bounds = new Rectangle( (int).25 * width, (int).25 * height, (int).75 * width, (int).75 * height);
        bounds = new Rectangle(width/4, height/4, width - width/4*2, height - height/4*2);
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
    public void setHole(Hole hole) {
        x = hole.getSpawnX() - width / 2;
        y = hole.getSpawnY() - height / 2;
        this.hole = hole;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
