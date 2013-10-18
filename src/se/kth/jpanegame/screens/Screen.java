package se.kth.jpanegame.screens;

import se.kth.jpanegame.Game;

import java.awt.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public class Screen {

    protected static Random random = new Random();
    protected Game game;

    public void removed() {
    }

    public final void init(Game Game) {
        this.game = Game;
        System.out.println("testar");
    }

    protected void setScreen(Screen screen) {
        game.setScreen(screen);
    }

    public void render(Graphics g) {
    }

    public void update() {
    }
}