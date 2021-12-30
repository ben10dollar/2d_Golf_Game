package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class SandTile extends Tile {

    public SandTile(double coefficientOfKineticFriction, char id) {
        super(Assets.sand, coefficientOfKineticFriction, id);
    }
}
