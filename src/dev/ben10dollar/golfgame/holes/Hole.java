package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.utils.Utils;

import java.awt.*;

public class Hole {

    private Handler handler;
    private int width;
    private int height;

    private int spawnX;
    private int spawnY;
    private char[][] tiles;
    private boolean holeComplete;

    public Hole(Handler handler, String path) {
        this.handler = handler;
        loadHole(path);
    }

    public void tick() {
    }
    public void render(Graphics g) {
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH - (int)handler.getCamera().getOffsetX(), y * Tile.TILE_HEIGHT - (int)handler.getCamera().getOffsetY());
            }
        }
    }


    private void loadHole(String path) {

        String file = Utils.loadFileAsString(path);
        String[] holeData = file.split("\\s+");
        width = Utils.parseInt(holeData[0]);
        height = Utils.parseInt(holeData[1]);
        spawnX = Utils.parseInt(holeData[2]) * Tile.TILE_WIDTH + Tile.TILE_WIDTH/2;
        spawnY = Utils.parseInt(holeData[3]) * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT/2;

        tiles = new char[height][width];
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = holeData[(y * width + x) + 4].charAt(0);
                System.out.println(tiles[y][x]);
            }
        }

    }
    public Tile getTile(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) return Tile.getTile('d');
        Tile tile = Tile.getTile(tiles[y][x]);
        if(tile == null) return Tile.getTile('d');
        return tile;
    }


    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public boolean getHoleComplete() {
        return holeComplete;
    }
    public void setHoleComplete(boolean holeComplete) {
        this.holeComplete = holeComplete;
    }
    public int getSpawnX() {
        return spawnX;
    }
    public int getSpawnY() {
        return spawnY;
    }
}
