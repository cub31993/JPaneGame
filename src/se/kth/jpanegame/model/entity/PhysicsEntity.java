package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class PhysicsEntity extends Entity
{
    private float mass;
    private Vector2f velocity;

    public PhysicsEntity(Vector2f position, int width, int height, float mass) {
        super(position, width, height);
        this.mass = mass;
        this.velocity = new Vector2f(0,0);
    }

    public void setVelocity(Vector2f velocity)
    {
        this.velocity = velocity;
    }

    public void setVelocity(float x, float y)
    {
        this.velocity.setValues(x,y);
    }

    public Vector2f getVelocity()
    {
        return this.velocity;
    }

    public void setMass(float mass)
    {
        this.mass = mass;
    }

    public float getMass()
    {
        return this.mass;
    }

    public void update()
    {
        this.setPosition(this.getPosition().getX()+this.getVelocity().getX(), this.getPosition().getY()+this.getVelocity().getY());
        this.setVelocity(this.getVelocity().getX()*0.9f, this.getVelocity().getY());
    }
}
