package com.naumdeveloper.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.naumdeveloper.base.BaseSprite;
import com.naumdeveloper.math.Rect;

public class Background extends BaseSprite {
    public Background(Texture texture){
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
