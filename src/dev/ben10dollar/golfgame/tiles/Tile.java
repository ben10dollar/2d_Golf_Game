package dev.ben10dollar.golfgame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    private static Tile[] tiles = new Tile[256];
    private static Tile grassTile = new GrassTile(0);
    private static Tile dirtTile = new DirtTile(1);
    private static Tile wallTile = new WallTile(4);

    protected BufferedImage texture;
    protected int id;

    protected double coefficientOfKineticFriction;

    public Tile(BufferedImage texture, double coefficientOfKineticFriction, int id) {
        this.texture = texture;
        this.coefficientOfKineticFriction = coefficientOfKineticFriction;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public int getId() {
        return id;
    }

    public static Tile getTile(int id) {
        return tiles[id];
    }

    public double getCoefficientOfKineticFriction() {
        return coefficientOfKineticFriction;
    }

}
