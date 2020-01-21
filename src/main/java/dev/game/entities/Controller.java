package dev.game.entities;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Controller {

    private ArrayList<Alien> aL = new ArrayList<Alien>();
    private ArrayList<Bullet> bL = new ArrayList<Bullet>();
    private int x = 80;
    public int deltaTime;
    public int score;
    Alien a;
    Bullet b;
    Game game;


    public Controller(Game game) {
        this.game = game;

        for (int i = 1; i < 9; i++) {
            addEntity(new Alien(game, x, 100, false));
            x += 80;
        }
        x = 80;
        for (int i = 1; i < 9; i++) {
                addEntity(new Alien(game, x, 200, false));
                x += 80;
        }
        x = 80;
        for (int i = 1; i < 9; i++) {
            addEntity(new Alien(game, x, 300, false));
            x += 80;
        }
        x = 80;
    }

    public void tick() {
        deltaTime++;
        for (int i = 0; i < aL.size(); i++) {
            a = aL.get(i);
            a.tick();
        }
        for (int i = 0; i < bL.size(); i++) {
            b = bL.get(i);
            if (b.getY() < 0) {
                removeEntity(b);
            }
            b.tick();
            Iterator<Alien> itr = aL.iterator();
            while(itr.hasNext()) {
                a = itr.next();
                if (b.getBulletBound().intersects(a.getAlienBound())) {
                    a.isDead = true;
                    resetCount();
                }
                if (a.isDead == true && deltaTime == 1) {
                    removeEntity(b);
                    itr.remove();
                    score = score + 1;
                }

            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < aL.size(); i++) {
            a = aL.get(i);
            a.render(g);
        }
        for (int i = 0; i < bL.size(); i++) {
            b = bL.get(i);
            b.render(g);
        }
        drawScore(g);
    }

    public void drawScore(Graphics g) {
        Font scoreFont = new Font("TimesRoman", 4, 17);
        g.setFont(scoreFont);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10,20);
    }
    public void drawSplat(Graphics g) {
        g.drawImage(Asset.alienSplat, (int) x,(int) a.y, a.width, a.height,null);
    }

    public void addEntity(Alien a) {
        aL.add(a);
    }
    public void addEntity(Bullet b) {
        bL.add(b);
    }
    public void removeEntity(Bullet b) {
        bL.remove(b);
    }
    public void removeEntity(Alien a) {
        aL.remove(a);
    }
    public void resetCount() {
        deltaTime = 0;
    }



}
