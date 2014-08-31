package com.smp.zombiebirdkiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.smp.zombiebirdkiller.assets.AssetHandler;
import com.smp.zombiebirdkiller.game.GameScreen;

public class ZombieBirdKillerGame extends Game
{	
	@Override
	public void create()
	{
		AssetHandler.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose()
	{
		AssetHandler.dispose();
		super.dispose();
	}
}
