package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class HoleTile extends Tile {

    public HoleTile(double coefficientOfKineticFriction, int id) {
        super(Assets.hole, coefficientOfKineticFriction, id);
    }

}
