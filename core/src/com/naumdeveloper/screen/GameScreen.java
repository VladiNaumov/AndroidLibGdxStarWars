package com.naumdeveloper.screen;

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

    private Chip chip;

    private Background background;

    private static final int STAR_COUNT = 256;

    private TextureAtlas atlas;
    private Star[] stars;

    //
    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        img = new Texture("textures/chip.png");
        chip = new Chip(img);

        atlas = new TextureAtlas("textures/menuAtlas.tpack");

        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }

    }

    //
    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    //
    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        img.dispose();
        atlas.dispose();
    }

    // передача событий
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        chip.touchDown(touch, pointer, button);
        return false;
    }

    // позиционирование объекта
    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);

        // размер объкта
        chip.resize(worldBounds);

        for (Star star : stars) {
            star.resize(worldBounds);
        }
    }

    // движение объекта
    private void update(float delta){
        chip.update(delta);
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
        chip.draw(batch);
        batch.end();
    }

}
