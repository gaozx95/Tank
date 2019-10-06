package com.gaozx.tank;

import java.awt.*;

public class Bullet {
    public static final int SPEED = PropertyMgr.getInt("bulletSpeed");

    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT =ResourceMgr.bulletD.getHeight();


    Rectangle rect = new Rectangle();

    private Group group = Group.BAD;
    private int x,y;
    private Dir dir;
    private boolean living = true;
    private GameModel gm;

    public Bullet(int x, int y, Dir dir,Group group,GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.bullets.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!living){
            gm.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();

    }

    private void move() {
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
        if(x<0 || y<0 || x > TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT)
            living = false;

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;

        //TODO：用一个rect记录子弹的位置

        if(this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int ex = tank.getX() + (Tank.WIDTH - Explode.WIDTH) / 2;
            int ey = tank.getY() + (Tank.HEIGHT - Explode.HEIGHT) / 2;
            gm.explodes.add(new Explode(ex, ey, this.gm));
        }
    }

    private void die() {
        this.living = false;
    }
}
