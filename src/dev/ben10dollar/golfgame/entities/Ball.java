package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.states.GameState;
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

    protected double angle = Integer.MAX_VALUE;
    //in radians (from 0 to 2pi)
    protected double velocity = 0;


    public Ball(Game game, int ballSize, BufferedImage ballAsset, double positionX, double positionY, double mass, double radius) {
        super(game, positionX, positionY, mass);
        this.ballSize = ballSize;
        this.ballAsset = ballAsset;
        this.radius = radius;
        this.mass = mass;
    }

    //___PHYSICS___
    private void changePosition() {
        positionX += velocity * Math.sin(angle);
        positionY += velocity * Math.cos(angle);
    }
    private void changeVelocity() {
        coefficientOfFriction = (game.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getCoefficientOfKineticFriction());
        frictionalForce = mass * Physics.GRAVITY * coefficientOfFriction;
        // F_k = F_N * mu_k = m * g * mu_k

        velocity -= frictionalForce * (1 / game.getTargetFps());
    }

    @Override
    public void tick() {
        if(game.getMouseManager().isLeftPressed()) velocity = 10;

        if(velocity != 0) {
            changeVelocity();
            changePosition();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ballAsset, (int)(positionX - game.getCamera().getOffsetX()), (int)(positionY - game.getCamera().getOffsetY()), ballSize, ballSize, null);
        game.getCamera().centerOnEntity(this);
    }


    public void setAngle(double angle) {
        this.angle = angle;
    }
}
