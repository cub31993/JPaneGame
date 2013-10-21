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
        updateGravity();
        checkCollisions();
        updateAll();
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
            if(pe1.isDynamic() && !pe1.isUpdated())
            {
                for(PhysicsEntity pe2: this.entityArrayList)
                {
                    if(pe1 != pe2)
                    {
                        /*float pe1_x1 = pe1.getPosition().getX()+pe1.getVelocity().getX();
                        float pe1_x2 = pe1_x1 + pe1.getWidth();
                        float pe1_y2 = pe1.getPosition().getY()+pe1.getVelocity().getY();
                        float pe1_y1 = pe1_y2 + pe1.getHeight();


                        float pe2_x1 = pe2.getPosition().getX()+pe2.getVelocity().getX();
                        float pe2_x2 = pe2_x1 + pe2.getWidth();
                        float pe2_y1 = pe2.getPosition().getY()+pe2.getVelocity().getY();
                        float pe2_y2 = pe2_y1 + pe2.getHeight();*/

                        /*System.out.println("p1 x1: "+pe1_x1);
                        System.out.println("p1 x2: "+pe1_x2);
                        System.out.println("p1 y1: "+pe1_y1);
                        System.out.println("p1 y2: "+pe1_y2);

                        System.out.println("p2 x1: "+pe2_x1);
                        System.out.println("p2 x2: "+pe2_x2);
                        System.out.println("p2 y1: "+pe2_y1);
                        System.out.println("p2 y2: "+pe2_y2);*/

                        float width = 0.5f * (pe1.getWidth()+pe2.getWidth());
                        float height = 0.5f * (pe1.getHeight()+pe2.getHeight());
                        float dx =  (pe1.getPosition().getX()+pe1.getVelocity().getX()+(pe1.getWidth()/2)) - (pe2.getPosition().getX()+pe2.getVelocity().getX()+(pe2.getWidth()/2));
                        float dy = (pe1.getPosition().getY()+pe1.getVelocity().getY()+(pe1.getHeight()/2)) - (pe2.getPosition().getY()+pe2.getVelocity().getY()+(pe2.getHeight()/2));

                        if (Math.abs(dx) <= width && Math.abs(dy) <= height)
                        {
    /* collision! */
                            float wy = width * dy;
                            float hx = height * dx;

                            if (wy > hx)
                            {
                                if (wy > -hx)
                                {
                                    System.out.println("Collision on top!");
                                    pe1.setVelocity(0, 0);
                                }
                                else
                                {
                                    System.out.println("Collision on right!");
                                    if(!pe2.isDynamic())
                                    {
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.001f, pe1.getVelocity().getY());
                                    }
                                    else
                                    {
                                        pe2.setVelocity(pe2.getVelocity().getX()+pe1.getVelocity().getX(), pe2.getVelocity().getY());
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.001f, pe1.getVelocity().getY());
                                    }
                                }
                            }
                            else
                            {
                                if (wy > -hx)
                                {
                                    System.out.println("Collision on left!");
                                    if(!pe2.isDynamic())
                                    {
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.001f, pe1.getVelocity().getY());
                                    }
                                    else
                                    {
                                        pe2.setVelocity(pe2.getVelocity().getX()+pe1.getVelocity().getX(), pe2.getVelocity().getY());
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.001f, pe1.getVelocity().getY());
                                    }
                                }
                                else
                                {
                                    System.out.println("Collision on bottom!");
                                    pe1.setVelocity(pe1.getVelocity().getX(), 0);
                                    //pe1.setPosition(pe1.getPosition().getX(), pe2.getPosition().getY()-pe1.getHeight());
                                }
                            }
                        }
                    }
                }

                pe1.setUpdated(true);
            }
        }
    }

    private void updateAll()
    {
        for(PhysicsEntity pe: this.entityArrayList)
        {
            if(pe.isUpdated())
            {
                pe.update();
                pe.setUpdated(false);
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
