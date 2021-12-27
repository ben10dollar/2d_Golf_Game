package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class WaterTile extends Tile{

    public WaterTile(double coefficientOfKineticFriction, char id) {
        super(Assets.water, coefficientOfKineticFriction, id);
    }

}
