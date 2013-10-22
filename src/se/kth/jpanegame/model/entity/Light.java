package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-22
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class Light extends Entity
{
    private Vector2f position;
    private int size;

    public Light(Vector2f position, int size, int rectangleSize) {
        super(position, rectangleSize, rectangleSize);
        this.position = position;
        this.size = size;
        this.setColor(new Color(0.83f, 0.48f, 0));
        this.setRenderable(true);
    }

    public int getSize()
    {
        return this.size;
    }
}
