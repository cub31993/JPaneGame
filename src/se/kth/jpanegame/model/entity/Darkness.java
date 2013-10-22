package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

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


    public Darkness(int width, int height)
    {
        this.rectangleSize = 32;
        this.rect_x = width/this.rectangleSize;///this.rectangleSize;
        this.rect_y = height/this.rectangleSize;///this.rectangleSize;
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(rect_x, rect_y, BufferedImage.TYPE_INT_ARGB);

        /*for(int i=0; i<rect_x; i++)
        {
            for(int j=0; j<rect_y; j++)
            {
                this.rectangles[i][j] = new Pixel(i*rectangleSize, j*rectangleSize, rectangleSize);
            }
        }  */

        this.update();
    }

    public void update()
    {
        for(int i=0; i<rect_x; i++)
        {
            for(int j=0; j<rect_y; j++)
            {

                float distance = (float)Math.hypot(Math.abs(j*this.rectangleSize - 350), Math.abs(i*this.rectangleSize-470));
                if(distance < 260)
                {
                    //g.setColor(new Color(0,0,0,distance/300));
                    this.image.setRGB(i,j, new Color(0,0,0,distance/260).getRGB());
                }
                else
                {
                    this.image.setRGB(i,j, new Color(0,0,0,1.0f).getRGB());
                    //float alpha = (float)Math.hypot(Math.abs(this.rectangles[i][j].getX() - 400), Math.abs(this.rectangles[i][j].getY()-300))/300;
                    //System.out.println("Darkness alpha ["+i+"]["+j+"]: "+1);
                }
                // g.setColor(new Color(0,0,0, 1.0f));
                //g.fillRect((int)this.rectangles[i][j].getX(), (int)this.rectangles[i][j].getY(), this.rectangleSize, this.rectangleSize);
                //System.out.println("Position ["+i+"]["+j+"]: "+(int)this.rectangles[i][j].getX() +", "+ (int)this.rectangles[i][j].getY());
            }
        }

        this.image = Assets.scale(this.image, this.rectangleSize);
    }

    public void render(Graphics g)
    {
        g.drawImage(this.image,0,0, null);
        //this.image.flush();
    }
}
