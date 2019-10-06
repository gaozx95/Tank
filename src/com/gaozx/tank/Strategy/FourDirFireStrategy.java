package com.gaozx.tank.Strategy;

import com.gaozx.tank.Bullet;
import com.gaozx.tank.Dir;
import com.gaozx.tank.Tank;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx = t.getX() + (Tank.WIDTH - Bullet.HEIGHT)/2;
        int by = t.getY() + (Tank.HEIGHT - Bullet.HEIGHT)/2;

        Dir[] dirs = Dir.values();
        for (Dir d :dirs){
            new Bullet(bx,by,d,t.getGroup(),t.getGm());
        }
    }
}
