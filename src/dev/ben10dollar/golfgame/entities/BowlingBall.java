package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Handler;

public class BowlingBall extends Ball {

    public BowlingBall(Handler handler, Hole hole, double mass) {
        super(handler, hole, 64, 64, mass, Assets.bowlingBall);
    }

}
