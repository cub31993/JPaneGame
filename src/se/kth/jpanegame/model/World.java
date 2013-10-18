package se.kth.jpanegame.model;

import se.kth.jpanegame.Camera;
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
        level = LevelLoader.loadLevel(0);  // hämtar level 0 dvs x = 0 * 25; y = 0 * 60; från bilden levels.png
        player = new Player(level.getSpawn(), 32, 64, 2); // skapar spelaren i världen på spawn position angivet i bilden med en gulpixel
        level.getEntitys().add(player);
    }
}
