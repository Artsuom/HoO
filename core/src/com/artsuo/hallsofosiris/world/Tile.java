package com.artsuo.hallsofosiris.world;

import com.artsuo.hallsofosiris.Const;
import com.artsuo.hallsofosiris.engine.AssetBank.SpriteKey;
import com.artsuo.hallsofosiris.objects.GameObject;
import com.artsuo.hallsofosiris.objects.components.Drawable;
import com.badlogic.gdx.math.Vector2;

public class Tile extends GameObject {
	
	public enum TileType {
		START, EXIT, FINAL_EXIT, FLOOR, DIRT, ROCK
	}
	
	protected TileType type;
	protected Drawable drawable;
	protected boolean occupied;

	public Tile(float x, float y, TileType type) {
		init(new Vector2(x, y), Const.TILE_SIZE, Const.TILE_SIZE);
		this.type = type;
		switch(this.type) {
		case START:
			this.drawable = new Drawable(SpriteKey.TILE_START, position.x, position.y, bounds.width, bounds.height);
			break;
		case EXIT:
			this.drawable = new Drawable(SpriteKey.TILE_EXIT, position.x, position.y, bounds.width, bounds.height);
			break;
		case FINAL_EXIT:
			this.drawable = new Drawable(SpriteKey.TILE_FINAL_EXIT, position.x, position.y, bounds.width, bounds.height);
			break;
		case FLOOR:
			this.drawable = new Drawable(SpriteKey.TILE_FLOOR, position.x, position.y, bounds.width, bounds.height);
			break;
		case DIRT:
			this.drawable = new Drawable(SpriteKey.TILE_DIRT, position.x, position.y, bounds.width, bounds.height);
			break;
		case ROCK:
			this.drawable = new Drawable(SpriteKey.TILE_ROCK, position.x, position.y, bounds.width, bounds.height);
			break;
		}
	}
	
	public Drawable getDrawable() {
		return drawable;
	}
	
	public TileType getType() {
		return type;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public void setType(TileType type) {
		this.type = type;
	}
}
