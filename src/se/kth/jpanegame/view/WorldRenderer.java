package se.kth.jpanegame.view;

import se.kth.jpanegame.model.World;
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
    }

    public void render(Graphics g) {

    }
}
