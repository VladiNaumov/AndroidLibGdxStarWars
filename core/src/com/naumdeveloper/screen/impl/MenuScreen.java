package com.naumdeveloper.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.math.Rect;
import com.naumdeveloper.screen.BaseScreen;
import com.naumdeveloper.sprite.Logo;
import com.naumdeveloper.sprite.impl.Background;


public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 1.5f;

    private Texture bg;
    private Texture img;
    private Vector2 pos;
    private Logo logo;

    private Background background;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        img = new Texture("ball.png");
        logo = new Logo(img);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    private void update(float delta){
        logo.update(delta);
    }

    private void draw(){
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }
}

