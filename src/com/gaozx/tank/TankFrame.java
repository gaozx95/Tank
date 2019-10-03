package com.gaozx.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    //坦克方向
    boolean bL = false;
    boolean bU = false;
    boolean bR = false;
    boolean bD = false;

    public TankFrame() throws HeadlessException {
        setSize(800,600);
        setResizable(false);
        setTitle("Tank War");

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }
    //paint 方法自动调用
    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        if (bL){
            x -= 10;
            if(bD){
                y += 10;
            }
            if(bU){
                y -= 10;
            }
        }
        if (bU){
            y -= 10;
            if(bR){
                x += 10;
            }
            if(bL){
                x -= 10;
            }
        }
        if (bR){
            x += 10;
            if(bU){
                y -= 10;
            }
            if(bD){
                y += 10;
            }
        }
        if (bD){
            y += 10;
            if(bR){
                x += 10;
            }
            if(bL){
                x -= 10;
            }
        }

//        x += 50;
//        y += 10;

    }

    class MyKeyListener extends KeyAdapter{


        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
        }
    }

}
