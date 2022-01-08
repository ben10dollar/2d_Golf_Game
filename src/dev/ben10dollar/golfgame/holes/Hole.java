package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.entities.Entity;
import dev.ben10dollar.golfgame.graphics.Camera;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.user_interface.UITextButton;
import dev.ben10dollar.golfgame.utils.Handler;
import dev.ben10dollar.golfgame.utils.Utils;

import java.awt.*;
import java.util.ArrayList;

public class Hole {

    private Handler handler;
    private int width;
    private int height;

    private int spawnX;
    private int spawnY;
    private int par;
    private char[][] tiles;

    private ArrayList<Entity> entities;
    private Camera camera;

    public Hole(Handler handler, String path) {
        this.handler = handler;
        entities = new ArrayList<Entity>();
        loadHole(path);
    }

    public void tick() {
        for(Entity entity:entities) {
            entity.tick();
        }
        ((UITextButton)handler.getCurrentState().getUiManager().getObject(2)).setText("Par: " + String.valueOf(par));
    }
    public void render(Graphics g) {
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH - (int)handler.getCamera().getOffsetX(), y * Tile.TILE_HEIGHT - (int)handler.getCamera().getOffsetY());
            }
        }
        for(Entity entity:entities) {
            entity.render(g);
        }
    }


    private void loadHole(String path) {

        String file = Utils.loadFileAsString(path);
        String[] holeData = file.split("\\s+");
        width = Utils.parseInt(holeData[0]);
        height = Utils.parseInt(holeData[1]);
        spawnX = Utils.parseInt(holeData[2]) * Tile.TILE_WIDTH + Tile.TILE_WIDTH/2;
        spawnY = Utils.parseInt(holeData[3]) * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT/2;
        par = Utils.parseInt(holeData[4]);;

        tiles = new char[height][width];
        for(int y=0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = holeData[(y * width + x) + 5].charAt(0);
            }
        }
    }
    public Tile getTile(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) return Tile.getTile('d');
        Tile tile = Tile.getTile(tiles[y][x]);
        if(tile == null) return Tile.getTile('d');
        return tile;
    }
    public void addEntity(Entity entity) {
        entity.setHole(this);
        entities.add(entity);
    }
    public boolean holeComplete() {
        for(Entity entity:entities) {
            if(entity instanceof Ball) {
                if(!((Ball)entity).isBallInHole())
                    return false;
            }
        }
        return true;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getSpawnX() {
        return spawnX;
    }
    public int getSpawnY() {
        return spawnY;
    }
    public int getPar() {
        return par;
    }
}
