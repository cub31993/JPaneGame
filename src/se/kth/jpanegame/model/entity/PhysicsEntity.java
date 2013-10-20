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
    private boolean dynamic, updated;
    private Vector2f velocity;

    public PhysicsEntity(Vector2f position, int width, int height, float mass, boolean dynamic) {
        super(position, width, height);
        this.mass = mass;
        this.velocity = new Vector2f(0,0);
        this.dynamic = dynamic;
        this.updated = true;
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

    public boolean isDynamic()
    {
        return this.dynamic;
    }

    public void setDynamic(boolean dynamic)
    {
        this.dynamic = dynamic;
    }

    public boolean isUpdated()
    {
        return this.updated;
    }

    public void setUpdated(boolean updated)
    {
        this.updated = updated;
    }

    public void update()
    {
        this.setVelocity(this.getVelocity().getX()*0.9f, this.getVelocity().getY());
        this.setPosition(this.getPosition().getX()+this.getVelocity().getX(), this.getPosition().getY()+this.getVelocity().getY());
    }
}
