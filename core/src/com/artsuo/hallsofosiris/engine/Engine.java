package com.artsuo.hallsofosiris.engine;

import com.artsuo.hallsofosiris.objects.ObjectManager;
import com.artsuo.hallsofosiris.screens.GameScreen;
import com.artsuo.hallsofosiris.world.World;
import com.badlogic.gdx.InputMultiplexer;

public class Engine {
	
	public static ObjectManager om;
	private GameScreen gameScreen;
	private World world;
	private GameRenderer renderer;
	private GameInputProcessor gameInputProcessor;
	private InputMultiplexer inputMultiplexer;
	
	public Engine(GameScreen gScreen) {
		this.gameScreen = gScreen;
		// TODO (world, OM)
		this.world = new World(10, 10);
		// this.om = new ObjectManager
		this.renderer = new GameRenderer(world);
		this.gameInputProcessor = new GameInputProcessor(this);
		this.inputMultiplexer = new InputMultiplexer(gameInputProcessor);
	}
	
	public static void restart() {
		
	}
	
	public void update(float delta) {
		
	}
	
	public void render(float delta) {
		renderer.render(delta);
	}
	
	public GameRenderer getRenderer() {
		return renderer;
	}
	
	public void dispose() {
		
	}
}
