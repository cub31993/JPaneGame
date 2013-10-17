package se.kth.jpanegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: marek
 * Date: 2013-10-16
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public class Window extends JPanel implements ActionListener
{
    private JFrame frame;
    private World world;
    private Timer timer;
    private Camera camera;

    public Window(int width, int height, String name, World world)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.lightGray);

        this.frame = new JFrame(name);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.add(this);
        this.frame.pack();
        this.frame.setVisible(true);

        this.world = world;
        this.camera = new Camera();
    }


    //TODO: Ändra till vanligt gameloop ist.
    public void startAnimation() {
        // Create, and start, the timer-object responsible for the animation
        timer = new Timer(33, this); // Signal every 10 milliseconds
        // (actionPerformed is called)
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
         this.camera.setPosition(this.camera.getX()+1, this.camera.getY());
         this.camera.updateView(this.world.getEntities());
         repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int i=0; i<world.getEntities().size(); i++)
        {
            this.world.getEntity(i).render(g);
        }
    }
}
