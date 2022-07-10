package com.msb.tanKe;

import java.awt.*;

/**
 * @author Li
 * @version 1.0
 * @ClassName Bullet
 * @Date 2022/7/8 0008 17:59
 */
public class Bullet {
    private static final int SPEED = 7;
    private static int WIDTH = 30, HEIGHT = 30;

    private boolean live = true;//子弹存活状态   出边界死亡
    private int x, y;
    private Dir dir;
    private  TankFrame tf = null;

    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;


    }
}
