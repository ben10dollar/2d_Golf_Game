package dev.ben10dollar.golfgame.tiles;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

import java.awt.image.BufferedImage;

public class SandTile extends Tile {

    public SandTile(int id) {
        super(Assets.sand, Physics.COEFFICIENT_OF_KINETIC_FRICTION_BASELINE * 10, id);
    }
}
