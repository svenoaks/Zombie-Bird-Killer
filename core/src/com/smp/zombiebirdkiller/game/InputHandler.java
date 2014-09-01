package com.smp.zombiebirdkiller.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor
{
	private Helicopter player;
	private GameWorld world;

	//private List<SimpleButton> menuButtons;

	//private SimpleButton playButton;

	public InputHandler(GameWorld world)
	{
		this.world = world;
		player = world.getPlayer();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		player.startFlapping();
			
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		player.stopFlapping();
		return true;
	}

	@Override
	public boolean keyDown(int keycode)
	{		
	    
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
}