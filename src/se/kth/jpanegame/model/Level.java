package se.kth.jpanegame.model;

import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.Block;
import se.kth.jpanegame.model.entity.Entity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
public class Level {

    private int width;
    private int height;
    private Vector2f spawnPosition;
    private ArrayList<Entity> entityList;
    private ArrayList<Entity> lightList;

    public byte[] blocks;

    public Level() {
        entityList = new ArrayList<Entity>();
        lightList = new ArrayList<Entity>();
    }

    public ArrayList<Entity> getEntitys() {
        return this.entityList;
    }

    public Vector2f getSpawn() {
        return spawnPosition;
    }

    public void setSpawn(int x, int y) {
        this.spawnPosition = new Vector2f(x, y);
    }

    public ArrayList<Entity> getLightList()
    {
        return this.lightList;
    }
}
