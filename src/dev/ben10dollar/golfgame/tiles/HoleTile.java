package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class HoleTile extends Tile {

    public HoleTile(int id) {
        super(Assets.hole, Physics.COEFFICIENT_OF_KINETIC_FRICTION_BASELINE * 0, id);
    }

}
