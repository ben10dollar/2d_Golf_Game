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

    public UITextButton(double x, double y, int width, int height, boolean visible, String text, boolean center, Color color, Font font, ClickListener clicker) {
        super(x, y, width, height, visible);;
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
    protected void render(Graphics g) {
        FontMetrics fm = g.getFontMetrics(font);
        g.setColor(Color.LIGHT_GRAY);

        bounds.x = (int)x - fm.stringWidth(text)/2;
        bounds.width = fm.stringWidth(text);
        bounds.y = (int)y - fm.getHeight()/2;
        bounds.height = fm.getHeight();

        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(Color.BLACK);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

        Utils.drawString(g, bounds, text, (int)x, (int)y, center, color, font);
    }
    @Override
    public void onClick() {
        clicker.onClick();
    }

    public void setText(String text) {
        this.text = text;
    }
}
