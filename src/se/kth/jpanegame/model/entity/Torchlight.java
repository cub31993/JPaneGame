package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-22
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class Torchlight extends PhysicsEntity {

    private Light light;

    public Torchlight(Vector2f position, int width, int height) {
        super(position, width, height, 0, true);
        this.createRectangle();
        this.getRectangle().setBounds((int)position.getX(), (int)position.getY(), (int)width, (int)height);
        this.setColor(new Color(0.32f, 0.14f, 0));
        this.setCollisionFilter(CollisionFilter.TORCHLIGHT);
        this.light = new Light(new Vector2f(this.getPosition().getX()-4, this.getPosition().getY()-16), 256, 16);
    }

    public Light getLight()
    {
        return this.light;
    }


    public void update()
    {
        super.update();
        this.light.setPosition(new Vector2f(this.getPosition().getX()-4, this.getPosition().getY()-16));

        float r = 0.7f + (float)Math.random()*0.3f;
        float g = 0.3f + (float)Math.random()*0.4f;

        this.light.setColor(new Color(r, g, 0));
    }
}
