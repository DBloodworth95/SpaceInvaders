package dev.game.states;

import dev.game.fungame.Game;
import dev.game.gfx.Asset;

import javax.swing.*;
import java.awt.*;

public class MainState extends State {

    public MainState (Game game) {
        super(game);
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect(0,0,800,600);
        g.drawImage(Asset.titleImage, 300,50,null);
        g.drawImage(Asset.formationImage, 250, 300, null);
    }
}
