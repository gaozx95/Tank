package com.gaozx.tank;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        //初始化敌方坦克
       // GameModel gm = new GameModel();

        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
            tf.repaint();
        }
    }
}
