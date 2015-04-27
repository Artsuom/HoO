package com.artsuo.hallsofosiris.engine;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetBank {
	
	public enum Asset {
		SKIN_DEFAULT, 
		ATLAS_OBJECTS, ATLAS_UI, // ATLAS_MAP,
		TEXTURE_UI_BACKGROUND
	}
	
	public enum SpriteKey {
		TILE_START, TILE_EXIT, TILE_FINAL_EXIT, TILE_FLOOR, TILE_DIRT, TILE_ROCK
	}

	private static AssetManager manager;
	private static HashMap<Asset, String> filenames;
	private static HashMap<SpriteKey, String> sprites;

	public static void init() {
		manager = new AssetManager();
		filenames = new HashMap<Asset, String>();
		sprites = new HashMap<SpriteKey, String>();
		setFilePaths();
		setSpriteKeys();
	}

	private static void setFilePaths() {
		filenames.put(Asset.SKIN_DEFAULT, "data/graphics/uiskin.json");
		//filenames.put(Asset.ATLAS_MAP, "data/graphics/map.txt");
		filenames.put(Asset.ATLAS_OBJECTS, "data/graphics/objects.txt");
		//filenames.put(Asset.ATLAS_UI, "data/graphics/ui.txt");
		filenames.put(Asset.TEXTURE_UI_BACKGROUND, "data/graphics/uibackground.png");
	}
	
	private static void setSpriteKeys() {
		sprites.put(SpriteKey.TILE_START, "start");
		sprites.put(SpriteKey.TILE_EXIT, "exit");
		sprites.put(SpriteKey.TILE_FINAL_EXIT, "finalexit");
		sprites.put(SpriteKey.TILE_FLOOR, "floor");
		sprites.put(SpriteKey.TILE_DIRT, "dirt");
		sprites.put(SpriteKey.TILE_ROCK, "rock");
		
	}

	private static String getFilePath(Asset key) {
		return filenames.get(key);
	}

	public static void loadTextureAtlas(Asset key) {
		manager.load(getFilePath(key), TextureAtlas.class);
	}

	public static void loadTexture(Asset key) {
		manager.load(getFilePath(key), Texture.class);
	}

	public static void loadSkin(Asset key) {
		manager.load(getFilePath(key), Skin.class);
	}

	public static void loadSound(Asset key) {
		manager.load(getFilePath(key), Sound.class);
	}

	public static void loadMusic(Asset key) {
		manager.load(getFilePath(key), Music.class);
	}

	public static TextureAtlas getTextureAtlas(Asset key) {
		if (manager.isLoaded(getFilePath(key))) {
			return manager.get(getFilePath(key), TextureAtlas.class);
		}
		return null;
	}

	public static Texture getTexture(Asset key) {
		if (manager.isLoaded(getFilePath(key))) {
			return manager.get(getFilePath(key), Texture.class);
		}
		return null;
	}

	public static Skin getSkin(Asset key) {
		if (manager.isLoaded(getFilePath(key))) {
			return manager.get(getFilePath(key), Skin.class);
		}
		return null;
	}

	public static Sound getSound(Asset key) {
		if (manager.isLoaded(getFilePath(key))) {
			return manager.get(getFilePath(key), Sound.class);
		}
		return null;
	}

	public static Music getMusic(Asset key) {
		if (manager.isLoaded(getFilePath(key))) {
			return manager.get(getFilePath(key), Music.class);
		}
		return null;
	}

	// Sprites
	//public static Sprite createMapSprite(SpriteKey key) {
	//	return getTextureAtlas(Asset.ATLAS_MAP).createSprite(sprites.get(key));
	//}
	
	// Create a sprite for a game object and set its location & bounds
	public static Sprite createObjectSprite(SpriteKey key, float x, float y, float sx, float sy) {
		Sprite sprite = getTextureAtlas(Asset.ATLAS_OBJECTS).createSprite(sprites.get(key));
		sprite.setBounds(x, y, sx, sy);
		return sprite;
	}
	
	// Create a sprite for a game object without setting its location & bounds
	public static Sprite createObjectSprite(SpriteKey key) {
		return getTextureAtlas(Asset.ATLAS_OBJECTS).createSprite(sprites.get(key));
	}
	
	// Create a sprite for a game object without setting its location & bounds
	public static Sprite createUiSprite(SpriteKey key) {
		return getTextureAtlas(Asset.ATLAS_UI).createSprite(sprites.get(key));
	}
	
	public static Animation createAnimation(Asset asset, int sheetCols, int sheetRows, float speed) {
		Texture tempSheet = getTexture(asset);
		TextureRegion[][] tmp = TextureRegion.split(tempSheet, tempSheet.getWidth() / sheetCols, 
				tempSheet.getHeight() / sheetRows); 
		TextureRegion[] tempFrames = new TextureRegion[sheetCols * sheetRows];
		int index = 0;
		for (int i = 0; i < sheetRows; i++) {
			for (int j = 0; j < sheetCols; j++) {
				tempFrames[index++] = tmp[i][j];
			}
		}
		return new Animation(speed, tempFrames);
	}
	
	// AssetManager
	public static AssetManager getManager() {
		return manager;
	}

}
