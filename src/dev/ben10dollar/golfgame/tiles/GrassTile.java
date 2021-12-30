package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class GrassTile extends Tile {

    public GrassTile(double coefficientOfKineticFriction, char id) {
        super(Assets.grass, coefficientOfKineticFriction, id);
    }

}
