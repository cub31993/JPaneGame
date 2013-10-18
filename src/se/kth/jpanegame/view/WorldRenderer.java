package se.kth.jpanegame.view;

import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Entity;
import se.kth.jpanegame.model.entity.Player;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */

public class WorldRenderer {

    public World world;
    public Player player;

    public WorldRenderer(World world) {
        this.world = world;
        this.player = world.getPlayer();
        System.out.println("renderer init");
    }

    public void render(Graphics g) {
        for(Entity e: world.getEntitys()) {
            g.fillRect((int)e.getPosition().getX() * 32, (int)e.getPosition().getY() * 32, e.getWidth(), e.getHeight());
        }

        g.drawRect((int)player.getPosition().getX(), (int)player.getPosition().getY(), player.getWidth(), player.getHeight());
    }
}
