package se.kth.jpanegame.model.entity;

import se.kth.jpanegame.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-18
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */

public class Block extends PhysicsEntity {

    public Block (Vector2f position, int width, int height) {
        super(new Vector2f(position.getX() * 32, position.getY() * 32), width, height, 0, false);
        this.createRectangle();
        this.getRectangle().setBounds((int)position.getX(), (int)position.getY(), width, height);
    }
}
