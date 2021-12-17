package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.tiles.Tile;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class GameState extends State {

    private GolfBall golfBall;
    private Hole currentHole;

    public GameState(Handler handler) {
        super(handler);
        golfBall = new GolfBall(handler,100, 100, 10, 4);
        currentHole = new Hole(handler,"res/holes/Hole_2.txt");
    }

    @Override
    public void tick() {
        currentHole.tick();
        golfBall.tick();
    }

    @Override
    public void render(Graphics g) {
        currentHole.render(g);
        golfBall.render(g);
    }

    public Hole getCurrentHole() {
        return currentHole;
    }
    public Ball getGolfBall() {
        return golfBall;
    }

}
