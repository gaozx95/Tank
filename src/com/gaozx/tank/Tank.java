package com.gaozx.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    Rectangle rect = new Rectangle();

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
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
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
                g.drawImage(this.group.equals(Group.BAD)? ResourceMgr.badTankL:ResourceMgr.goodTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group.equals(Group.BAD)? ResourceMgr.badTankU:ResourceMgr.goodTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group.equals(Group.BAD)? ResourceMgr.badTankR:ResourceMgr.goodTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group.equals(Group.BAD)? ResourceMgr.badTankD:ResourceMgr.goodTankD, x, y, null);
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
        if(group==Group.BAD && random.nextInt(50) > 42){
            this.fire();
            randomDir();
        }

        boundsCheck();
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }
    //边界检测
    private void boundsCheck() {
        if(this.x < 5) x = 5;
        if(this.y < 30) y = 30;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 5) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 5 ;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 5) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 5;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];

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
