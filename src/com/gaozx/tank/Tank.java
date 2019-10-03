package com.gaozx.tank;

import java.awt.*;

public class Tank {
    private int x ,y;
    private Dir dir;
    private boolean moving = false;
    private static final int SPEED = 5;
    private static final int WIDTH = 50,HEIGHT = 50;
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
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
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x,y,WIDTH,HEIGHT);
        g.setColor(c);
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
        tf.bullets.add(new Bullet(this.x+WIDTH/2,this.y+HEIGHT/2,this.dir,this.tf));
    }
}
