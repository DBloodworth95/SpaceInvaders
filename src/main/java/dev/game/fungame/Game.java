package dev.game.fungame;

import dev.game.display.Display;
import dev.game.gfx.Asset;
import dev.game.input.InputHandler;
import dev.game.states.GameState;
import dev.game.states.MainState;
import dev.game.states.State;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    private Thread gameThread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private State gameState, mainState;
    private InputHandler inputHandler;


    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        inputHandler = new InputHandler();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getMainFrame().addKeyListener(inputHandler);
        Asset.init();
        gameState = new GameState(this);
        mainState = new MainState(this);
        State.setState(gameState);
    }

    private void tick(double delta) {
        inputHandler.tick();

        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }
    private void render(double delta) {
        bs = display.getGameCanvas().getBufferStrategy();
        if(bs == null) {
            display.getGameCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0,0,width,height);
        //Draw here!
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose();
    }
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000/fps;
        float delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if(delta >= 1) {
                tick(delta);
                render(delta);
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    public synchronized void stop()  {
        if (!running)
            return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
