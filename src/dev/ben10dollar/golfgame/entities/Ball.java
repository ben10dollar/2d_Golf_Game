package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Physics;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.utils.Utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public abstract class Ball extends Entity {

    public static final double INITIAL_SPEED = 10;

    protected double velocityX;
    protected double velocityY;
    protected int score;
    protected boolean visible;

    public Ball(Handler handler, Hole hole, int width, int height, double mass, BufferedImage skin) {
        super(handler, hole, width, height, mass, skin);

        velocityX = INITIAL_SPEED * 0;
        velocityY = INITIAL_SPEED * 0;

        score = -hole.getPar();
        visible = true;
    }

    @Override
    public void tick() {
        if (handler.getHole().holeComplete()){
            visible = false;
        }
        if(velocityX == 0 && velocityY == 0 && handler.getMouseManager().isLeftPressed()) {
            velocityX = (handler.getMouseManager().getMouseX() - (x + width / 2 - handler.getCamera().getOffsetX())) / Tile.TILE_WIDTH * Physics.FORCE_X_PER_TILE_FROM_BALL / mass;
            velocityY = (handler.getMouseManager().getMouseY() - (y + height / 2 - handler.getCamera().getOffsetY())) / Tile.TILE_HEIGHT * Physics.FORCE_Y_PER_TILE_FROM_BALL / mass;

            lastX = x;
            lastY = y;

            score++;
        }
        changePosition();
        changeVelocity();
//        System.out.println("VelocityY: " + velocityY);
//        System.out.println("Velocity: " + Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2)));

        handler.getCamera().centerOnEntity(this);
    }
    @Override
    public void render(Graphics g) {
        //draw ball
        if(visible) {
            g.drawImage(skin, (int) (x - handler.getCamera().getOffsetX()), (int) (y - handler.getCamera().getOffsetY()), width, height, null);
        }
        //draw arrow
        if(velocityX == 0 && velocityY == 0) {
            double angle = Physics.angle(handler.getMouseManager().getMouseX() - (x + width / 2 - handler.getCamera().getOffsetX()),
                    handler.getMouseManager().getMouseY() - (y + height / 2 - handler.getCamera().getOffsetY()),
                    handler.getMouseManager().getMouseX() - (x + width / 2 - handler.getCamera().getOffsetX()) < 0);
            double scaleX = Math.abs((handler.getMouseManager().getMouseX() - (x + width / 2 - handler.getCamera().getOffsetX()) ) / Tile.TILE_WIDTH * 2);
            double scaleY = Math.abs((handler.getMouseManager().getMouseY() - (y + height / 2 - handler.getCamera().getOffsetY())) / Tile.TILE_HEIGHT * 2);
            double scale = Math.sqrt(Math.pow(scaleX, 2) + Math.pow(scaleY, 2));

            Utils.drawRotatedImage(angle, (int)(x + width / 2 - handler.getCamera().getOffsetX()), (int)(y + height / 2 - handler.getCamera().getOffsetY()), 0, 3, scale, scale, Assets.arrow, g);

            int gopherSizeInTiles = 3;
            BufferedImage gopher = Assets.gopher;
            if(angle > Math.PI/2) {
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-gopher.getWidth(), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                gopher = op.filter(gopher, null);
            }
            g.drawImage(gopher, (int)(x + width/2 - handler.getCamera().getOffsetX() + 60*Math.cos(angle + Math.PI) - width/2*gopherSizeInTiles), (int)(y + height/2 - handler.getCamera().getOffsetY() + 60*Math.sin(angle + Math.PI) - height/2*gopherSizeInTiles), width*gopherSizeInTiles, height*gopherSizeInTiles, null);
        }

    }



    //one tile = acceleration of 10 m/s^2
    //___POSITION___
    private void changePosition() {
        changePositionX();
        changePositionY();
    }
    private void changePositionX() {

        //keyboard input
//        if(handler.getKeyManager().right) velocityX += 5;
//        if(handler.getKeyManager().left) velocityX -= 5;

        //collision detection
        double nextX = x / Tile.TILE_WIDTH;
        if(deltaX() > 0) nextX += (deltaX() + bounds.x + bounds.width) / Tile.TILE_WIDTH;
        else if(deltaX() < 0) nextX += (deltaX() + bounds.x) / Tile.TILE_WIDTH;


        if(collisionWithWall((int)nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                collisionWithWall((int)nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
            velocityX *= -1;
            velocityX *= 2.0/3.0;
            x += deltaX();
        }
        else if(collisionWithBouncePad((int)nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                collisionWithBouncePad((int)nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
            velocityX *= -1;
            velocityX *= 2;
            x += deltaX();
        }
        else if(landedInWater((int)nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                landedInWater((int)nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
            x = lastX;
            y = lastY;
            velocityX = 0;
            velocityY = 0;
            score++;
        }
        else if(landedInLava((int)nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                landedInLava((int)nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
            x = lastX;
            y = lastY;
            velocityX = 0;
            velocityY = 0;
            score += 2;
        }
        else if(landedInHole((int)nextX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                landedInHole((int)nextX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
            handler.getHole().setHoleComplete(true);
            return;
        }
        else x += deltaX();
    }
    private void changePositionY() {

        //keyboard input
//        if(handler.getKeyManager().down) velocityY += 5;
//        if(handler.getKeyManager().up) velocityY -= 5;

        //collision detection
        double nextY = y / Tile.TILE_WIDTH;
        if(deltaY() > 0) nextY += (deltaY() + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
        else if(deltaY() < 0) nextY += (deltaY() + bounds.y) / Tile.TILE_HEIGHT;

        if(collisionWithWall((int)(x + bounds.x) / Tile.TILE_WIDTH, (int)nextY) ||
                collisionWithWall((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, (int)nextY)) {
            velocityY *= -1;
            velocityY *= 2.0/3.0;
            y += deltaY();
        }
        else if(collisionWithBouncePad((int)(x + bounds.x) / Tile.TILE_WIDTH, (int)nextY) ||
                collisionWithBouncePad((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, (int)nextY)) {
            velocityY *= -1;
            velocityY *= 2;
            y += deltaY();
        }
        else if(landedInWater((int)(x + bounds.x) / Tile.TILE_WIDTH, (int)nextY) ||
                landedInWater((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, (int)nextY)) {
            x = lastX;
            y = lastY;
            velocityX = 0;
            velocityY = 0;
            score++;
        }
        else if(landedInLava((int)(x + bounds.x) / Tile.TILE_WIDTH, (int)nextY) ||
                landedInLava((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, (int)nextY)) {
            x = lastX;
            y = lastY;
            velocityX = 0;
            velocityY = 0;
            score += 2;
        }
        else if(landedInHole((int)(x + bounds.x) / Tile.TILE_WIDTH, (int)nextY) ||
                landedInHole((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, (int)nextY)) {
            handler.getHole().setHoleComplete(true);
            return;
        }
        else y += deltaY();
    }



    //___VELOCITY___
    private void changeVelocity() {
        changeVelocityX();
        changeVelocityY();
    }
    private void changeVelocityX() {
        if(velocityX == 0) return; //friction doesn't act on stationary objects
        double deltaVelocityX = Physics.kineticFriction(deltaX(), deltaY(), handler.getHole().getTile((int)x / Tile.TILE_WIDTH, (int)y / Tile.TILE_HEIGHT).getCoefficientOfKineticFriction(), mass)[0] / mass * (1 / (double)handler.getTargetFPS());
        if((velocityX + deltaVelocityX) / velocityX < 0) velocityX = 0; //check if velocity is about to change signs. If it is, set velocity to 0 instead
        else velocityX += deltaVelocityX;
    }
    private void changeVelocityY() {
        if(velocityY == 0) return; //friction doesn't act on stationary objects
        double deltaVelocityY = Physics.kineticFriction(deltaX(), deltaY(), handler.getHole().getTile(((int)x / Tile.TILE_WIDTH), (int)y / Tile.TILE_HEIGHT).getCoefficientOfKineticFriction(), mass)[1] / mass * (1 / (double)handler.getTargetFPS());
        if((velocityY + deltaVelocityY) / velocityY < 0) velocityY = 0; //check if velocity is about to change signs. If it is, set velocity to 0 instead
        else velocityY += deltaVelocityY;
    }



    //___HELPER METHODS___
    protected boolean collisionWithWall(int tileX, int tileY) {
        return handler.getHole().getTile(tileX, tileY).isWall();
    }
    protected boolean collisionWithBouncePad(int tileX, int tileY) {
        return handler.getHole().getTile(tileX, tileY).isBouncePad();
    }
    protected boolean landedInHole(int tileX, int tileY) {
//        double totalVelocity = Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
//        if (handler.getHole().getTile(tileX, tileY).isHole() && totalVelocity < 100.0)
        return handler.getHole().getTile(tileX, tileY).isHole();
    }
    protected boolean landedInWater(int tileX, int tileY) {
        return handler.getHole().getTile(tileX, tileY).isWater();
    }
    protected boolean landedInLava(int tileX, int tileY) {
        return handler.getHole().getTile(tileX, tileY).isLava();
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
    public int getScore() {
        return score;
    }
    public void setVisible(boolean visible){this.visible = visible;}


    //___OLD CODE___
}
