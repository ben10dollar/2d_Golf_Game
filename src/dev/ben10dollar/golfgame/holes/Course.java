package dev.ben10dollar.golfgame.holes;

import dev.ben10dollar.golfgame.entities.GolfBall;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course {

    private Handler handler;
    private ArrayList<Player> players;
    private ArrayList<Hole> holesInCourse;
    private int currentHoleIndex;
    private boolean courseComplete;

    public Course(Handler handler, ArrayList<Player> players) {
        this.handler = handler;
        this.players = players;
        holesInCourse = new ArrayList<Hole>();
        currentHoleIndex = 0;
    }

    public void tick() {
        if(!holesInCourse.get(currentHoleIndex).holeComplete()) {
            handler.getCamera().setHole(holesInCourse.get(currentHoleIndex));
            holesInCourse.get(currentHoleIndex).tick();
        }
        else if(currentHoleIndex+1 >= holesInCourse.size()) {
            courseComplete = true;
        }
        else currentHoleIndex++;
    }
    public void render(Graphics g) {
        holesInCourse.get(currentHoleIndex).render(g);
    }

    public void holeAdd(Hole hole) {
        for(Player player:players)
            hole.addEntity(new GolfBall(handler, player, hole));
        holesInCourse.add(hole);
    }
    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isCourseComplete() {
        return courseComplete;
    }
}
