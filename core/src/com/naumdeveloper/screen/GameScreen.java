package com.naumdeveloper.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.math.Rect;
import com.naumdeveloper.base.BaseScreen;
import com.naumdeveloper.sprite.Background;
import com.naumdeveloper.sprite.Chip;
import com.naumdeveloper.sprite.Star;


public class GameScreen extends BaseScreen {


    private Texture bg;
    private Texture img;


    private Chip logo;

    private Background background;


    private static final int STAR_COUNT = 256;
   // private final Game game;

    private TextureAtlas atlas;
    private Star[] stars;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        img = new Texture("textures/chip.png");
        logo = new Chip(img);

        atlas = new TextureAtlas("textures/menuAtlas.tpack");



        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }

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
        atlas.dispose();
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

        for (Star star : stars) {
            star.resize(worldBounds);
        }
    }

    private void update(float delta){
        logo.update(delta);
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw(){
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {

            star.draw(batch);

        }
        logo.draw(batch);
        batch.end();
    }

}
