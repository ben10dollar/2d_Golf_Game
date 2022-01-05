package dev.ben10dollar.golfgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int gameTileWidth = 8, gameTileHeight = 8;
    public static BufferedImage grass, dirt, water, sand, wall, hole, lava, ice, bouncePad, golfBall, bowlingBall, arrow, log;
    public static final int uiTileWidth = 5*2*5+1, uiTileHeight = 9*2+1;
    public static BufferedImage[] golphersName, startButton, gameEnd, replayButton, background;
    public static BufferedImage gopher;

    public static void init() {
        SpriteSheet gameSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Game_Sprite_Sheet.png"));
        SpriteSheet uiSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/UI_Sprite_Sheet.png"));

        golphersName = new BufferedImage[2];
        startButton = new BufferedImage[2];
        gameEnd = new BufferedImage[2];
        replayButton = new BufferedImage[2];
        background = new BufferedImage[2];

        //Tiles
        //row 1
        grass = gameSpriteSheet.crop(0, 0, gameTileWidth, gameTileHeight);
        dirt = gameSpriteSheet.crop(gameTileWidth, 0, gameTileWidth, gameTileHeight);
        sand = gameSpriteSheet.crop(gameTileWidth * 2, 0, gameTileWidth, gameTileHeight);
        water = gameSpriteSheet.crop(gameTileWidth * 3, 0, gameTileWidth, gameTileHeight);
        wall = gameSpriteSheet.crop(gameTileWidth * 4, 0, gameTileWidth, gameTileHeight);
        hole = gameSpriteSheet.crop(gameTileWidth * 5, 0, gameTileWidth, gameTileHeight);
        lava = gameSpriteSheet.crop(gameTileWidth * 6, 0, gameTileWidth, gameTileHeight);
        ice = gameSpriteSheet.crop(gameTileWidth * 7, 0, gameTileWidth, gameTileHeight);
        bouncePad = gameSpriteSheet.crop(gameTileWidth * 7, gameTileHeight, gameTileWidth, gameTileHeight);

        //row 2
        golfBall = gameSpriteSheet.crop(0, gameTileHeight, gameTileWidth, gameTileHeight);
        bowlingBall = gameSpriteSheet.crop(gameTileWidth, gameTileHeight, gameTileWidth * 2, gameTileHeight * 2);

        //row 3
        arrow = gameSpriteSheet.crop(0, gameTileHeight * 3, gameTileWidth * 2, gameTileHeight);
        log = gameSpriteSheet.crop(0, gameTileHeight * 5, gameTileWidth * 3, gameTileHeight);



        //UI
        //row 1
        golphersName[0] = uiSpriteSheet.crop(1, 0, uiTileWidth, uiTileHeight-1);
        golphersName[1] = uiSpriteSheet.crop(1, 0, uiTileWidth, uiTileHeight-1);
        startButton[0] = uiSpriteSheet.crop(1, uiTileHeight, uiTileWidth, uiTileHeight);
        startButton[1] = uiSpriteSheet.crop(1, uiTileHeight, uiTileWidth, uiTileHeight);
        gameEnd[0] = uiSpriteSheet.crop(1, (uiTileHeight+1)*2-1, uiTileWidth, uiTileHeight);
        gameEnd[1] = uiSpriteSheet.crop(1, (uiTileHeight+1)*2-1, uiTileWidth, uiTileHeight);
        replayButton[0] = uiSpriteSheet.crop(1, (uiTileHeight+1)*3-1, uiTileWidth, uiTileHeight);
        replayButton[1] = uiSpriteSheet.crop(1, (uiTileHeight+1)*3-1, uiTileWidth, uiTileHeight);
        background[0] = ImageLoader.loadImage("/textures/Golf_Background.jpg");
        background[1] = ImageLoader.loadImage("/textures/Golf_Background.jpg");



        gopher = ImageLoader.loadImage("/textures/Gopher.png");
    }
}
