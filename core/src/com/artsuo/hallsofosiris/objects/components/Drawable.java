package com.artsuo.hallsofosiris.objects.components;

import com.artsuo.hallsofosiris.engine.AssetBank;
import com.artsuo.hallsofosiris.engine.AssetBank.SpriteKey;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Drawable {

private Sprite sprite;
	
	public Drawable(SpriteKey key, float x, float y, float sx, float sy) {
		this.sprite = new Sprite(AssetBank.createObjectSprite(key));
		sprite.setBounds(x, y, sx, sy);
	}
	
	public void updatePosition(float x, float y) {
		sprite.setPosition(x, y);
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}
