package se.kth.jpanegame.model;

import se.kth.jpanegame.LevelLoader;
import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.Block;
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
    public Level level;

    public World()
    {
        createWorld();
    }

    public ArrayList<Entity> getEntitys() {
        return this.level.getEntitys();
    }

    public Player getPlayer() {
        return this.player;
    }

    private void createWorld() {
        level = LevelLoader.loadLevel(0);
        player = new Player(level.getSpawn(), 32, 64);
    }
}
