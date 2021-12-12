package dev.ben10dollar.golfgame.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    //place that the "artist" (us) inserts our canvas into
    private Canvas canvas;
    //place that we "draw" graphics on

    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
        //function for display specifically for organization
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
        //packs all of the canvas into the frame
    }



    //___Getters and Setters___
    public Frame getFrame() {
        return frame;
    }
    public Canvas getCanvas() {
        return canvas;
    }
}
