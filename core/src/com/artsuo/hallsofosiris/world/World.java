package com.artsuo.hallsofosiris.world;

import com.artsuo.hallsofosiris.Const;
import com.artsuo.hallsofosiris.util.RandomUtil;
import com.artsuo.hallsofosiris.world.Tile.TileType;
import com.badlogic.gdx.math.Vector2;

public class World {

	public enum Direction {
		UP, UPRIGHT, RIGHT, DOWNRIGHT, DOWN, DOWNLEFT, LEFT, UPLEFT
	}
	
	public static int sx;
	public static int sy;
	private Tile[][] tiles;
	
	public World(int sizeX, int sizeY) {
		initMap(sizeX, sizeY);
	}
	
	private void initMap(int sizeX, int sizeY) {
		sx = sizeX;
		sy = sizeY;
		this.tiles = new Tile[sizeX][sizeY];
		createMap();
	}
	
	private void createMap() {
		// Fill map
		for (int y = 0; y < sy; y++) {
			for (int x = 0; x < sx; x++) {
				tiles[x][y] = new Tile(x * Const.TILE_SIZE, y * Const.TILE_SIZE, TileType.DIRT);
			}
		}
		// Place entrance
		placeEntrance();
		
	}
	
	private void placeEntrance() {
		// TODO: Entrance tile at random location, next to it (up, right, left or down) are party start locations
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
}
