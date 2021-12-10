package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Utils;

import java.awt.*;

public class Hole {

    private Game game;
    private int width, height, spawnX, spawnY;
    private int[][] tiles;

    public Hole(Game game, String path) {
        this.game = game;
        loadHole(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
            }
        }
    }

    private void loadHole(String path) {

        String file = Utils.loadFileAsString(path);
        String[] holeData = file.split("\\s+");
        width = Utils.parseInt(holeData[0]);
        height = Utils.parseInt(holeData[1]);
        spawnX = Utils.parseInt(holeData[2]);
        spawnY = Utils.parseInt(holeData[3]);

        tiles = new int[height][width];
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = Utils.parseInt(holeData[(y * width + x) + 4]);
            }
        }

    }

    public Tile getTile(int x, int y) {
        Tile tile = Tile.getTile(tiles[y][x]);
        if(tile == null) return Tile.getTile(0);
        return tile;
    }

}
