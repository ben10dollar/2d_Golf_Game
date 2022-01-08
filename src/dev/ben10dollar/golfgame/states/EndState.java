package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIImageButton;
import dev.ben10dollar.golfgame.user_interface.UITextButton;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class EndState extends State {

    public EndState(Handler handler) {
        super(handler);

        uiManager.addObject(new UIImageButton(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), true, Assets.background, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));

        uiManager.addObject(new UITextButton(handler.getGame().getWidth()/2, handler.getWidth()/4, 0, 100, true,"You Won!", true, Color.BLUE, Assets.font84, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));
        uiManager.addObject(new UITextButton(handler.getGame().getWidth()/2, handler.getWidth() * 3.0/8.0, 0, 100, true,"Score: " + String.valueOf(handler.getGame().getGameState().getPlayers().get(0).getTotalScore()), true, Color.GREEN, Assets.font56, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));
        uiManager.addObject(new UITextButton(handler.getGame().getWidth()/2, handler.getWidth()/2, 0, 50, true, "Play Again", true, Color.ORANGE, Assets.font56, new ClickListener() {
            @Override
            public void onClick() {
                handler.setCurrentState(handler.getGame().getMenuState());
            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
    }
    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
