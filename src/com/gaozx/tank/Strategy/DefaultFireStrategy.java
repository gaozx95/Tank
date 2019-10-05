package com.gaozx.tank.Strategy;

import com.gaozx.tank.Bullet;
import com.gaozx.tank.Tank;

public class DefaultFireStrategy implements FireStrategy {
    private static DefaultFireStrategy dfs = new DefaultFireStrategy();
    private DefaultFireStrategy() {
    }

    public static DefaultFireStrategy getInstance(){
        return dfs;
    }
    @Override
    public void fire(Tank t) {
        int bx = t.getX() + (Tank.WIDTH - Bullet.HEIGHT)/2;
        int by = t.getY() + (Tank.HEIGHT - Bullet.HEIGHT)/2;
        new Bullet(bx,by,t.getDir(),t.getGroup(),t.getTf());
    }
}
