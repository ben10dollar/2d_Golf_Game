package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class GameState extends State {

    private GolfBall golfBall;
    private Hole currentHole;

    public GameState(Handler handler) {
        super(handler);
        golfBall = new GolfBall(handler,100, 100, 10);
        currentHole = new Hole(handler,"res/holes/Hole_1.txt");
        handler.setHole(currentHole);
    }

    @Override
    public void tick() {
        currentHole.tick();
        if(!golfBall.getBallReachedHole()) golfBall.tick();
    }
    @Override
    public void render(Graphics g) {
        currentHole.render(g);
        if(!golfBall.getBallReachedHole()) golfBall.render(g);
    }

    public Hole getCurrentHole() {
        return currentHole;
    }
    public GolfBall getGolfBall() {
        return golfBall;
    }
}
