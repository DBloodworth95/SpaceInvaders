package dev.game.entities;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
        if (x <= 0)
            x = 0;
        if (x >= 800 - 32)
            x = 800 - 32;
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(game.getInputHandler().left) {
            xMove = -speed;
        }
        if (game.getInputHandler().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.player, (int) x,(int) y, width, height,null);
    }

    public float getX() {
        return x;
    }
}
