package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class DirtTile extends Tile {

    public DirtTile(double coefficientOfKineticFriction, char id) {
        super(Assets.dirt, coefficientOfKineticFriction, id);
    }
}
