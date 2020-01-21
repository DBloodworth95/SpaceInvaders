package dev.game.states;

import dev.game.entities.*;
import dev.game.fungame.Game;

import java.awt.*;
import java.util.LinkedList;

public class GameState extends State {
    private Player player;
    private Alien alien;
    private Bullet bullet;
    private Controller controller;
    public boolean isShooting;
    private int enemyCount = 10;

    public GameState(Game game) {
        super(game);
        loadWorld();
    }

    @Override
    public void tick() {
        player.tick();
        controller.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        player.render(g);
        controller.render(g);
        if (game.getInputHandler().space && !isShooting) {
            isShooting = true;
            bullet = new Bullet(game, player.getX() + 5, player.getY()-25);
            controller.addEntity(bullet);
        }
        if (!game.getInputHandler().space && isShooting) {
            isShooting = false;
        }

    }

    public void loadWorld() {
        player = new Player(game, 400, 550);
        alien = new Alien(game, 100, 100,false);
        controller = new Controller(game);
    }

    public int getEnemyCount() {
        return enemyCount;
    }
}

