package se.kth.jpanegame;

import se.kth.jpanegame.model.entity.Entity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class Camera
{
    private Entity chaseObject;
    private int x;
    private int y;
    private int prev_x;
    private int prev_y;

    public Camera()
    {
        this.x = 0;
        this.y = 0;
    }

    public Camera(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Camera(Entity chaseEntity)
    {
        this.chaseObject = chaseEntity;
        this.x = (int)chaseEntity.getPosition().getX();
        this.y = (int)chaseEntity.getPosition().getY();
    }

    public void setPosition(int x, int y)
    {
        this.prev_x = this.x;
        this.prev_y = this.y;
        this.x = x;
        this.y = y;
    }

    public void setPosition(Vector2f position)
    {
        this.prev_x = this.x;
        this.prev_y = this.y;
        this.x = (int)position.getX();
        this.y = (int)position.getY();
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void updateView(ArrayList<Entity> renderList)
    {
        if(chaseObject != null)
        {
            this.x = (int)chaseObject.getPosition().getX() - 480 + 16;
            this.y = (int)chaseObject.getPosition().getY() - 360 + 32;
        }

        int diff_x = this.prev_x - this.x;
        int diff_y = this.prev_y - this.y;

        for(Entity entity:renderList)
        {
            entity.setPosition(entity.getPosition().getX() + diff_x, entity.getPosition().getY() + diff_y);
        }
    }
}