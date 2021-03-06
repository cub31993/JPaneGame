package se.kth.jpanegame;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Entity implements Renderable
{
    private Vector2f position;
    private float width;
    private float height;
    private Rectangle rectangle;

    public Entity(Vector2f position, float width, float height)
    {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Vector2f getPosition()
    {
        return this.position;
    }

    public float getWidth()
    {
        return this.width;
    }

    public float getHeight()
    {
        return this.height;
    }

    public Rectangle getRectangle()
    {
        return this.rectangle;
    }

    public void createRectange()
    {
        this.rectangle = new Rectangle((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getWidth(), (int)this.getHeight());
    }

    public void setPosition(Vector2f position)
    {
        this.position = position;
    }

    public void setPosition(float x, float y)
    {
        this.position.setX(x);
        this.position.setY(y);
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }
}