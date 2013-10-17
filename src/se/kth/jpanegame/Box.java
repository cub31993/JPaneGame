package se.kth.jpanegame;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class Box extends Entity
{
    public Box(Vector2f position, float width, float height)
    {
        super(position, width, height);
        this.createRectange();
        this.getRectangle().setBounds((int)position.getX(), (int)position.getY(), (int)width, (int)height);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getWidth(), (int)this.getHeight());
        //System.out.println("Position: "+this.getPosition().toString());
    }
}
