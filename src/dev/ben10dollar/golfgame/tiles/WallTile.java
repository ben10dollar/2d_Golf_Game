package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class WallTile extends Tile{

    public WallTile(double coefficientOfKineticFriction, char id) {
        super(Assets.wall, coefficientOfKineticFriction, id);
    }

}
