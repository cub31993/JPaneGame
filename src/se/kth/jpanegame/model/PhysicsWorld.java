package se.kth.jpanegame.model;

import se.kth.jpanegame.Vector2f;
import se.kth.jpanegame.model.entity.Box;
import se.kth.jpanegame.model.entity.CollisionFilter;
import se.kth.jpanegame.model.entity.PhysicsEntity;
import se.kth.jpanegame.model.entity.Player;

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

    public ArrayList<PhysicsEntity> getEntities()
    {
        return this.entityArrayList;
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
            if(pe1.getCollisionFilter() == CollisionFilter.PLAYER)
            {
                Player player = (Player) pe1;
                player.setCanLift(false);
            }

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
                                    //System.out.println("Collision on top!");
                                    pe1.setVelocity(pe1.getVelocity().getX(), pe1.getVelocity().getY()*-0.01f);
                                }
                                else
                                {
                                    //System.out.println("Collision on right!");
                                    if(!pe2.isDynamic())
                                    {
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.01f, pe1.getVelocity().getY());
                                    }
                                    else
                                    {
                                        pe2.setVelocity(pe2.getVelocity().getX()+pe1.getVelocity().getX(), pe2.getVelocity().getY());
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.01f, pe1.getVelocity().getY());
                                    }
                                }
                            }
                            else
                            {
                                if (wy > -hx)
                                {
                                    //System.out.println("Collision on left!");
                                    if(!pe2.isDynamic())
                                    {
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.01f, pe1.getVelocity().getY());
                                    }
                                    else
                                    {
                                        pe2.setVelocity(pe2.getVelocity().getX()+pe1.getVelocity().getX(), pe2.getVelocity().getY());
                                        pe1.setVelocity(pe1.getVelocity().getX()*-0.01f, pe1.getVelocity().getY());
                                    }
                                }
                                else
                                {
                                    //System.out.println("Collision on bottom!");
                                    pe1.setVelocity(pe1.getVelocity().getX(), 0);
                                    if(pe1.getCollisionFilter() == CollisionFilter.PLAYER)
                                        pe1.setPosition(pe1.getPosition().getX(), pe2.getPosition().getY()-pe1.getHeight());
                                }
                            }
                        }

                        if(pe1.getCollisionFilter() == CollisionFilter.PLAYER && (pe2.getCollisionFilter()==CollisionFilter.BOX || pe2.getCollisionFilter()==CollisionFilter.TORCHLIGHT))
                        {
                            checkIfPlayerCanLiftABox((Player)pe1, pe2);
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

    private void checkIfPlayerCanLiftABox(Player tmp_player, PhysicsEntity pe2)
    {
        if(!tmp_player.isLifting())
        {
            if(tmp_player.getMovingTowards() == Player.Side.LEFT)
            {
                if(checkIfPointCollides(pe2, new Vector2f(tmp_player.getPosition().getX()-16.f, tmp_player.getPosition().getY()+(tmp_player.getHeight()*2/5))) ||
                        checkIfPointCollides(pe2, new Vector2f(tmp_player.getPosition().getX()-16.f, tmp_player.getPosition().getY()+(tmp_player.getHeight()*4/5))))
                {
                    tmp_player.setCanLift(true, pe2);
                    //this.liftedBox.setDynamic(false);
                }
            }

            if(tmp_player.getMovingTowards() == Player.Side.RIGHT)
            {
                if(checkIfPointCollides(pe2, new Vector2f(tmp_player.getPosition().getX()+tmp_player.getWidth()+16.f, tmp_player.getPosition().getY()+(tmp_player.getHeight()*2/5))) ||
                        checkIfPointCollides(pe2, new Vector2f(tmp_player.getPosition().getX()+tmp_player.getWidth()+16.f, tmp_player.getPosition().getY()+(tmp_player.getHeight()*4/5))))
                {
                    tmp_player.setCanLift(true, pe2);
                    //this.liftedBox.setDynamic(false);
                }
            }
        }
    }

    public boolean checkIfPointCollides(PhysicsEntity pe, Vector2f point)
    {
        float pe_x = pe.getPosition().getX();
        float pe_xwidth = pe.getPosition().getX()+pe.getWidth();
        float pe_y = pe.getPosition().getY();
        float pe_yheight = pe.getPosition().getY()+pe.getHeight();

        if(point.getX() <= pe_xwidth && point.getX() >= pe_x)
        {
            if(point.getY() >= pe_y && point.getY() <= pe_yheight)
            {
                return true;
            }
        }
        return false;
    }
}
