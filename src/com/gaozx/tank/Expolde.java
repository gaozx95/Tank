package com.gaozx.tank;

import java.awt.*;

public class Expolde {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT =ResourceMgr.explodes[0].getHeight();

    int x,y;
    TankFrame tf =null;
    private int step = 0;
    public Expolde(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if(step>=ResourceMgr.explodes.length)
            step = 0;
    }
}
