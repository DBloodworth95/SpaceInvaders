package dev.game.entities;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;
import java.awt.*;


public class Alien extends Creature implements EntityInterface {

    private Game game;
    public int count = 0;
    public int Imgcount;
    public Rectangle alienBound;
    public boolean isDead;

    public Alien(Game game, float x, float y, boolean isDead) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        this.isDead = isDead;

    }

    @Override
    public void tick() {
        count++;
        if (count == 60) {
            y += 10;
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
        g.drawImage(Asset.alien1, (int) x,(int) y, width, height,null);
        if (Imgcount == 1) {
            g.drawImage(Asset.blackTile, (int) x,(int) y, width, height,null);
            g.drawImage(Asset.alien12, (int) x,(int) y, width, height,null);
        }
        if (isDead) {
            g.drawImage(Asset.blackTile, (int) x,(int) y, width, height,null);
            g.drawImage(Asset.alienSplat, (int) x,(int) y, width, height,null);
        }
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
