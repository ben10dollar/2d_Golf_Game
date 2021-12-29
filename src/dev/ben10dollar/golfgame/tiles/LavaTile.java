package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class LavaTile extends Tile {

    public LavaTile(double coefficientOfKineticFriction, char id) {
        super(Assets.lava, coefficientOfKineticFriction, id);
    }
}
