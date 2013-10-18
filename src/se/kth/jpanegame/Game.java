package se.kth.jpanegame;

/**
 * Created with IntelliJ IDEA.
 * User: marek, fredrik
 * Date: 2013-10-16
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */

import se.kth.jpanegame.screens.GameScreen;
import se.kth.jpanegame.screens.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final String NAME = "2DPlatformGame";
    public static final int HEIGHT = 240;
    public static final int WIDTH = 320;
    private static final int SCALE = 3;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private Screen screen;

    private boolean running = false;

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        requestFocus();

        setScreen(new GameScreen());

        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int updates = 0;
        long lastTimer1 = System.currentTimeMillis();


        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while (unprocessed >= 1) {
                updates++;
                update();
                unprocessed -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            frames++;
            render();

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(updates + " updates, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
    }

    public void update() {
        screen.update();
    }

    public void render() {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        screen.render(g);

        g.dispose();
        bs.show();
    }

    public void setScreen (Screen newScreen) {
        if (screen != null) screen.removed();
        screen = newScreen;
        if (screen != null) screen.init(this);
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}
