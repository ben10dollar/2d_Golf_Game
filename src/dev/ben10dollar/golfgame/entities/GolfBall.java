package dev.ben10dollar.golfgame.entities;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.holes.Player;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.utils.Physics;

public class GolfBall extends Ball {

    public GolfBall(Handler handler, Player player, Hole hole) {
        super(handler, player, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2, Physics.BALL_MASS_BASELINE, Assets.golfBall);
    }

}
