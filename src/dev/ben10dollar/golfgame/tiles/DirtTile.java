package dev.ben10dollar.golfgame.tiles;

import java.awt.image.BufferedImage;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class DirtTile extends Tile {

    public DirtTile(double coefficientOfKineticFriction, int id) {
        super(Assets.dirt, coefficientOfKineticFriction, id);
    }
}
