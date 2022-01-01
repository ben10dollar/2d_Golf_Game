package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.utils.Physics;

public class BowlingBall extends Ball {

    public BowlingBall(Handler handler, Hole hole) {
        super(handler, hole, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Physics.BALL_MASS_BASELINE * 4, Assets.bowlingBall);
    }

}
