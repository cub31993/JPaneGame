package se.kth.jpanegame.model;

import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.Entity;
import se.kth.jpanegame.model.entity.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek, fredrik
 * Date: 2013-10-16
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class World
{

    public Player player;
    ArrayList<Entity> entities;

    public World()
    {
        this.entities = new ArrayList<Entity>();
        this.player = new Player(new Vector2f(0,0), 1f, 1f);
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

    public Player getPlayer() {
        return this.player;
    }
}
