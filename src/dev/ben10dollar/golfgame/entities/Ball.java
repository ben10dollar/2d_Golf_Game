package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.physics.Physics;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Ball extends Entity {

    public static final double DEFAULT_SPEED = 10;

    protected double velocityX = DEFAULT_SPEED * 2;
    protected double velocityY = DEFAULT_SPEED;

    public Ball(Handler handler, double x, double y, int width, int height, double mass, BufferedImage skin) {
        super(handler, x, y, width, height, mass, skin);
    }

    @Override
    public void tick() {
        changePosition();
        changeVelocity();
        handler.getCamera().centerOnEntity(this);
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(skin, (int)(x - handler.getCamera().getOffsetX()), (int)(y - handler.getCamera().getOffsetY()), width, height, null);

        //draw ball target
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getCamera().getOffsetX()),
//                (int) (y + bounds.y - handler.getCamera().getOffsetY()),
//                bounds.width, bounds.height);
    }



    //___POSITION___
    private void changePosition(){
        changePositionX();
        changePositionY();
    }
    private void changePositionX(){
        if(deltaX() > 0){//Moving right
            int nextX = (int) (x + deltaX() + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            if(collisionWithTile(nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    collisionWithTile(nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                velocityX *= -1;
            }
            x += deltaX();
        }
        else if(deltaX() < 0){//Moving left
            int nextX = (int) (x + deltaX() + bounds.x) / Tile.TILE_WIDTH;

            if(collisionWithTile(nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    collisionWithTile(nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                velocityX *= -1;
            }
            x += deltaX();
        }
    }
    private void changePositionY(){
        if(deltaY() < 0){//Up
            int nextY = (int) (y + deltaY() + bounds.y) / Tile.TILE_HEIGHT;

            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, nextY) ||
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, nextY)) {
                velocityY *= -1;
            }
            y += deltaY();
        }
        else if(deltaY() > 0){//Down
            int nextY = (int) (y + deltaY() + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, nextY) ||
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, nextY)) {
                velocityY *= -1;
            }
            y += deltaY();
        }
    }



    //___VELOCITY___
    private void changeVelocity() {
        changeVelocityX();
        changeVelocityY();
    }
    private void changeVelocityX() {
        velocityX -= Physics.kineticFriction(deltaX(), deltaY(), handler.getHole().getTile((int)x, (int)y).getCoefficientOfKineticFriction(), mass)[0] / mass * (1 / (double)handler.getTargetFPS());
    }
    private void changeVelocityY() {
        velocityY -= Physics.kineticFriction(deltaX(), deltaY(), handler.getHole().getTile((int)x, (int)y).getCoefficientOfKineticFriction(), mass)[1] / mass * (1 / (double)handler.getTargetFPS());
    }


    protected boolean collisionWithTile(int x, int y){
        return handler.getHole().getTile(x, y).isSolid();
    }
    private double deltaX() {
        return velocityX * (1 / (double)handler.getTargetFPS());
    }
    private double deltaY() {
        return velocityY * (1 / (double)handler.getTargetFPS());
    }



    public double getVelocityX() {
        return velocityX;
    }
    public double getVelocityY() {
        return velocityY;
    }
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }
}
