package dev.game.gfx;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Asset {
    public static BufferedImage player, wallFullHealth, wall1, wall2, wall3, wall4, wall5, bullet, alien1, alien12, alien2, alien22, alien3, alien32,
    titleImage, formationImage, blackTile, alienSplat;

    public Asset() {

    }

    public static void init() {
        SpriteSheet gameSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
        SpriteSheet otherSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spaceinvaderssprite.png"));
        player = gameSheet.crop(141,452,28,14);
        alien1 = gameSheet.crop(399,476,66,65);
        alien12 = gameSheet.crop(503,479,64,64);
        alien2 = gameSheet.crop(387,581,89,64);
        alien22 = gameSheet.crop(481,591,89,64);
        alien3 = gameSheet.crop(375,689,96,64);
        alien32 = gameSheet.crop(489,689,96,64);
        bullet = gameSheet.crop(144,697,15,15);
        wallFullHealth = gameSheet.crop(200,437,32,32);
        wall1 = gameSheet.crop(373, 211, 44,32);
        wall2 = gameSheet.crop(428,210,36,32);
        wall3 = gameSheet.crop(480,209,44,32);
        titleImage = gameSheet.crop(173,8, 229,157);
        formationImage = gameSheet.crop(121,1577,348,155);
        blackTile = otherSheet.crop(329,1000,32,32);
        alienSplat = gameSheet.crop(437,277,28,17);
    }

}
