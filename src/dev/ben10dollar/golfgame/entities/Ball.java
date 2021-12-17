package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.physics.Physics;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Ball extends Entity {

    protected int ballSize;
    protected BufferedImage ballAsset;
    protected double radius;
    protected double mass;

    protected double coefficientOfFriction;
    protected double frictionalForce;

    protected double angle = 0;
    //in radians (from 0 to 2pi)
    protected double velocity = 0;
    double deltaX;
    double deltaY;


    public Ball(Handler handler, int ballSize, BufferedImage ballAsset, double positionX, double positionY, double mass, double radius) {
        super(handler, positionX, positionY, mass);
        this.ballSize = ballSize;
        this.ballAsset = ballAsset;
        this.positionX = positionX;
        this.positionY = positionY;
        this.mass = mass;
        this.radius = radius;

    }

    //___PHYSICS___
    private void changePosition() {
        positionX += velocity * Math.sin(angle);
        positionY += velocity * Math.cos(angle);
    }
    private void changeVelocity() {
        if(handler.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getId() == 4){
            angle = calculateAngle(deltaX, deltaY*-1);
        }

        coefficientOfFriction = handler.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getCoefficientOfKineticFriction();
        frictionalForce = mass * Physics.GRAVITY * coefficientOfFriction;
        // F_k = F_N * mu_k = m * g * mu_k

        velocity -= frictionalForce / mass * (1.0 / (double)handler.getTargetFPS());
    }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed()) {
            deltaX = handler.getMouseManager().getMouseX() - (int)(handler.getGameState().getGolfBall().getPositionX());
            deltaY = handler.getMouseManager().getMouseY() - (int)(handler.getGameState().getGolfBall().getPositionY());

            angle = calculateAngle(deltaX, deltaY);
            velocity = 10;
        }

        if(velocity > 0) {
            changeVelocity();
            changePosition();
        }

        System.out.println(velocity);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ballAsset, (int)(positionX - handler.getCamera().getOffsetX()), (int)(positionY - handler.getCamera().getOffsetY()), ballSize, ballSize, null);
        handler.getCamera().centerOnEntity(this);
    }

    private double calculateAngle(double deltaX, double deltaY) {
        double angle = Math.atan(deltaY / deltaX);

        //Q3 and Q2
        if(handler.getMouseManager().getMouseX() <= (int)(handler.getGameState().getGolfBall().getPositionX()))
            angle += Math.PI;

        System.out.println(angle * 360 / (2*Math.PI));
        return angle;
    }

}
