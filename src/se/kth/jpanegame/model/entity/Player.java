package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-17
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class Player extends PhysicsEntity
{
    private final float x_speed = 3.0f;
    private final float jump_speed = -8.0f;
    private boolean can_jump = true;
    private Side movingTowards = Side.RIGHT;
    private boolean lifting = false;
    private boolean canLift = false;
    private Box liftedBox = null;

    public Player(Vector2f position, int width, int height, float mass, boolean dynamic) {
        super(position, width, height, mass, dynamic);
        this.setColor(Color.orange);
        this.setCollisionFilter(CollisionFilter.PLAYER);
    }

    public void moveLeft()
    {
        this.setVelocity(-x_speed, this.getVelocity().getY());
        movingTowards = Side.LEFT;
    }

    public void moveRight()
    {
        this.setVelocity(x_speed, this.getVelocity().getY());
        movingTowards = Side.RIGHT;
    }

    public void jump()
    {
        if(this.can_jump)
        {
            this.setVelocity(this.getVelocity().getX(), jump_speed);
            this.can_jump = false;
        }
    }

    public void liftAnBox(ArrayList<PhysicsEntity> peList)
    {
        if(!this.lifting && this.canLift)
        {
            /*for(PhysicsEntity pe: peList)
            {
                if(pe.getCollisionFilter() == CollisionFilter.BOX)
                {
                    if(this.movingTowards == Side.LEFT)
                    {
                        if(checkIfPointCollides(pe, new Vector2f(this.getPosition().getX()-16.f, this.getPosition().getY()+(this.getHeight()/2))))
                        {
                            this.lifting = true;
                            this.liftedBox = (Box)pe;
                            //this.liftedBox.setDynamic(false);
                        }
                    }
                    else if(this.movingTowards == Side.RIGHT)
                    {
                        if(checkIfPointCollides(pe, new Vector2f(this.getPosition().getX()+this.getWidth()+16.f, this.getPosition().getY()+(this.getHeight()/2))))
                        {
                            this.lifting = true;
                            this.liftedBox = (Box)pe;
                            //this.liftedBox.setDynamic(false);
                        }
                    }
                }
            }*/
            this.lifting = true;
        }
        else
        {
            this.lifting = false;
            this.canLift = false;
            //this.liftedBox.setDynamic(true);
            this.liftedBox = null;
        }
    }

    public boolean canJump()
    {
        return this.can_jump;
    }

    public void setCanJump(boolean jump)
    {
        this.can_jump = jump;
    }

    public Side getMovingTowards()
    {
        return this.movingTowards;
    }

    public void setCanLift(boolean lift, Box box)
    {
        this.canLift = lift;
        this.liftedBox = box;
    }

    public void setCanLift(boolean lift)
    {
        this.canLift = lift;
    }

    public boolean getCanLift()
    {
        return this.canLift;
    }

    public boolean isLifting()
    {
        return this.lifting;
    }

    @Override
    public void update()
    {
        super.update();
        if(this.getVelocity().getY() == 0)
            this.can_jump = true;

        if(this.lifting)
        {
            if(this.movingTowards == Side.LEFT)
                this.liftedBox.setPosition(this.getPosition().getX()-(liftedBox.getWidth()+2),this.getPosition().getY()+(this.getWidth()/2));
            else if(this.movingTowards == Side.RIGHT)
                this.liftedBox.setPosition(this.getPosition().getX()+(liftedBox.getWidth()+2),this.getPosition().getY()+(this.getWidth()/2));

            this.liftedBox.setVelocity(this.liftedBox.getVelocity().getX(),0.0f);
        }
    }

    public enum Side
    {
        RIGHT, LEFT
    }
}
