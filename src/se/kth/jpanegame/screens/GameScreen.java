package se.kth.jpanegame.screens;

import se.kth.jpanegame.controller.PlayerController;
import se.kth.jpanegame.Assets;
import se.kth.jpanegame.model.World;
import se.kth.jpanegame.view.WorldRenderer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public class GameScreen extends Screen {

    private World world;
    private WorldRenderer renderer;
    private PlayerController controller;

    public GameScreen() {
        this.world = new World();  // skapar world
        renderer = new WorldRenderer(world);   // skapar vår world view
        controller = new PlayerController(world);    // skapar spelar kontroller
    }

    public void update() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.bg, 0, 0, null);  // ritar ut GameScreen bakgrund
        renderer.render(g);   // varje screen har en view som rendrar allt
    }
}
