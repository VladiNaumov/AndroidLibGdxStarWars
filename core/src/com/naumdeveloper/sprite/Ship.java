package com.naumdeveloper.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.naumdeveloper.base.BaseSprite;
import com.naumdeveloper.math.Rect;


public class Ship extends BaseSprite {
    // вектор скорости (для движения нашего карабля)
    protected  Vector2 v;
    // Вектор направления объекта
    protected  Vector2 v0;

    protected  BulletPool bulletPool;
    protected  TextureRegion bulletRegion;
    protected  Vector2 bulletV;
    protected  float bulletHeight;
    protected  int damage;
    protected Sound bulletSound;

    protected Rect worldBounds;

    protected float reloadTimer;
    protected float reloadInterval;

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);

    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer+=delta;

        if(reloadTimer > reloadInterval){
            reloadTimer = 0f;

            //Метод стрельбы
            shoot();
        }
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
    }

}
