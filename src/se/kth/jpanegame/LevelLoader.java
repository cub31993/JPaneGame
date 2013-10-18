package se.kth.jpanegame;

import se.kth.jpanegame.model.Level;
import se.kth.jpanegame.model.entity.Block;

/**
 * Created with IntelliJ IDEA.
 * User: Fredrik
 * Date: 2013-10-18
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public class LevelLoader {

    public static Level loadLevel(int nr) {
        Level level = new Level();

        int w = 60;
        int h = 20;

        int[] pixels = new int[w * h];
        byte[] blocks = new byte[w * h];

        Assets.level.getRGB(nr * w, nr * h, w, h, pixels, 0, w);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                int pixel = pixels[x + y * w] & 0xffffff;
                byte block = 0;

                if(pixel == 0xffffff) block = 0;
                else if(pixel == 0x000000) block = 1;
                else if(pixel == 0xB6FF00) {
                    level.setSpawn(x * 32, y * 32 - 40);  //spelare spawnar lite över marken
                }
                blocks[x + y * w] = block;
            }
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                byte block = blocks[x + y * w];

                if(block == 1) {
                    level.getEntitys().add(new Block(new Vector2f(x, y), 32, 32));
                }
            }
        }


       /* // Loading the png into a Pixmap

        // creating the backing blocks array
        Block[][] blocks = new Block[level.getWidth()][level.getHeight()];
        for (int col = 0; col < level.getWidth(); col++) {
            for (int row = 0; row < level.getHeight(); row++) {
                blocks[col][row] = null;
            }
        }


        for (int row = 0; row < level.getHeight(); row++) {
            for (int col = 0; col < level.getWidth(); col++) {
                int pixel = (pixmap.getPixel(col, row) >>> 8) & 0xffffff;
                int iRow = level.getHeight() - 1 - row;
                if (pixel == BLOCK) {
                    // adding a block
                    blocks[col][iRow] = new Block(new Vector2(col, iRow));
                } else if (pixel == START_POS) {
                    level.setSpanPosition(new Vector2(col, iRow));
                }
            }
        }

        // setting the blocks
        level.setBlocks(blocks);   */
        return level;
    }
}
