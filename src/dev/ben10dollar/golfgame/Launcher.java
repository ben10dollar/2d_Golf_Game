package dev.ben10dollar.golfgame;

import dev.ben10dollar.golfgame.display.Display;

public class Launcher {

    public static void main(String[] args) {
        //actually starts up (launches) the game

        Game game = new Game("Golf Game", 300, 300);
        game.start();
    }

}
