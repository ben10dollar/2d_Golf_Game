package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIImageButton;
import dev.ben10dollar.golfgame.user_interface.UIManager;
import dev.ben10dollar.golfgame.user_interface.UITextButton;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);

        uiManager.addObject(new UIImageButton(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), true, Assets.background, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));
        uiManager.addObject(new UITextButton(handler.getGame().getWidth()/2, handler.getWidth()/4, 0, 0, true,"Golphers!", true, Color.GREEN, Assets.font84, new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Golphers");
            }
        }));
        uiManager.addObject(new UITextButton(handler.getGame().getWidth()/2, handler.getWidth()/2, 0, 0, true,"Start", true, Color.ORANGE, Assets.font56, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().setGameState(new GameState(handler));
                handler.getGame().setCurrentState(handler.getGame().getGameState());
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
