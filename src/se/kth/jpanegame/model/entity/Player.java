package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

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
    private final float jump_speed = -10.0f;

    public Player(Vector2f position, int width, int height, float mass, boolean dynamic) {
        super(position, width, height, mass, dynamic);
    }

    public void moveLeft()
    {
        this.setVelocity(-x_speed, this.getVelocity().getY());
        //System.out.println("Playerpos: "+this.getPosition().toString());
        //this.update();
    }

    public void moveRight()
    {
        this.setVelocity(x_speed, this.getVelocity().getY());
        //this.update();
    }

    public void jump()
    {
        this.setVelocity(this.getVelocity().getX(), jump_speed);
    }

    public void stop()
    {
        //this.setVelocity(0, 0);
        //this.update();
    }
}
