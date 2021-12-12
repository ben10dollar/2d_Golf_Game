package dev.ben10dollar.golfgame;

import dev.ben10dollar.golfgame.display.Display;
import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.graphics.Camera;
import dev.ben10dollar.golfgame.input.MouseManager;
import dev.ben10dollar.golfgame.states.GameState;
import dev.ben10dollar.golfgame.states.MenuState;
import dev.ben10dollar.golfgame.states.SettingsState;
import dev.ben10dollar.golfgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    //main class of the golf game

    private static final int TARGET_FPS = 60;

    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    Thread thread = new Thread();
    //whole program (2d_Golf_Game) runs on its own program
    //game thread runs on it's own mini-program, to keep it separate
    //utility: allows us to run a class separately from the rest of the program

    private BufferStrategy bs;
    //"hidden" computer screen within computer (actual just data of a screen)
    private int numOfBuffers = 3;
    private Graphics g;

    //states
    private GameState gameState;
    private State menuState;
    private State settingsState;

    //camera
    private Camera camera;

    //mouse input
    private MouseManager mouseManager;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //___Game Control Methods___
    private void init() {
        //stands for "initialize"
        //starts game loop: updates all variables -> renders everything to screen, on repeat

        display = new Display(title, width, height);
        Assets.init();

        camera = new Camera(this, 0, 0);
        mouseManager = new MouseManager(this);
        display.getFrame().addMouseListener(mouseManager);

        gameState = new GameState(this);
        menuState = new MenuState(this);
        settingsState = new SettingsState(this);
        State.setState(gameState);
    }
    private void tick() {
        //updates every variable for the current game state

        if(State.getState() != null)
            State.getState().tick();
    }
    private void render() {
        //specific method to draw graphics
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(numOfBuffers);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);
        //clears screen

        //Draw her
        if(State.getState() != null)
        State.getState().render(g);
        //Stop drawing

        bs.show();
        g.dispose();
    }
    public void run() {

        init();

        double timePerTick = 1_000_000_000 / TARGET_FPS;
        //one second (in nanoseconds) / fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            //now - lastTime = how much time has passed since last call this line
            //time per tick is how many nanoseconds per frame
            //delta = how many frames (or fraction of a frame) should now be loaded
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
            //if at least one frame's worth of time has passed, load one frame
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1_000_000_000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    public synchronized void start() {
        //synchronized for when we're working with a thread, so nothing gets messed up

        if (running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try { thread.join(); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }



    //___Getters and Setters___
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Camera getCamera() {
        return camera;
    }
    public MouseManager getMouseManager() {
        return mouseManager;
    }
    public GameState getGameState() {
        return gameState;
    }
    public int getTargetFps() {
        return TARGET_FPS;
    }
}
