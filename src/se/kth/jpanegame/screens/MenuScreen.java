package se.kth.jpanegame.screens;

import se.kth.jpanegame.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScreen extends Screen {

    private Font titleFont;
    private Font menuFont;

    public MenuScreen() {
        titleFont = new Font("TimesRoman", Font.BOLD, 34);
        menuFont = new Font("TimesRoman", Font.PLAIN, 20);
    }

    public void update(Input input) {
        if (input.isKeyDown(KeyEvent.VK_S)) {
            startGame();
        }

        if (input.isKeyDown(KeyEvent.VK_Q)) {

        }
    }

    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("2DPlatform", 100, 100);
        g.setFont(menuFont);
        g.drawString("S: Start Game", 100, 150);
        g.drawString("Q: Quit", 100, 200);
    }

    public void startGame() {
        this.setScreen(new GameScreen());
    }
}
