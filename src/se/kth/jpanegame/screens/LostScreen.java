package se.kth.jpanegame.screens;

import se.kth.jpanegame.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-22
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class LostScreen extends Screen {

    private Font titleFont;
    private Font menuFont;

    public LostScreen() {
        titleFont = new Font("TimesRoman", Font.BOLD, 34);
        menuFont = new Font("TimesRoman", Font.PLAIN, 20);
    }

    public void update(Input input) {
        if (input.isKeyDown(KeyEvent.VK_R)) {
            startGame();
        }

        if (input.isKeyDown(KeyEvent.VK_Q)) {
            game.stop();
        }
    }

    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("You lost!", 100, 100);
        g.setFont(menuFont);
        g.drawString("R: Restart Game", 100, 150);
        g.drawString("Q: Quit", 100, 200);
    }

    public void startGame() {
        this.setScreen(new GameScreen());
    }
}
