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
    }

    public void render(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getWidth(), (int)this.getHeight());
        System.out.println("Position: "+this.getPosition().toString());
    }
}
