package com.smp.zombiebirdkiller.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHandler
{
	private static AssetManager manager;
	
	private static Texture mainTexture;
	
	public static TextureRegion playerMid, playerDown, playerUp;
	public static TextureRegion background;
	public static TextureRegion grass;

	public static Animation playerAnimation;
	
	static
	{
		manager = new AssetManager();
	}
	
	public static void load()
	{
		loadTextures();
		loadSounds();
		loadFonts();
		
		manager.finishLoading();
		
		assignTextures();
		assignSounds();
		assignFonts();
	}
	
	private static void assignFonts()
	{
		// TODO Auto-generated method stub
		
	}
	private static void assignSounds()
	{
		// TODO Auto-generated method stub
		
	}
	private static void assignTextures()
	{
		mainTexture = manager.get("data/texture_main.png", Texture.class);
		
		playerMid = new TextureRegion(mainTexture, 153, 0, 17, 12);
		playerDown = new TextureRegion(mainTexture, 136, 0, 17, 12);
		playerUp = new TextureRegion(mainTexture, 170, 0, 17, 12);
		background = new TextureRegion(mainTexture, 0, 0, 136, 43);
		grass = new TextureRegion(mainTexture, 0, 43, 143, 11);
		
		playerMid.flip(false, true);
		playerDown.flip(false, true);
		playerUp.flip(false, true);
		background.flip(false, true);
		grass.flip(false, true);
		
		TextureRegion[] players = { playerDown, playerMid, playerUp };
		playerAnimation = new Animation(0.06f, players);
		playerAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		
	}
	public static void dispose()
	{
		manager.dispose();
	}
	
	private static void loadFonts()
	{
		// TODO Auto-generated method stub
		
	}
	private static void loadSounds()
	{
		// TODO Auto-generated method stub
		
	}
	private static void loadTextures()
	{
		manager.load("data/texture_main.png", Texture.class);	
	}

	
}
