package com.artsuo.hallsofosiris;

import com.artsuo.hallsofosiris.engine.AssetBank;
import com.artsuo.hallsofosiris.engine.Engine;
import com.artsuo.hallsofosiris.screens.GameScreen;
import com.artsuo.hallsofosiris.screens.LoadingScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hoo extends Game {

	public SpriteBatch batch;
	
	@Override
	public void create() {
		this.batch = new SpriteBatch();
		AssetBank.init();
		setScreen(new LoadingScreen(this));
	}
	
	public void restartGame(GameScreen oldScreen) {
		Engine.restart();
		setScreen(new GameScreen(this));
		oldScreen.dispose();
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume() {
		super.resume();
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
