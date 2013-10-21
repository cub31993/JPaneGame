package se.kth.jpanegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-18
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class Input implements KeyListener {

    private int[] keys = new int[256];

    private boolean[] keyStateUp = new boolean[256];
    private boolean[] keyStateDown = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() >= 0 && e.getKeyCode() < 256 ) {
            keys[e.getKeyCode()] = (int) System.currentTimeMillis();
            keyStateDown[e.getKeyCode()] = true;
            keyStateUp[e.getKeyCode()] = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( e.getKeyCode() >= 0 && e.getKeyCode() < 256 ) {
            keys[e.getKeyCode()] = 0;
            keyStateUp[e.getKeyCode()] = true;
            keyStateDown[e.getKeyCode()] = false;
        }
    }

    public boolean isKeyDown( int key ) {
        return keyStateDown[key];
    }

    public boolean isKeyUp( int key ) {
        return keyStateUp[key];
    }

    public boolean isKeyPressed( int key)
    {
        boolean keyReturn = this.keyStateDown[key];
        this.keyStateDown[key] = false;

        return keyReturn;
    }

    public void update() {
        keyStateUp = new boolean[256];
    }
}
