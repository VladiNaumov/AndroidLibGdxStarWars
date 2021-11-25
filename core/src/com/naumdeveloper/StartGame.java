package com.naumdeveloper;

import com.badlogic.gdx.Game;

import com.naumdeveloper.screen.base.MenuScreen;

public class StartGame extends Game {


	@Override
	public void create() {
		setScreen(new MenuScreen());
	}



}
