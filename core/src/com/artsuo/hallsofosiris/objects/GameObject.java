package com.artsuo.hallsofosiris.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

	protected Vector2 position;
	protected Rectangle bounds;
	
	public void init(Vector2 position, float sx, float sy) {
		this.position = position;
		this.bounds = new Rectangle(position.x, position.y, sx, sy);
	}
	
	//public abstract void update(float delta);
}
