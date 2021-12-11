package com.naumdeveloper.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.base.BaseScreen;
import com.naumdeveloper.math.Rect;
import com.naumdeveloper.sprite.Background;
import com.naumdeveloper.sprite.ButtonExit;
import com.naumdeveloper.sprite.ButtonPlay;
import com.naumdeveloper.sprite.Star;

public class MenuScreen extends BaseScreen {
///
    private final Game game;

    private static final int STAR_COUNT = 256;
    private static final float V_LEN = 1.5f;

    private TextureAtlas atlas;
    private Texture bg;

    private Background background;
    private Star stars[];


    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++){
            stars[i] = new Star(atlas);
        }

        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for(Star star: stars){
            star.resize(worldBounds);
        }

        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
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
        atlas.dispose();
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta){
        for(Star star: stars){
            star.update(delta);
        }
    }

    private void draw(){
        batch.begin();
        background.draw(batch);
        for(Star star: stars){
            star.draw(batch);
        }

        buttonExit.draw(batch);
        buttonPlay.draw(batch);

        batch.end();
    }


}
