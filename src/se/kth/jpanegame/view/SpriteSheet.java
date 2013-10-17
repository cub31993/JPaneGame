package se.kth.jpanegame.view;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-17
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */

import java.awt.image.BufferedImage;

public class SpriteSheet {
    public int width, height;
    public int[] pixels;

    public SpriteSheet(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);
        for (int i = 0; i < pixels.length; i++) {

            pixels[i] = (pixels[i] & 0xff) / 64;
        }
    }
}
