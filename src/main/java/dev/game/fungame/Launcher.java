package dev.game.fungame;

import dev.game.display.Display;

public class Launcher {
    //Generate a Game class and call start();
    //This starts the game thread loop, and sets the running boolean to true. start(); calls run by default
    //which conains a while loop, while running is true, call tick(); and render(); which starts the tick system and
    //renders our states/sprites
    public static void main(String[] args) {
       Game game = new Game("Dan's Space Invaders!", 800,600);
       game.start();
    }
}
