//package dev.ben10dollar.golfgame.entities;
//
//import dev.ben10dollar.golfgame.utils.Handler;
//import dev.ben10dollar.golfgame.Game;
//import dev.ben10dollar.golfgame.physics.Physics;
//import dev.ben10dollar.golfgame.tiles.Tile;
//import dev.ben10dollar.golfgame.utils.Handler;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public abstract class BallOld extends Entity {
//
//    protected double ballWidth, ballHeight;
//    protected BufferedImage ballAsset;
//    protected double radius;
//    protected double mass;
//
//    protected double coefficientOfFriction;
//    protected double frictionalForce;
//
//    protected double angle = 0;
//    //in radians (from 0 to 2pi)
//    protected double velocityX = 0;
//    protected double velocityY = 0;
//    double deltaX;
//    double deltaY;
//
//
//    public BallOld(Handler handler, double ballWidth, double ballHeight, BufferedImage ballAsset, double positionX, double positionY, int width, int height, double mass, double radius) {
//        super(handler, positionX, positionY, width, height, mass);
//        this.ballWidth = ballWidth * 64;
//        this.ballHeight = ballHeight * 64;
//        this.ballAsset = ballAsset;
//        this.positionX = positionX;
//        this.positionY = positionY;
//        this.mass = mass;
//        this.radius = radius;
//    }
//
//    //___PHYSICS___
//    private void changePosition() {
//        //exceeds horizontal boundary
//        if(handler.getGameState().getCurrentHole()
//                .getTile((int)((positionX + velocityX * (1.0 / (double)handler.getTargetFPS())) / Tile.TILE_WIDTH),
//                        (int)(positionY / Tile.TILE_HEIGHT)).getId() == 4) {
//            velocityX *= -1;
//            calculateAngle(velocityX, velocityY, velocityX < 0);
//        }
//        //exceeds vertical boundary
//        else if(handler.getGameState().getCurrentHole()
//                .getTile((int)(positionX / Tile.TILE_WIDTH),
//                        (int)((positionY + velocityY * (1.0 / (double)handler.getTargetFPS())) / Tile.TILE_HEIGHT)).getId() == 4) {
//            velocityY *= -1;
//            calculateAngle(velocityX, velocityY, velocityX > 0);
//        }
//        positionX += velocityX * (1.0 / (double)handler.getTargetFPS());
//        positionY += velocityY * (1.0 / (double)handler.getTargetFPS());
//    }
//    private void changeVelocity() {
//        double lastVelocityX = velocityX;
//        double lastVelocityY = velocityX;
//
//        coefficientOfFriction = handler.getGameState().getCurrentHole().getTile((int)(positionX / Tile.TILE_WIDTH), (int)(positionY / Tile.TILE_HEIGHT)).getCoefficientOfKineticFriction();
//        frictionalForce = mass * Physics.GRAVITY * coefficientOfFriction;
//        // F_k = F_N * mu_k = m * g * mu_k
//
//
//        if(!(lastVelocityX / velocityX <= 0)) velocityX -= frictionalForce / mass * (1.0 / (double)handler.getTargetFPS()) * Math.cos(angle);
//        if(!(lastVelocityY / velocityY <= 0)) velocityY -= frictionalForce / mass * (1.0 / (double)handler.getTargetFPS()) * Math.sin(angle);
//    }
//
//    int timer = 0;
//    @Override
//    public void tick() {
//        if(timer >= 3*handler.getGame().getTargetFps() && velocityX == 0 && velocityY == 0 && handler.getMouseManager().isLeftPressed()) {
//            deltaX = handler.getMouseManager().getMouseX() - (int)(handler.getGameState().getGolfBall().getPositionX());
//            deltaY = handler.getMouseManager().getMouseY() - (int)(handler.getGameState().getGolfBall().getPositionY());
//
//            angle = calculateAngle(deltaX, deltaY, handler.getMouseManager().getMouseX() > (int)(handler.getGameState().getGolfBall().getPositionX()));
//            velocityX = 10 * Math.cos(angle);
//            velocityY = 10 * Math.sin(angle);
//
//            timer = 0;
//        }
//        timer++;
//        if(velocityX != 0 || velocityY != 0) {
//            changeVelocity();
//            changePosition();
//        }
//
//        System.out.println("VelX : " + velocityX + "   " + "VelY : " + velocityY);
//    }
//
//    @Override
//    public void render(Graphics g) {
//        g.drawImage(ballAsset, (int)(positionX - handler.getCamera().getOffsetX()), (int)(positionY - handler.getCamera().getOffsetY()), (int)ballWidth, (int)ballHeight, null);
//        handler.getCamera().centerOnEntity(this);
//        // g.fillRect((int)positionX, (int)positionY, width, height);
//    }
//
//    private double calculateAngle(double deltaX, double deltaY, boolean directionRight) {
//        double angle = Math.atan(deltaY / deltaX);
//
//        //Q3 and Q2 handler.getMouseManager().getMouseX() <= (int)(handler.getGameState().getGolfBall().getPositionX())
//        if(!directionRight)
//            angle += Math.PI;
//
//        System.out.println("Angle: " + angle * 360 / (2*Math.PI));
//        return angle;
//    }
//
//}
