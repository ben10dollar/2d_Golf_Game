package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.entities.BowlingBall;
import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class GameState extends State {

    private Queue<Hole> holesInCourse;
    private Hole currentHole;
    private Ball ball;
    private boolean courseDone;

    public GameState(Handler handler) {
        super(handler);

        holesInCourse = new LinkedList<Hole>();
        //addHoleToCourse(new Hole(handler,"res/holes/Hole_1.txt"));
        //addHoleToCourse(new Hole(handler,"res/holes/Hole_2.txt"));
        addHoleToCourse(new Hole(handler,"res/holes/Hole_3.txt"));
        //addHoleToCourse(new Hole(handler,"res/holes/Hole_4.txt"));

        currentHole = holesInCourse.remove();
        ball = new GolfBall(handler, currentHole,10);
        //ball = new BowlingBall(handler, currentHole,40);
    }

    @Override
    public void tick() {
        currentHole.tick();
        if(!currentHole.getHoleComplete()) ball.tick();
        else if(holesInCourse.size() != 0) {
            currentHole = holesInCourse.remove();
            ball = new GolfBall(handler, currentHole,10);
            //ball = new BowlingBall(handler, currentHole, 40);
        }
        else courseDone = true;
    }
    @Override
    public void render(Graphics g) {
        currentHole.render(g);
        if(!courseDone) ball.render(g);
    }

    public Hole getCurrentHole() {
        return currentHole;
    }
    public Ball getBall() {
        return ball;
    }
    private void addHoleToCourse(Hole hole) {
        holesInCourse.add(hole);
    }
}
