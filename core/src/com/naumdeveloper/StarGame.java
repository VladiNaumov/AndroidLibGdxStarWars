package com.naumdeveloper;

import com.badlogic.gdx.Game;

import com.naumdeveloper.screen.impl.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
