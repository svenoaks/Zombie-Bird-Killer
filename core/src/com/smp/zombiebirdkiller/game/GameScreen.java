package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import static com.smp.zombiebirdkiller.assets.Constants.*;

public class GameScreen implements Screen
{
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	
	public GameScreen()
	{
		world = new GameWorld(COORDINATE_MIDPOINT_Y, SHAPE_GAME_RECTANGLE);
		Gdx.input.setInputProcessor(new InputHandler(world));
		renderer = new GameRenderer(world);
		world.setRenderer(renderer);
	}

	@Override
	public void render(float delta)
	{
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
		
	}

	@Override
	public void resize(int width, int height)
	{
		renderer.resize(width, height);
		
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

}
