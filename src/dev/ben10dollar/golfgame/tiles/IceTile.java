package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;

public class IceTile extends Tile {

    public IceTile(double coefficientOfKineticFriction, char id) {
        super(Assets.ice, coefficientOfKineticFriction, id);
    }

}
