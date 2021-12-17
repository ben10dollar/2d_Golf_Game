package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GolfBall extends Ball {

    public GolfBall(Handler handler, double positionX, double positionY, double mass, double radius) {
        super(handler, 8*4, Assets.golfBall, positionX, positionY, mass, radius);
    }

}
