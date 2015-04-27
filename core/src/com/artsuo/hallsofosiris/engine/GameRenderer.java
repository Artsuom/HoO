package com.artsuo.hallsofosiris.engine;

import com.artsuo.hallsofosiris.Const;
import com.artsuo.hallsofosiris.world.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameRenderer {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private World world;
	public static Rectangle viewportBounds;

	public GameRenderer(World world) {
		this.world = world;
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, Const.VIEWPORT_WIDTH, 
				Const.VIEWPORT_HEIGHT);
		viewportBounds = new Rectangle(0, 0, Const.VIEWPORT_WIDTH, Const.VIEWPORT_HEIGHT);
		centerCamera();
		camera.update();
		this.batch = new SpriteBatch();
	}

	private void centerCamera() {
		// TODO: Camera position centered on party
		camera.position.set(0, 0, 0);
	}
	
	public void render(float delta) {
		updateViewportPos();
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		batch.begin();
		renderWorld();
		renderObjects(delta);
		batch.end();
	}

	// TO DO: Culling, optimization
	private void renderWorld() {
		for (int y = 0; y < World.sy; y++) {
			for (int x = 0; x < World.sx; x++) {
				world.getTiles()[x][y].getDrawable().getSprite().draw(batch);
			}
		}
	}
	
	private void renderObjects(float delta) {
		
	}
	
	private void updateViewportPos() {
		// TODO: Controlled manually (directional keys)
		/*
		viewportCenter.set(Engine.ObjectManager.getPlayer().getCenter());
		viewportBounds.setPosition(viewportCenter.x - viewportBounds.width / 2, viewportCenter.y - viewportBounds.height / 2);
		camera.position.set(viewportCenter.x, viewportCenter.y, 0);
		camera.update();
		*/
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
}
