package dev.ben10dollar.golfgame.utils;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.graphics.Camera;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.input.MouseManager;
import dev.ben10dollar.golfgame.states.GameState;

public class Handler {

    private Game game;
    private Hole hole;

    public Handler(Game game) {
        this.game = game;
    }

    public Game getGame() { return game; }
    public Hole getHole() { return hole; }
    public int getWidth() { return game.getWidth(); }
    public int getHeight() { return game.getHeight(); }
    public Camera getCamera() { return game.getCamera(); }
    public MouseManager getMouseManager() { return game.getMouseManager(); }
    public int getTargetFPS() { return game.TARGET_FPS; }

    public void setGame(Game game) { this.game = game; }
    public void setHole(Hole hole) { this.hole = hole; }
}
