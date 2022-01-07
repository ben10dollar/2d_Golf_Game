package dev.ben10dollar.golfgame.user_interface;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.graphics.Text;

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
        Text.drawString(g, text, (int)x, (int)y, center, color, font);
    }
    @Override
    public void onClick() {
        clicker.onClick();
    }
}
