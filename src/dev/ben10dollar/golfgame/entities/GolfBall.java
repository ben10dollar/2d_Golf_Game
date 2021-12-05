package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;

import java.awt.*;

public class GolfBall extends Ball {

    public GolfBall(double positionX, double positionY, double mass, double radius) {
        super(positionX, positionY, mass, radius);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ball, (int)positionX, (int)positionY, null);
    }
}
