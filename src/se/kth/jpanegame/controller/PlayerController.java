package se.kth.jpanegame.controller;

import se.kth.jpanegame.Input;
import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Player;

import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class PlayerController
{

    /*enum Keys {
        LEFT, RIGHT, UP, DOWN
    } */

    private World world;
    private Player player;

    public PlayerController(World world)
    {
        this.world = world;
        this.player = world.getPlayer();
    }

    public void update(Input input) {

        if (input.isKeyDown(KeyEvent.VK_LEFT)) {
            this.player.moveLeft();
        }

        if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
            this.player.moveRight();
        }

        if(input.isKeyDown(KeyEvent.VK_UP)) {
            this.player.jump();
        }

        if(input.isKeyPressed(KeyEvent.VK_DOWN)) {
           this.player.liftAnBox(this.world.getPhysicsWorld().getEntities());
        }
    }
}
