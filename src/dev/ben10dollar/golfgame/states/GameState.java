package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.entities.Ball;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIImageButton;
import dev.ben10dollar.golfgame.utils.Handler;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class GameState extends State {

    private Queue<Hole> holesInCourse;
    private Hole currentHole;
    private Ball ball;
    private int totalScore;

    JButton button;

    public GameState(Handler handler) {
        super(handler);

        holesInCourse = new LinkedList<Hole>();
        addHoleToCourse(new Hole(handler,"res/holes/Hole_1.txt"));
        addHoleToCourse(new Hole(handler,"res/holes/Hole_2.txt"));
//        addHoleToCourse(new Hole(handler,"res/holes/Hole_3.txt"));
//        addHoleToCourse(new Hole(handler,"res/holes/Hole_4.txt"));

        currentHole = holesInCourse.remove();
        ball = new GolfBall(handler, currentHole);
        //ball = new BowlingBall(handler, currentHole,40);

        button = new JButton("Button");
        button.setBounds(50,100,95,30);
        handler.getGame().getDisplay().getFrame().add(button);

    }

    @Override
    public void tick() {
        currentHole.tick();
        if(!currentHole.holeComplete()) ball.tick();
        else if(holesInCourse.size() != 0) {
            totalScore += ball.getScore();
            System.out.println(totalScore);
            currentHole = holesInCourse.remove();
            ball = new GolfBall(handler, currentHole);
            //ball = new BowlingBall(handler, currentHole, 40);
        }
        else handler.setCurrentState(handler.getGame().getEndState());
    }
    @Override
    public void render(Graphics g) {
        currentHole.render(g);
        ball.render(g);
        handler.getGame().getDisplay().getFrame().add(button);

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
