package dev.ben10dollar.golfgame.utils;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.display.Display;
import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.graphics.Camera;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.input.KeyManager;
import dev.ben10dollar.golfgame.input.MouseManager;
import dev.ben10dollar.golfgame.states.GameState;
import dev.ben10dollar.golfgame.states.State;

public class Handler {

    private Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public Game getGame() { return game; }
    public Hole getHole() { return game.getGameState().getCurrentHole(); }
    public Ball getBall() { return game.getGameState().getBall(); }
    public int getWidth() { return game.getWidth(); }
    public int getHeight() { return game.getHeight(); }
    public Camera getCamera() { return game.getCamera(); }
    public KeyManager getKeyManager() { return game.getKeyManager(); }
    public MouseManager getMouseManager() { return game.getMouseManager(); }
    public int getTargetFPS() { return game.TARGET_FPS; }
    public State getCurrentState() {
        return game.getCurrentState();
    }

    public void setGame(Game game) { this.game = game; }
    public void setCurrentState(State state) { game.setCurrentState(state); }
//    public void setHole(Hole hole) { game.getGameState().setCurrentHole(hole); }
}
