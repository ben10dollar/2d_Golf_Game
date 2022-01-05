package dev.ben10dollar.golfgame.states;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.user_interface.ClickListener;
import dev.ben10dollar.golfgame.user_interface.UIImageButton;
import dev.ben10dollar.golfgame.utils.Handler;

import java.awt.*;

public class EndState extends State {

    public EndState(Handler handler) {
        super(handler);

        uiManager.addObject(new UIImageButton(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), Assets.background, new ClickListener() {
            @Override
            public void onClick() {
            }
        }));
        uiManager.addObject(new UIImageButton(handler.getGame().getWidth() / 2 - Assets.gameTileWidth * 40 / 2, handler.getGame().getHeight() / 8, Assets.gameTileWidth * 40, Assets.gameTileHeight * 20, Assets.golphersName, new ClickListener() {
            @Override
            public void onClick() {
                handler.getCurrentState() = handler.getGame().getGameState();
            }
        }));
    }

    @Override
    public void tick() {

    }
    @Override
    public void render(Graphics g) {

    }
}
