package se.kth.jpanegame;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class World
{
    ArrayList<Entity> entities;

    public World()
    {
        this.entities = new ArrayList<Entity>();
    }

    public void addEntity(Entity entity)
    {
        this.entities.add(entity);
    }

    public ArrayList<Entity> getEntities()
    {
        return this.entities;
    }

    public Entity getEntity(int i)
    {
        return this.entities.get(i);
    }
}
