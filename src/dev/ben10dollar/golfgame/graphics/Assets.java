package dev.ben10dollar.golfgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int width = 8, height = 8;
    public static BufferedImage grass, dirt, water, sand, wall, hole, lava, ice, bouncePad, golfBall, bowlingBall, arrow;

    public static void init() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite_Sheet.png"));

        //row 1
        grass = spriteSheet.crop(0, 0, width, height);
        dirt = spriteSheet.crop(width, 0, width, height);
        sand = spriteSheet.crop(width * 2, 0, width, height);
        water = spriteSheet.crop(width * 3, 0, width, height);
        wall = spriteSheet.crop(width * 4, 0, width, height);
        hole = spriteSheet.crop(width * 5, 0, width, height);
        lava = spriteSheet.crop(width * 6, 0, width, height);
        ice = spriteSheet.crop(width * 7, 0, width, height);
        bouncePad = spriteSheet.crop(width * 7, height, width, height);

        //row 2
        golfBall = spriteSheet.crop(0, height, width, height);
        bowlingBall = spriteSheet.crop(width, height, width * 2, height * 2);

        //row 3
        arrow = spriteSheet.crop(0, height * 3, width * 2, height - 1);
    }

}
