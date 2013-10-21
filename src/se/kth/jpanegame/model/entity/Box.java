package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.Entity;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class Box extends PhysicsEntity
{
    public Box(Vector2f position, int width, int height)
    {
        super(position, width, height, 0, true);
        this.createRectange();
        this.getRectangle().setBounds((int)position.getX(), (int)position.getY(), (int)width, (int)height);
        this.setColor(Color.lightGray);
        this.setCollisionFilter(CollisionFilter.BOX);
    }
}
