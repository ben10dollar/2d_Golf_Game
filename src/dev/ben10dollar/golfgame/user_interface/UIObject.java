package dev.ben10dollar.golfgame.user_interface;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected double x, y;
    protected int width, height;
    protected boolean hovering;
    protected Rectangle bounds;

    public UIObject(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int)(x - width/2), (int)(y - height/2), width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick();
    public void onMouseMove(MouseEvent e) {
        if(bounds.contains(e.getX(), e.getY()))
            hovering = true;
        else
            hovering = false;
    }
    public void onMouseRelease(MouseEvent e) {
        if(hovering) onClick();
    }
}
