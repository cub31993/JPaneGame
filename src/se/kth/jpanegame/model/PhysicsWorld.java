package se.kth.jpanegame.model;

import se.kth.jpanegame.model.entity.PhysicsEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-19
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public class PhysicsWorld
{
    private float gravity;
    private ArrayList<PhysicsEntity> entityArrayList;

    public PhysicsWorld()
    {
        this.gravity = 0.3f;
        this.entityArrayList = new ArrayList<PhysicsEntity>();
    }

    public void addEntity(PhysicsEntity entity)
    {
        this.entityArrayList.add(entity);
    }

    public PhysicsEntity getEntity(int i)
    {
        return this.entityArrayList.get(i);
    }

    public void removeEntity(int i)
    {
        this.entityArrayList.remove(i);
    }

    public void removeEntity(PhysicsEntity entity)
    {
        this.entityArrayList.remove(entity);
    }

    public void update()
    {
        //updateGravity();
        checkCollisions();
        updateGravity();
    }

    private void updateGravity()
    {
        for(PhysicsEntity e:this.entityArrayList)
        {
            if(e.isDynamic())
            {
                e.setVelocity(e.getVelocity().getX(), e.getVelocity().getY()+this.gravity);
                //e.update();
            }
        }
    }

    private void checkCollisions()
    {
        for(PhysicsEntity pe1: this.entityArrayList)
        {
            if(pe1.isDynamic())
            {
                for(PhysicsEntity pe2: this.entityArrayList)
                {
                    if(pe1 != pe2)
                    {
                        float pe1_x1 = pe1.getPosition().getX()+pe1.getVelocity().getX();
                        float pe1_x2 = pe1_x1 + pe1.getWidth();
                        float pe1_y2 = pe1.getPosition().getY()+pe1.getVelocity().getY();
                        float pe1_y1 = pe1_y2 + pe1.getHeight();


                        float pe2_x1 = pe2.getPosition().getX()+pe2.getVelocity().getX();
                        float pe2_x2 = pe2_x1 + pe2.getWidth();
                        float pe2_y1 = pe2.getPosition().getY()+pe2.getVelocity().getY();
                        float pe2_y2 = pe2_y1 + pe2.getHeight();

                        /*System.out.println("p1 x1: "+pe1_x1);
                        System.out.println("p1 x2: "+pe1_x2);
                        System.out.println("p1 y1: "+pe1_y1);
                        System.out.println("p1 y2: "+pe1_y2);

                        System.out.println("p2 x1: "+pe2_x1);
                        System.out.println("p2 x2: "+pe2_x2);
                        System.out.println("p2 y1: "+pe2_y1);
                        System.out.println("p2 y2: "+pe2_y2);*/

                        boolean bottom = false;

                        if(pe1_x2 >= pe2_x1 && pe1_x1 <= pe2_x2)
                        {
                            if((pe1_y2 <= pe2_y1 && pe1_y1 >= pe2_y1) && pe1.getVelocity().getY() > 0)
                            {
                                pe1.setVelocity(pe1.getVelocity().getX(), 0);
                                //pe1.setPosition(pe1.getPosition().getX(), pe2_y1-pe1.getHeight());
                                System.out.println("bottom");
                                bottom = true;
                            }
                            /*if((pe1_y2 >= pe2_y1 && pe1_y2 <= pe1_y2))
                            {
                                //pe1.setPosition(pe1.getPosition().getX(), pe2_y1-pe1.getHeight());
                                pe1.setVelocity(pe1.getVelocity().getX(), 0);
                            }*/
                        }


                        if((pe1_x2 >= pe2_x1 && pe1_x1 <= pe2_x1) && ((pe1_y2 <= pe2_y1 && pe1_y1 >= pe2_y2) || ((pe1_y1 > pe2_y1 && pe1_y2 < pe2_y2) && !bottom)))
                        {
                            pe1.setVelocity(0, pe1.getVelocity().getY());
                            System.out.println("right");
                        }

                        if((pe1_x1 <= pe2_x2 && pe1_x2 >= pe2_x2) && (pe1_y2 <= pe2_y1 && pe1_y1 >= pe2_y2))
                        {
                            pe1.setVelocity(0, pe1.getVelocity().getY());
                            System.out.println("left");
                        }


                    }

                    //pe1.update();
                }
                pe1.update();
            }
        }
    }

    private boolean collidesLeft(PhysicsEntity pe1, PhysicsEntity pe2)
    {
        if(pe1.getPosition().getX() <= pe2.getPosition().getX()+pe2.getWidth())
            return true;
        return false;
    }

    private boolean collidesTop(PhysicsEntity pe1, PhysicsEntity pe2)
    {
        if(pe1.getPosition().getY()+pe1.getHeight() >= pe2.getPosition().getY())
            return true;
        return false;
    }

    private boolean collidesRight(PhysicsEntity pe1, PhysicsEntity pe2)
    {
        if(pe1.getPosition().getX()+pe1.getWidth() >= pe2.getPosition().getX())
            return true;
        return false;
    }

    private boolean collidesBottom(PhysicsEntity pe1, PhysicsEntity pe2)
    {
        if(pe1.getPosition().getY() <= pe2.getPosition().getY()+pe2.getHeight())
            return true;
        return false;
    }
}
