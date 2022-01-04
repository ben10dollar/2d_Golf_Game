package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.Game;
import dev.ben10dollar.golfgame.user_interface.UIManager;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public abstract class State {

    protected static State currentState = null;
    protected Handler handler;
    protected UIManager uiManager;

    public State(Handler handler) {
        this.handler = handler;
        uiManager = new UIManager(handler);
    }

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
