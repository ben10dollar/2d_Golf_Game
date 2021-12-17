package dev.ben10dollar.golfgame.graphics;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.entities.Entity;

public class Camera {

    Game game;
    double offsetX, offsetY;

    public Camera(Game game, double offsetX, double offsetY) {
        this.game = game;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void centerOnEntity(Entity entity) {
        offsetX = entity.getPositionX() - game.getWidth()/2;;
        offsetY = entity.getPositionY() - game.getWidth()/2;;
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

}
