package dev.game.entities;

public abstract class Creature extends Entity {
    public static int DEFAULT_HEALTH = 100;
    public static int DEFAULT_CREATURE_WIDTH = 16,
                            DEFAULT_CREATURE_HEIGHT = 16;
    public static final float DEFAULT_SPEED= 3.0f;
    protected int lifePoints;
    protected float speed;
    protected float xMove, yMove, delta;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        lifePoints = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public float getSpeed() {
        return speed;
    }
}
