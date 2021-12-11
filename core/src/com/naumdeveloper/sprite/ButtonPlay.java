package com.naumdeveloper.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.naumdeveloper.base.BaseButton;
import com.naumdeveloper.math.Rect;
import com.naumdeveloper.screen.GameScreen;

public class ButtonPlay extends BaseButton {

    private final Game game;

    private static final float HEIGHT = 0.25f;
    private static final float PADDING = 0.03f;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setLeft(worldBounds.getLeft() + PADDING);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
