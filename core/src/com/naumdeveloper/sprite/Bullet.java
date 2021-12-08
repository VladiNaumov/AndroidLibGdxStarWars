package com.naumdeveloper.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.math.Rect;
import com.naumdeveloper.base.BaseSprite;

public class Bullet extends BaseSprite {

    private final Vector2 v = new Vector2();

    private Rect worldBounds;
    private int damage;
    private BaseSprite owner;

    public Bullet() {
        regions = new TextureRegion[1];
    }

    public void set(
            BaseSprite owner,
            TextureRegion region,
            Vector2 pos,
            Vector2 v,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos);
        this.v.set(v);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public int getDamage() {
        return damage;
    }

    public BaseSprite getOwner() {
        return owner;
    }
}
