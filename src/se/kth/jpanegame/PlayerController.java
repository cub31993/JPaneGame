package se.kth.jpanegame;

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
    private Player player;

    public PlayerController(Player player)
    {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("Keypressed: "+keyEvent.getKeyChar());
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        System.out.println("Keypressed: "+keyEvent.getKeyChar());

        switch(keyEvent.getKeyChar())
        {
            case 'a': case 'A':
                this.player.moveLeft();
                break;
            case 'd':case 'D':
                this.player.moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        System.out.println("Keypressed: "+keyEvent.getKeyChar());
        this.player.stop();
    }
}
