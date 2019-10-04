package com.gaozx.tank;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i =0 ;i<5 ;i++){
            tf.tanks.add(new Tank(100+i*40,100,Dir.DOWN,Group.BAD,tf));
        }

        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
            tf.repaint();
        }
    }
}
