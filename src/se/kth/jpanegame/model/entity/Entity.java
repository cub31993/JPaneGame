package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Entity
{
    private Vector2f position;
    private int width;
    private int height;
    private Rectangle rectangle;
    private Color color = Color.darkGray;

    public Entity(Vector2f position, int width, int height)
    {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Vector2f getPosition()
    {
        return this.position;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
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

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return this.color;
    }
}