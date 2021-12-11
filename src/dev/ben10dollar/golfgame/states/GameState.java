package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private GolfBall golfBall;
    private Hole currentHole;

    public GameState(Game game) {
        super(game);
        golfBall = new GolfBall(game,100, 100, 10, 4);
        currentHole = new Hole(game,"res/holes/Hole_2.txt");
    }

    @Override
    public void tick() {
        currentHole.tick();
        golfBall.tick();
    }

    @Override
    public void render(Graphics g) {
//        g.drawRect(10, 50 ,50, 70);
//        g.drawImage(Assets.grass, 100, 100, 100, 100, null);
        currentHole.render(g);
        golfBall.render(g);
//        Tile.getTile(0).render(g, 100, 100);
    }

    public Hole getCurrentHole() {
        return currentHole;
    }

}
