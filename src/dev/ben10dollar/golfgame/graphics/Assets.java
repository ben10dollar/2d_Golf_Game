package dev.ben10dollar.golfgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int width = 8, height = 8;
    public static BufferedImage grass, dirt, water, sand, x;

    public static void init() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("res/textures/Sprite_Sheet.png"));

        grass = spriteSheet.crop(0, 0, width, height);
        dirt = spriteSheet.crop(width, 0, width, height);
        water = spriteSheet.crop(width * 2, 0, width, height);
        sand = spriteSheet.crop(width * 3, 0, width, height);
        x = spriteSheet.crop(0, height, width, height);
    }

}
