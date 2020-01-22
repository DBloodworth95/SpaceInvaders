package dev.game.entities;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;
import java.awt.*;


public class AlienSplat extends Creature implements EntityInterface {

    private Game game;
    public int count = 0;
    public int Imgcount;
    public Rectangle alienBound;
    public boolean isDead;

    public AlienSplat(Game game, float x, float y, boolean isDead) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        this.isDead = isDead;

    }

    @Override
    public void tick() {
        count++;
        if (count == 60) {
            yMove += speed + 10;
            Imgcount = 1;
        }
        if (count == 120) {
            x += 10;
            Imgcount = 0;
        }
        if (count == 180) {
            y += 10;
            Imgcount = 1;
        }
        if (count == 240) {
            x -= 10;
            count = 0;
            Imgcount = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.alienSplat, (int) x,(int) y, width, height,null);
    }

    public Rectangle getAlienBound() {
        alienBound = new Rectangle((int)getX(),(int)getY(),Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        return  alienBound;
    }
    public boolean dead() {
        isDead = true;
        return true;
    }
}
