package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

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
    private final float jump_speed = -10.0f;
    private boolean can_jump = true;

    public Player(Vector2f position, int width, int height, float mass, boolean dynamic) {
        super(position, width, height, mass, dynamic);
    }

    public void moveLeft()
    {
        this.setVelocity(-x_speed, this.getVelocity().getY());
    }

    public void moveRight()
    {
        this.setVelocity(x_speed, this.getVelocity().getY());
    }

    public void jump()
    {
        if(this.can_jump)
        {
            this.setVelocity(this.getVelocity().getX(), jump_speed);
            this.can_jump = false;
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

    @Override
    public void update()
    {
        super.update();
        if(this.getVelocity().getY() == 0)
            this.can_jump = true;
    }
}
