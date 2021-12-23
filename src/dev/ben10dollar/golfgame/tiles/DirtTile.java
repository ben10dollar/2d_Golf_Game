package dev.ben10dollar.golfgame.tiles;

import java.awt.image.BufferedImage;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class DirtTile extends Tile {

    public DirtTile(int id) {
        super(Assets.dirt, Physics.COEFFICIENT_OF_KINETIC_FRICTION_BASELINE * 2, id);
    }
}
