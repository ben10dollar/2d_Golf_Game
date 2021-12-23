package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class WallTile extends Tile{

    public WallTile(double coefficientOfKineticFriction, int id) {
        super(Assets.wall, coefficientOfKineticFriction, id);
    }

}
