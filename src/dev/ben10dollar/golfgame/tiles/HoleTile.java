package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class HoleTile extends Tile {

    public HoleTile(double coefficientOfKineticFriction, char id) {
        super(Assets.hole, coefficientOfKineticFriction, id);
    }

}
