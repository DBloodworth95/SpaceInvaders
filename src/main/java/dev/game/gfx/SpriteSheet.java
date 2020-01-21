package dev.game.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage gameSheet;

    public SpriteSheet(BufferedImage gameSheet) {
        this.gameSheet = gameSheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return gameSheet.getSubimage(x,y,width,height);
    }
}
