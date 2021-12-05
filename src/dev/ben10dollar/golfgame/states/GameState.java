package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.graphics.Assets;

import java.awt.*;

public class GameState extends State {

    private GolfBall golfBall;

    public GameState() {
        golfBall = new GolfBall(100, 100, 10, 10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
//        g.drawRect(10, 50 ,50, 70);
//        g.drawImage(Assets.grass, 100, 100, 100, 100, null);
        golfBall.render(g);
    }
}
