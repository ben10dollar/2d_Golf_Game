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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameState extends State {

    private ArrayList<Player> players;
    private Course golfCourse;
    //    private Hole currentHole;
//    private Ball ball;
    private UITextButton totalScoreCounter, strokeCounter, holePar;
    private UITextButton momentum, kineticEnergy;

    public GameState(Handler handler) {
        super(handler);

        players = new ArrayList<Player>();
        players.add(new Player("Neil"));
        golfCourse = new Course(handler, players);
        //golfCourse.holeAdd(new Hole(handler, "res/holes/Hole_1.txt"));
        golfCourse.holeAdd(new Hole(handler, "res/holes/Hole_eric.txt"));



        //right side top
        totalScoreCounter = new UITextButton(handler.getWidth() * 16.0 / 20.0, handler.getHeight() * 1 / 20 * 1, 0, 0, "Total Score: 0", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(totalScoreCounter);
        strokeCounter = new UITextButton(handler.getWidth() * 16.5 / 20.0, handler.getHeight() * 1 / 20 * 3, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(strokeCounter);

        holePar = new UITextButton(handler.getWidth() * 16.5 / 20.0, handler.getHeight() * 1 / 20 * 5, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(holePar);



        //right side bottom
        momentum = new UITextButton(handler.getWidth() * 16.0 / 20.0, handler.getHeight() * 1 / 20 * 17, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
            @Override
            public void onClick() {
            }
        });
        uiManager.addObject(momentum);
        kineticEnergy = new UITextButton(handler.getWidth() * 16.0 / 20.0, handler.getHeight() * 1 / 20 * 19, 0, 0, "", true, Color.BLACK, Assets.font28, new ClickListener() {
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
                totalScoreCounter.setText("Total Score: " + String.valueOf(player.getTotalScore()));
            }
        }
        else {
            if(handler.getGame().getEndState() == null) handler.getGame().setEndState(new EndState(handler));
            handler.getGame().setCurrentState(handler.getGame().getEndState());
        }
    }

    @Override
    public void render(Graphics g) {
        golfCourse.render(g);
        uiManager.render(g);
    }


    public UIManager getUIManager() {
        return uiManager;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
