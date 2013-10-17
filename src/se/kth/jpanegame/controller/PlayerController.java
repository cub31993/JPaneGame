package se.kth.jpanegame.controller;

import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class PlayerController {

    public World world;
    private Player player;

    public PlayerController(World world) {
        this.world = world;
        this.player = world.getPlayer();
    }

    public void update() {
        processInput();
        player.update();
    }

    private void processInput() {
    }
}
