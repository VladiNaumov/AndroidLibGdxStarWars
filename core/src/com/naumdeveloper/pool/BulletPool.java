package com.naumdeveloper.pool;

import com.naumdeveloper.pool.SpritesPool;
import com.naumdeveloper.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
