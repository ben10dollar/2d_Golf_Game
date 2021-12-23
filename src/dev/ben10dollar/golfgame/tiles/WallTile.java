package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class WallTile extends Tile{

    public WallTile(int id) {
        super(Assets.wall, Physics.COEFFICIENT_OF_KINETIC_FRICTION_BASELINE * 0, id);
    }

}
