package dev.game.entities;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;
import dev.game.states.GameState;

import java.awt.*;

public class Bullet extends Creature implements EntityInterface {
    private Game game;
    private Rectangle bulletBound;

    public Bullet(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;

    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput() {
        yMove = -speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.bullet, (int) x,(int) y, width, height,null);
    }

    public Rectangle getBulletBound() {
        bulletBound = new Rectangle((int)getX(),(int)getY(),Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        return  bulletBound;
    }

}
