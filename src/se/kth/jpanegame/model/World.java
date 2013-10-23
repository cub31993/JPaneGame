package se.kth.jpanegame.model;

import se.kth.jpanegame.Camera;
import se.kth.jpanegame.LevelLoader;
import se.kth.jpanegame.Strings;
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
    private HUD hud;

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

    public HUD getHUD()
    {
        return this.hud;
    }

    private void createWorld() {
        this.physicsWorld = new PhysicsWorld();
        level = LevelLoader.loadLevel(0);  // hämtar level 0 dvs x = 0 * 25; y = 0 * 60; från bilden levels.png
        player = new Player(level.getSpawn(), 32, 64, 2, true); // skapar spelaren i världen på spawn position angivet i bilden med en gulpixel
        level.getEntitys().add(player);
        level.getEntitys().add(new Box(new Vector2f(100, 0), 32, 32));
        level.getEntitys().add(new Box(new Vector2f(100, -40), 32, 32));
        level.getEntitys().add(new Box(new Vector2f(100, -100), 32, 32));
        Torchlight light = new Torchlight(new Vector2f(100, 500), 8, 32);
        level.getEntitys().add(light);

        Torchlight light1 = new Torchlight(new Vector2f(330, 0), 8, 32);
        level.getEntitys().add(light1);
        Torchlight light2 = new Torchlight(new Vector2f(530, -200), 8, 32);
        level.getEntitys().add(light2);

        for(Entity e: level.getEntitys())
        {
            this.physicsWorld.addEntity((PhysicsEntity) e);
        }

        Light ljus = light.getLight();
        level.getEntitys().add(ljus);
        level.getLightList().add(ljus);

        Light ljus1 = light1.getLight();
        level.getEntitys().add(ljus1);
        level.getLightList().add(ljus1);

        Light ljus2 = light2.getLight();
        level.getEntitys().add(ljus2);
        level.getLightList().add(ljus2);



        this.hud = new HUD(360, 280);
        this.hud.setTextWithFadeout(Strings.MOVEMENT_TIPS, 2, 200);
    }
}
