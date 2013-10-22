package se.kth.jpanegame.screens;

import se.kth.jpanegame.Camera;
import se.kth.jpanegame.Input;
import se.kth.jpanegame.Strings;
import se.kth.jpanegame.controller.PlayerController;
import se.kth.jpanegame.Assets;
import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Darkness;
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
    private Darkness darkness;

    public GameScreen() {
        this.world = new World();  // skapar world
        controller = new PlayerController(world);    // skapar spelar kontroller
        player = world.getPlayer();
        camera = new Camera(player);
        this.darkness = new Darkness(960, 720);
    }

    public void update(Input input) {
        this.world.getPhysicsWorld().update();
        controller.update(input);

        if(player.getPosition().getY() > 500) {
            setScreen(new LostScreen());
        }

        this.darkness.update(this.world.level.getLightList());
    }

    public void render(Graphics g) {
        //g.drawImage(Assets.bg, 0, 0, null);  // ritar ut bakgrund

        camera.updateView(world.getEntitys());

        for(Entity e: world.getEntitys()) {
            if(e.isRenderable())
            {
                g.setColor(e.getColor());
                g.fillRect((int)e.getPosition().getX(), (int)e.getPosition().getY(), e.getWidth(), e.getHeight());
            }
        }

        if(this.player.getCanLift() && this.world.getHUD().getText() != Strings.LIFT_TIPS)
        {
            this.world.getHUD().setTextWithTimeout(Strings.LIFT_TIPS, 1, 0.7f);
        }

        this.darkness.render(g);
        //g.drawImage(Assets.darkness, 0,0, null);
        this.world.getHUD().render(g);


       // g.drawRect((int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth(), player.getHeight());
    }

    public PlayerController getController()
    {
        return this.controller;
    }
}
