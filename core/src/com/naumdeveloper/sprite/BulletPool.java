package com.naumdeveloper.sprite;


import com.naumdeveloper.base.SpritesPool;

public class BulletPool extends SpritesPool<Bullet> {
    //
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
