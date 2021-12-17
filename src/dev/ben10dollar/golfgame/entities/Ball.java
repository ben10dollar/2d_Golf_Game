package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.physics.Physics;
import dev.ben10dollar.golfgame.tiles.Tile;

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


    public Ball(Game game, int ballSize, BufferedImage ballAsset, double positionX, double positionY, double mass, double radius) {
        super(game, positionX, positionY, mass);
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
        if(game.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getId() == 4){
            angle = calculateAngle(deltaX*-1, deltaY);
        }

        coefficientOfFriction = game.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getCoefficientOfKineticFriction();
        frictionalForce = mass * Physics.GRAVITY * coefficientOfFriction;
        // F_k = F_N * mu_k = m * g * mu_k

        velocity -= frictionalForce / mass * (1.0 / (double)game.getTargetFps());
    }

    @Override
    public void tick() {
        if(game.getMouseManager().isLeftPressed()) {
            deltaX = game.getMouseManager().getMouseX() - (int)(game.getGameState().getGolfBall().getPositionX());
            deltaY = game.getMouseManager().getMouseY() - (int)(game.getGameState().getGolfBall().getPositionY());

            angle = calculateAngle(deltaX, deltaY);
            velocity = 10;
        }

        if(velocity != 0) {
            changeVelocity();
            changePosition();
        }

        System.out.println(velocity);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ballAsset, (int)(positionX - game.getCamera().getOffsetX()), (int)(positionY - game.getCamera().getOffsetY()), ballSize, ballSize, null);
        game.getCamera().centerOnEntity(this);
    }

    private double calculateAngle(double deltaX, double deltaY) {
        double angle = Math.atan(deltaY / deltaX);
        if(game.getMouseManager().getMouseY() <= (int)(game.getGameState().getGolfBall().getPositionY())) {
            //Quarter 4
            if(game.getMouseManager().getMouseX() >= (int)(game.getGameState().getGolfBall().getPositionX()))
                angle += 2*Math.PI;
                //Quarter 3
            else angle += Math.PI;

        }
        //Quarter 2
        else if(game.getMouseManager().getMouseX() < (int)(game.getGameState().getGolfBall().getPositionX()))
            angle += Math.PI;

        System.out.println(angle * 360 / (2*Math.PI));
        return angle;
    }

}
