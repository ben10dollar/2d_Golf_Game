package dev.ben10dollar.golfgame.graphics;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.entities.Entity;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;

public class Camera {

    Handler handler;
    double offsetX, offsetY;
    double cameraWidth, cameraHeight;
    Hole hole; 

    public Camera(Handler handler, double offsetX, double offsetY) {
        this.handler = handler;
        this.offsetX = offsetX;
        this.offsetY = offsetY;

        cameraWidth = handler.getWidth();
        cameraHeight = handler.getHeight();
    }

    public void centerOnEntity(Entity entity) {

        offsetX = (entity.getX() + entity.getBounds().getWidth()/2) - cameraWidth/2;
        offsetX = Math.min(hole.getWidth() * Tile.TILE_WIDTH - cameraWidth, offsetX); //right view barrier
        offsetX = Math.max(0, offsetX); //left view barrier

        offsetY = (entity.getY() + entity.getBounds().getHeight()/2) - cameraHeight/2;
        offsetY = Math.min(hole.getHeight() * Tile.TILE_HEIGHT - cameraHeight, offsetY); //bottom view barrier
        offsetY = Math.max(0, offsetY); //top view barrier
    }

    public void move(double xChange, double yChange) {
        offsetX += xChange;
        offsetY += yChange;
    }

    public double getOffsetX() {
        return offsetX;
    }
    public double getOffsetY() {
        return offsetY;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

}
