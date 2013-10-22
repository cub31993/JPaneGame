package se.kth.jpanegame.model.entity;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-21
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class HUD
{
    private String hint;
    private Timer timer, alphaTimer;
    private float x, y;
    private float alpha;
    private boolean ready;

    public HUD(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.alpha = 1.0f;
        this.ready = true;
    }

    public void setText(String text)
    {
        this.hint = text;
    }

    public void setTextWithTimeout(String text, int timeout)
    {
        if(this.ready)
        {
            this.alpha = 1.0f;
            this.ready = false;
            this.hint = text;
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    hint = " ";
                    ready = true;
                    alpha = 0;
                }
            }, timeout*1000);
        }
    }

    public void setTextWithTimeout(String text, int timeout, float galpha)
    {
        if(this.ready)
        {
            this.alpha = galpha;
            this.ready = false;
            this.hint = text;
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    hint = " ";
                    ready = true;
                    alpha = 0;
                }
            }, timeout*1000);
        }
    }

    public void showText(String text)
    {
        if(this.ready)
        {
            this.alpha = 1.0f;
            this.hint = text;
        }
    }

    public void setTextWithFadeout(String text, int timeout, int speedInMS)
    {
        if(this.ready)
        {
            this.ready = false;
            this.alpha = 1.0f;
            this.hint = text;
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(alpha<0)
                    {
                        timer.cancel();
                        timer.purge();
                        ready = true;
                        return;
                    }
                    else
                    {
                        alpha -= 0.05f;
                    }

                }
            }, timeout*1000, speedInMS);
        }
    }

    public String getText()
    {
        return this.hint;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(1,1,1, this.alpha));
        g.fillRect((int)this.x-10, (int)this.y-20, this.hint.length()*8, 30);
        g.setColor(new Color(0,0,0, this.alpha));
        g.drawString(this.hint, (int)this.x, (int)this.y);
    }
}
