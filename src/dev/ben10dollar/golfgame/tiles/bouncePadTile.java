package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class bouncePadTile extends Tile {

    public bouncePadTile(double coefficientOfKineticFriction, char id) {
        super(Assets.bouncePad, coefficientOfKineticFriction, id);
    }

}
