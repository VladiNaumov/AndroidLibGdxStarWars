package com.naumdeveloper.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.math.Rect;
import com.naumdeveloper.base.BaseScreen;
import com.naumdeveloper.sprite.Background;
import com.naumdeveloper.sprite.BulletPool;
import com.naumdeveloper.sprite.Ship;
import com.naumdeveloper.sprite.Star;


public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;

    private Texture bg;
    private Background background;

    private BulletPool bulletPool;

    private TextureAtlas atlas;
    private Star[] stars;

    // подключение класса карабля
    private Ship mainShip;

    //отрисовкка объектов
    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/mainAtlas.tpack");

        bulletPool = new BulletPool();

        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        //отрисовка карабля
        mainShip = new Ship(atlas, bulletPool);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        freeAllDestroyed();
        draw();
    }

    // позиционирование объекта
    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
        bulletPool.dispose();
    }

    // данный метод отвечает за прикосновение к экрану
    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        mainShip.touchUp(touch, pointer, button);
        return false;
    }

    // данный метод отвечает когда мы отпускаем палец с экрана
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        mainShip.touchDown(touch, pointer, button);
        return false;
    }
    //движение объекта на сцене при нажатие на клавишу
    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    // движене объекта на сцене, когда клавишу мы отпускаем
    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return false;
    }

    // обновляет экран. Это происходит 60 кадров в секунду
    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        mainShip.update(delta);
        bulletPool.updateActiveSprites(delta);
    }

    private void freeAllDestroyed() {
        bulletPool.freeAllDestroyed();
    }

    //отрисовка объектов
    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        mainShip.draw(batch);
        bulletPool.drawActiveSprites(batch);
        batch.end();
    }

}
