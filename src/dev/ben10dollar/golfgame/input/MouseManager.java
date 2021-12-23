package dev.ben10dollar.golfgame.input;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.states.GameState;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.math.*;

public class MouseManager implements MouseListener, MouseMotionListener {

    private Handler handler;
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;

    public MouseManager(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Coordinates: " + mouseX + ", " + mouseY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON2)
            rightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON2)
            rightPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
         mouseX = e.getX() + (int)handler.getCamera().getOffsetX();
         mouseY = e.getY() + (int)handler.getCamera().getOffsetX();
    }



    //___Getters___
    public boolean isLeftPressed() {
        return leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }
    public int getMouseX() {
        return mouseX;
    }
    public int getMouseY() {
        return mouseY;
    }

}
