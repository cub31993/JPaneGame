package se.kth.jpanegame.model;

import se.kth.jpanegame.Camera;
import se.kth.jpanegame.LevelLoader;
import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.*;

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
    private PhysicsWorld physicsWorld;
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

    public PhysicsWorld getPhysicsWorld()
    {
        return this.physicsWorld;
    }

    private void createWorld() {
        this.physicsWorld = new PhysicsWorld();
        level = LevelLoader.loadLevel(0);  // hämtar level 0 dvs x = 0 * 25; y = 0 * 60; från bilden levels.png
        player = new Player(level.getSpawn(), 32, 64, 2, true); // skapar spelaren i världen på spawn position angivet i bilden med en gulpixel
        level.getEntitys().add(player);
        level.getEntitys().add(new Box(new Vector2f(100, 0), 32, 32));
        level.getEntitys().add(new Box(new Vector2f(600, 0), 32, 32));

        for(Entity e: level.getEntitys())
        {
            this.physicsWorld.addEntity((PhysicsEntity) e);
        }
    }
}
