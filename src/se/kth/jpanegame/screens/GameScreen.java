package se.kth.jpanegame.screens;

import se.kth.jpanegame.Camera;
import se.kth.jpanegame.Input;
import se.kth.jpanegame.controller.PlayerController;
import se.kth.jpanegame.Assets;
import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Entity;
import se.kth.jpanegame.model.entity.Player;

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
    private PlayerController controller;
    private Player player;
    private Camera camera;

    public GameScreen() {
        this.world = new World();  // skapar world
        controller = new PlayerController(world);    // skapar spelar kontroller
        player = world.getPlayer();
        camera = new Camera(player);
    }

    public void update(Input input) {
        this.world.getPhysicsWorld().update();
        controller.update(input);
    }

    public void render(Graphics g) {
        g.drawImage(Assets.bg, 0, 0, null);  // ritar ut bakgrund

        camera.updateView(world.getEntitys());

        for(Entity e: world.getEntitys()) {
            g.setColor(e.getColor());
            g.fillRect((int)e.getPosition().getX(), (int)e.getPosition().getY(), e.getWidth(), e.getHeight());
        }

       // g.drawRect((int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth(), player.getHeight());
    }

    public PlayerController getController()
    {
        return this.controller;
    }

    public void initController()
    {
       // this.game.setFocusable(true);
        //this.game.addKeyListener(this.controller);
        System.out.println("Controller initialised!");
    }
}
