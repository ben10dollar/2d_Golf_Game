package dev.ben10dollar.golfgame;

import dev.ben10dollar.golfgame.display.Display;
import dev.ben10dollar.golfgame.tiles.Tile;

public class Launcher {

    public static void main(String[] args) {
        //actually starts up (launches) the game
        Game game = new Game("Golf Game", Tile.TILE_WIDTH * 8, Tile.TILE_HEIGHT * 8);
        game.start();
    }

}
