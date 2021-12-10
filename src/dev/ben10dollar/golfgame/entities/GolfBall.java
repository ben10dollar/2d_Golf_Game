package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.graphics.Assets;

import java.awt.*;

public class GolfBall extends Ball {

    public GolfBall(Game game, double positionX, double positionY, double mass, double radius) {
        super(game, positionX, positionY, mass, radius);
    }

    double velocityX = 5;
    double velocityY = 10;

    @Override
    public void tick() {

        if(positionX > 64*9-16 || 0 > positionX) velocityX *= -1;
        if(positionY > 64*9-16 || 0 > positionY) velocityY *= -1;

        positionX += velocityX;
        positionY += velocityY;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.golfBall, (int)(positionX - game.getCamera().getOffsetX()), (int)(positionY - game.getCamera().getOffsetY()), null);
        game.getCamera().centerOnEntity(this);
    }
}
