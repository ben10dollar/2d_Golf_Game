package dev.ben10dollar.golfgame;

import dev.ben10dollar.golfgame.display.Display;
import dev.ben10dollar.golfgame.graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    //main class of the golf game

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    Thread thread = new Thread();
    //whole program (2d_Golf_Game) runs on its own program
    //game thread runs on it's own mini-program, to keep it separate
    //utility: allows us to run a class separately from the rest of the program

    private BufferStrategy bs;
    //"hidden" computer screen within computer (actual just data of a screen)
    private int numOfBuffers = 3;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private BufferedImage testImage;

    //___Game Control Methods___
    private void init() {
        //stands for "initialize"
        //starts game loop: updates all variables -> renders everything to screen, on repeat

        display = new Display(title, width, height);

        testImage = ImageLoader.loadImage("/textures/Sauron_Jeweled.jpg");
    }

    private void update() {
        //updates every variable for the game
        //sometimes represented by "tick()"
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

        //Draw here

        g.drawRect(10, 50 ,50, 70);
        g.drawImage(testImage, 20, 20, null);

        //Stop drawing

        bs.show();
        g.dispose();
    }

    public void run() {
        init();
        while (running) {
            update();
            render();
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

}
