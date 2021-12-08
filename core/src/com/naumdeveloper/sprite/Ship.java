package com.naumdeveloper.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.naumdeveloper.base.BaseSprite;
import com.naumdeveloper.math.Rect;



public class Ship extends BaseSprite {

    // размер объекта
    private static final float HEIGHT = 0.15f;

    // отступ от нижнего края
    private static final float BOTTOM_MARGIN = 0.05f;

    //
    private static final int INVALID_POINTER = -1;

    // вектор скорости (для движения нашего карабля)
    private final Vector2 v;

    // Вектор направления объекта
    private final Vector2 v0;

    private final BulletPool bulletPool;
    private final TextureRegion bulletRegion;
    private final Vector2 bulletV;
    private final float bulletHeight;

    private final int damage;

    private Rect worldBounds;

    // состояние нажатия клавиши влево
    private boolean pressedLeft;

    // состояние нажатия клавиши вправо
    private boolean pressedRight;

    private float reloadTimer;
    private final float reloadInterval;

    // для работы мультитача
    private int leftPointer = INVALID_POINTER;
    private int rightPointer = INVALID_POINTER;



    // данный конструктор работает с атлосом текстур
    public Ship(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);


        this.v = new Vector2();
        this.v0 = new Vector2(0.5f, 0f);
        this.bulletPool = bulletPool;
        this.bulletRegion = atlas.findRegion("bulletMainShip");
        this.bulletV = new Vector2(0, 0.5f);
        this.bulletHeight = 0.01f;
        this.damage = 1;

        //interval strelbi
        this.reloadInterval = 0.25f;

    }

    // позиционирование объекта
    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;

        // размер объeкта
        setHeightProportion(HEIGHT);

        setBottom(worldBounds.getBottom() + BOTTOM_MARGIN);
    }

    // движение объекта
    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer+=delta;

        if(reloadTimer > reloadInterval){
            reloadTimer = 0f;

            //method strelba
            shoot();
        }
        /*

        // первый пример (что бы игровой объект не улетал за придела экрана)

       if (getRight() > worldBounds.getRight()) {
           setRight(worldBounds.getRight());
            stop();
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
            stop();
        }

         */

        //второй пример (что бы игровой объект не улетал за придела экрана)
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
    }

    // передача событий нажатия на экран
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x < worldBounds.pos.x) {
            if (leftPointer != INVALID_POINTER) {
                return false;
            }
            leftPointer = pointer;
            moveLeft();
        } else {
            if (rightPointer != INVALID_POINTER) {
                return false;
            }
            rightPointer = pointer;
            moveRight();
        }
        return false;
    }

    // передача событий когда мы убераем палец с экрана
    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (pointer == leftPointer) {
            leftPointer = INVALID_POINTER;
            if (rightPointer != INVALID_POINTER) {
                moveRight();
            } else {
                stop();
            }
        } else if (pointer == rightPointer) {
            rightPointer = INVALID_POINTER;
            if (leftPointer != INVALID_POINTER) {
                moveLeft();
            } else {
                stop();
            }
        }
        return false;
    }

    //управление клавиатурой когда мы нажамаем на клавишу
    public boolean keyDown(int keycode) {
        switch (keycode) {

            //движение влево
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = true;
                moveLeft();
                break;

                //движение вправо
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = true;
                moveRight();
                break;
            case Input.Keys.UP:
                shoot();
                break;
        }
        return false;
    }

    //управление клавиатурой когда мы отпускаем клавишу
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                pressedLeft = false;
                if (pressedRight) {
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                pressedRight = false;
                if (pressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
        }
        return false;
    }

    //движения объекта вправо
    private void moveRight() {
        v.set(v0);
    }

    //движение объекта влево
    private void moveLeft() {
        //метод rotateDeg(180) это развород вектора на 180
        v.set(v0).rotateDeg(180);
    }

    //остановка объекта
    private void stop() {
        v.setZero();
    }


    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
    }
}
