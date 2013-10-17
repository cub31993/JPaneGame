package se.kth.jpanegame;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
public class Game
{
    public static void main(String[] args)
    {
        Window window = new Window(800,600,"Hej!", initWorld());
        window.startAnimation();
    }

    public static World initWorld()
    {
        World world = new World();

        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                Vector2f position = new Vector2f(i*90, j*90);
                world.addEntity(new Box(position, 30, 30));
            }
        }

        return world;
    }
}
