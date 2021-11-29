package dev.ben10dollar.golfgame;

import dev.ben10dollar.golfgame.display.Display;

public class Game implements Runnable{
    //main class of the golf game

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    Thread thread = new Thread();
    //whole program (2d_Golf_Game) runs on its own program
    //game thread runs on it's own mini-program, to keep it separate
    //utility: allows us to run a class separately from the rest of the program

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        display = new Display(title, width, height);
    }


    private void init() {
        //stands for "initialize"
        //starts game loop: updates all variables -> renders everything to screen, on repeat

        display = new Display(title, width, height);
    }
    private void update() {
        //updates every variable for the game
        //sometimes represented by "tick()"
    }
    private void render() {
        //specific method to draw graphics

    }
    public void run() {
        init();
        while(running) {
            update();
            render();
        }
        stop();
    }
    public synchronized void start() {
        //synchronized for when we're working with a thread, so nothing gets messed up

        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running) return;

        running = false;
        try { thread.join(); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
    //thread control methods
}
