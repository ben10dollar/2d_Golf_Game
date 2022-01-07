package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.holes.Course;
import dev.ben10dollar.golfgame.holes.Hole;
import dev.ben10dollar.golfgame.holes.Player;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIManager;
import dev.ben10dollar.golfgame.user_interface.UITextButton;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    private ArrayList<Player> players;
    private Course golfCourse;
    //    private Hole currentHole;
//    private Ball ball;
    private UITextButton totalScoreCounter, strokeCounter, momentum, kineticEnergy;

    public GameState(Handler handler) {
        super(handler);

        players = new ArrayList<Player>();
        players.add(new Player("Neil"));
        golfCourse = new Course(handler, players);
        golfCourse.holeAdd(new Hole(handler, "res/holes/Hole_1.txt"));
        golfCourse.holeAdd(new Hole(handler, "res/holes/Hole_2.txt"));


        totalScoreCounter = new UITextButton(handler.getWidth() * 17.5 / 20, handler.getHeight() * 1 / 20 * 1, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(totalScoreCounter);
        strokeCounter = new UITextButton(handler.getWidth() * 16.5 / 20, handler.getHeight() * 1 / 20 * 3, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(strokeCounter);
        momentum = new UITextButton(handler.getWidth() * 16.5 / 20, handler.getHeight() * 1 / 20 * 5, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(momentum);
        kineticEnergy = new UITextButton(handler.getWidth() * 16.5 / 20, handler.getHeight() * 1 / 20 * 7, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(kineticEnergy);
    }

    @Override
    public void tick() {

        if(!golfCourse.isCourseComplete()) {
            golfCourse.tick();
            for(Player player:players) {
                strokeCounter.setText("Total Score: " + String.valueOf(player.getTotalScore()));
            }
        }
        else handler.setCurrentState(handler.getGame().getEndState());
    }

    @Override
    public void render(Graphics g) {
        golfCourse.render(g);
        uiManager.render(g);
    }


    public UIManager getUIManager() {
        return uiManager;
    }
}
