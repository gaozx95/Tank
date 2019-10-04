package com.gaozx.tank;

import java.awt.*;

public class Tank {
    private int x ,y;
    private Dir dir;
    private boolean moving = false;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.tankD.getWidth(),HEIGHT = ResourceMgr.tankD.getHeight();
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        //画图片
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

        move();

    }

    private void move() {
        if(!isMoving()) return;
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bx = this.x + (Tank.WIDTH - Bullet.HEIGHT)/2;
        int by = this.y + (Tank.HEIGHT - Bullet.HEIGHT)/2;
        tf.bullets.add(new Bullet(bx,by,this.dir,this.tf));
    }
}
