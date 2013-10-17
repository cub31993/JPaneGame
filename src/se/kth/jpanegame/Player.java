package se.kth.jpanegame;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class Player extends PhysicsEntity
{
    private final float x_speed = 3.0f;

    public Player(Vector2f position, float width, float height, float mass) {
        super(position, width, height, mass);
    }

    public void moveLeft()
    {
        this.setVelocity(-x_speed, 0);
       // this.update();
    }

    public void moveRight()
    {
        this.setVelocity(x_speed, 0);
        //this.update();
    }

    public void stop()
    {
        this.setVelocity(0,0);
        //this.update();
    }

    @Override
    public void render(Graphics g)
    {
        this.update();
        g.setColor(Color.blue);
        g.fillRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getWidth(), (int)this.getHeight());
        System.out.println("Player Position: "+this.getPosition().toString());
    }
}
