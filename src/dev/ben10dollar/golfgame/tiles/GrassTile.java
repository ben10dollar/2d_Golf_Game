package dev.ben10dollar.golfgame.tiles;

import java.awt.image.BufferedImage;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

public class GrassTile extends Tile {

    public GrassTile(double coefficientOfKineticFriction, int id) {
        super(Assets.grass, coefficientOfKineticFriction, id);
    }

}
