package se.kth.jpanegame;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
public class Vector2f
{
    private float x;
    private float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVector(Vector2f vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public void setValues(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public String toString()
    {
        return "Vector2f: " + this.x + ", " + this.y;
    }
}
