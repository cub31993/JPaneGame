package se.kth.jpanegame.controller;

import se.kth.jpanegame.model.World;
import se.kth.jpanegame.model.entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class PlayerController implements KeyListener
{
    private World world;
    private Player player;

    public PlayerController(World world)
    {
        this.world = world;
        this.player = world.getPlayer();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        System.out.println("Keypressed: " + keyEvent.getKeyChar());

        switch(keyEvent.getKeyChar())
        {
            case 'a': case 'A':
            this.player.moveLeft();
            break;
            case 'd':case 'D':
            this.player.moveRight();
            break;
            case 'w':case 'W':
            this.player.jump();
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {

    }
}
