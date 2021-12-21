package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.utils.Handler;

public class GolfBall extends Ball {

    public GolfBall(Handler handler, double x, double y, double mass) {
        super(handler, x, y, 32, 32, mass, Assets.golfBall);
    }

}
