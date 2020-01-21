package dev.game.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame mainFrame;
    private Canvas gameCanvas;
    private String title;
    private int titleWidth, titleHeight;

    //Display constructor which calls createGUI to generate a window(JFrame) and a canvas(which is what we draw onto).
    public Display(String title, int titleWidth, int titleHeight) {
        this.title = title;
        this.titleWidth = titleWidth;
        this.titleHeight = titleHeight;
        createGUI();
    }

    private void createGUI() {
        mainFrame = new JFrame(title);
        mainFrame.setSize(titleWidth, titleHeight);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        gameCanvas = new Canvas();
        gameCanvas.setPreferredSize(new Dimension(titleWidth,titleHeight));
        gameCanvas.setMinimumSize(new Dimension(titleWidth,titleHeight));
        gameCanvas.setMaximumSize(new Dimension(titleWidth,titleHeight));
        gameCanvas.setFocusable(false);
        mainFrame.add(gameCanvas);
        mainFrame.pack();
    }

    public Canvas getGameCanvas() {
        return gameCanvas;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
