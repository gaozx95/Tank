package com.gaozx.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private static final int SPEED = 1;
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();

    private int x ,y;
    private Dir dir = Dir.DOWN;
    private Random random = new Random();

    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        if(!living){
            tf.tanks.remove(this);
        }
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
        if(!isMoving()){
            return;
        }
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
        if(group==Group.BAD && random.nextInt(10) > 8){
            this.fire();
            randomDir();
        }
        if(x<0 || y<0 || x > TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT)
            living = false;
    }

    private void randomDir() {
        int d = random.nextInt(4);
        switch (d){
            case 1:
                dir = Dir.LEFT;
                break;
            case 2:
                dir = Dir.UP;
                break;
            case 3:
                dir = Dir.RIGHT;
                break;
            case 4:
                dir = Dir.DOWN;
                break;
        }

    }

    public void fire() {
        int bx = this.x + (Tank.WIDTH - Bullet.HEIGHT)/2;
        int by = this.y + (Tank.HEIGHT - Bullet.HEIGHT)/2;
        tf.bullets.add(new Bullet(bx,by,this.dir,this.group,this.tf));
    }

    public void die() {
        this.living = false;
    }
}
