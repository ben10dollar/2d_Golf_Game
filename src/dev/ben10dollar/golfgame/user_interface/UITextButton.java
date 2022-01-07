package dev.ben10dollar.golfgame.user_interface;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.utils.Utils;

import java.awt.*;

public class UITextButton extends UIObject{

    private String text;
    private boolean center;
    private Color color;
    private Font font;
    private ClickListener clicker;

    public UITextButton(double x, double y, int width, int height, String text, boolean center, Color color, Font font, ClickListener clicker) {
        super(x, y, width, height);;
        this.text = text;
        this.center = center;
        this.color = color;
        this.font = font;
        this.clicker = clicker;
    }

    @Override
    public void tick() {

    }
    @Override
    public void render(Graphics g) {
        int[] textMeasurements = Utils.drawString(g, text, (int)x, (int)y, center, color, font);
        g.setColor(Color.BLACK);
        bounds.x = (int)x - textMeasurements[0]/2;
        bounds.width = textMeasurements[0];
        bounds.y = (int)y - textMeasurements[1]/2;
        bounds.height = textMeasurements[1];
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    @Override
    public void onClick() {
        clicker.onClick();
    }
}
