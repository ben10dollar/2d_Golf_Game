package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Handler;

public class GolfBall extends Ball {

    public GolfBall(Handler handler, Hole hole, double mass) {
        super(handler, hole, 32, 32, mass, Assets.golfBall);
    }

}
