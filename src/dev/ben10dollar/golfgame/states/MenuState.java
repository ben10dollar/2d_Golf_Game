package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIImageButton;
import dev.ben10dollar.golfgame.user_interface.UIManager;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);

        uiManager.addObject(new UIImageButton(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), Assets.background, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));
        uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2 - Assets.gameTileWidth * 40 / 2, handler.getGame().getHeight()/8, Assets.gameTileWidth * 40, Assets.gameTileHeight * 20, Assets.golphersName, new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("hi!");
            }
        }));
        uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2 - Assets.gameTileWidth * 40 / 2, handler.getGame().getHeight()/2, Assets.gameTileWidth * 40, Assets.gameTileHeight * 20, Assets.startButton, new ClickListener() {
            @Override
            public void onClick() {
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
