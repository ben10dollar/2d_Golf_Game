package dev.ben10dollar.golfgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int width = 4, height = 4;
    public static BufferedImage grass, dirt, water, sand, ball;

    public static void init() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite_Sheet.png"));

        grass = spriteSheet.crop(0, 0, width, height);
        dirt = spriteSheet.crop(width, 0, width, height);
        water = spriteSheet.crop(width * 2, 0, width, height);
        sand = spriteSheet.crop(width * 3, 0, width, height);
        ball = spriteSheet.crop(width, height, width * 2, height * 2);
    }

}
