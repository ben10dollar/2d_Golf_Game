package dev.ben10dollar.golfgame.graphics;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {

    private BufferedImage sheetImg;

    public SpriteSheet(BufferedImage sheetImg) {
        this.sheetImg = sheetImg;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return sheetImg.getSubimage(x, y, width, height);
    }

}
