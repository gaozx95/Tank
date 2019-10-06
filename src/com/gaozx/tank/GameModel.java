package com.gaozx.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    TankFrame tf;
    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    private static int initTankCount = PropertyMgr.getInt("initTankCount");
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
    {
        myTank.setMoving(false);


    }


    public GameModel(){
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(100 + i * 100, 200, Dir.DOWN, Group.BAD, this));
        }
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量"+bullets.size(),10,60);
        g.drawString("敌方坦克数量"+tanks.size(),10,80);
        g.setColor(c);
        //画坦克
        myTank.paint(g);
        //画子弹
        for (int i = 0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        for (int i = 0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }

        for (int i = 0; i< explodes.size(); i++){
            explodes.get(i).paint(g);
        }

        for(int i= 0 ;i <bullets.size();i++){
            for (int j = 0; j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }

    public Tank getMyTank() {
        return myTank;
    }
}
