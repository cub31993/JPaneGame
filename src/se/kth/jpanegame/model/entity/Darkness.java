package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-22
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class Darkness {
    private int rectangleSize;
    private int rect_x;
    private int rect_y;
    private int width;
    private int height;
    private BufferedImage image;
    private int updateClock;


    public Darkness(int width, int height)
    {
        this.rectangleSize = 20;
        this.rect_x = width/this.rectangleSize;///this.rectangleSize;
        this.rect_y = height/this.rectangleSize;///this.rectangleSize;
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(rect_x, rect_y, BufferedImage.TYPE_INT_ARGB);
        this.updateClock = 0;

        /*for(int i=0; i<rect_x; i++)
        {
            for(int j=0; j<rect_y; j++)
            {
                this.rectangles[i][j] = new Pixel(i*rectangleSize, j*rectangleSize, rectangleSize);
            }
        }  */
    }

    public void update(ArrayList<Entity> lights)
    {
        if(updateClock == 0)
        {
            this.image = new BufferedImage(rect_x, rect_y, BufferedImage.TYPE_INT_ARGB);

            for(int i=0; i<rect_x; i++)
            {
                for(int j=0; j<rect_y; j++)
                {

                    this.image.setRGB(i,j, new Color(0,0,0,1.0f).getRGB());
                    /*float distance = (float)Math.hypot(Math.abs(j*this.rectangleSize - 350), Math.abs(i*this.rectangleSize-470));
                    if(distance < 240)
                    {
                        //g.setColor(new Color(0,0,0,distance/300));
                        this.image.setRGB(i,j, new Color(0,0,0,distance/240).getRGB());
                    }
                    else
                    {
                        this.image.setRGB(i,j, new Color(0,0,0,1.0f).getRGB());
                        //float alpha = (float)Math.hypot(Math.abs(this.rectangles[i][j].getX() - 400), Math.abs(this.rectangles[i][j].getY()-300))/300;
                        //System.out.println("Darkness alpha ["+i+"]["+j+"]: "+1);                                              t
                    }*/

                    for(Entity light:lights)
                    {
                        Light tmp_light = (Light)light;
                        if(light.getPosition().getX() > -400 && light.getPosition().getX() < this.width+400)
                        {
                            if(light.getPosition().getY() > -400 && light.getPosition().getY() < this.height+400)
                            {
                                float distance1 = (float)Math.hypot(Math.abs(j*this.rectangleSize - light.getPosition().getY()), Math.abs(i*this.rectangleSize-light.getPosition().getX()));
                                float maxdistance = tmp_light.getSize()+(float)(Math.random()*50.f);
                                if(distance1 < maxdistance)
                                {
                                    int color2 =this.image.getRGB(i,j);
                                    Color color = new Color(color2);
                                    int alpha = (color2 >> 24) & 0xFF;
                                    if(color.getRed() != 0.0f)  //
                                    {
                                        this.image.setRGB(i,j, new Color(0.3f*(distance1/maxdistance),0.2f*(distance1/maxdistance), 0, 0.1f+(alpha/1024.f)).getRGB());
                                    }
                                    else
                                    {
                                        this.image.setRGB(i,j, new Color(0.3f-0.3f*(distance1/maxdistance),.2f-.2f*(distance1/maxdistance),0,distance1/maxdistance).getRGB());
                                    }
                                }

                            }
                        }
                    }
                    // g.setColor(new Color(0,0,0, 1.0f));
                    //g.fillRect((int)this.rectangles[i][j].getX(), (int)this.rectangles[i][j].getY(), this.rectangleSize, this.rectangleSize);
                    //System.out.println("Position ["+i+"]["+j+"]: "+(int)this.rectangles[i][j].getX() +", "+ (int)this.rectangles[i][j].getY());
                }
            }
            this.image = Assets.scale(this.image, this.rectangleSize);
        }

        updateClock++;
        if(updateClock>=5)
            updateClock=0;
    }

    public void render(Graphics g)
    {
        g.drawImage(this.image,0,0, null);
    }
}
