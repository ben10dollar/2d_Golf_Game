package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;

import java.awt.*;

public class GolfBall extends Ball {

    public GolfBall(double positionX, double positionY, double mass, double radius) {
        super(positionX, positionY, mass, radius);
    }

    double velocityX = 5;
    double velocityY = 10;

    @Override
    public void tick() {

        if(positionX > 800-16 || 0 > positionX) velocityX *= -1;
        if(positionY > 800-16 || 0 > positionY) velocityY *= -1;

        positionX += velocityX;
        positionY += velocityY;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ball, (int)positionX, (int)positionY, null);
    }
}
