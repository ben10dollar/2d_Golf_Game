package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

import java.awt.image.BufferedImage;

public class SandTile extends Tile {

    public SandTile(double coefficientOfKineticFriction, char id) {
        super(Assets.sand, coefficientOfKineticFriction, id);
    }
}
