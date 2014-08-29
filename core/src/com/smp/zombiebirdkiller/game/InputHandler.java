package com.smp.zombiebirdkiller.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor
{
	private Player player;
	private GameWorld world;

	//private List<SimpleButton> menuButtons;

	//private SimpleButton playButton;

	private float scaleFactorX;
	private float scaleFactorY;
	private float gameWidth;

	public InputHandler(GameWorld world, float gameWidth, float scaleFactorX,
			float scaleFactorY)
	{
		this.world = world;
		player = world.getPlayer();

		int midPointY = world.getMidPointY();

		this.gameWidth = gameWidth;
		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;
		/*
		menuButtons = new ArrayList<SimpleButton>();
		playButton = new SimpleButton(
				136 / 2 - (AssetLoader.playButtonUp.getRegionWidth() / 2),
				midPointY + 50, 29, 16, AssetLoader.playButtonUp,
				AssetLoader.playButtonDown);
		menuButtons.add(playButton);
		*/
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		player.startFlapping();
			
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		player.stopFlapping();
		
		return true;
	}

	@Override
	public boolean keyDown(int keycode)
	{

		// Can now use Space Bar to play the game
		
			
				player.flap();
		

		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		return false;
	}

	private int scaleX(int screenX)
	{
		return (int) (screenX / scaleFactorX);
	}

	private int scaleY(int screenY)
	{
		return (int) (screenY / scaleFactorY);
	}
	/*
	public List<SimpleButton> getMenuButtons()
	{
		return menuButtons;
	}
	*/
}