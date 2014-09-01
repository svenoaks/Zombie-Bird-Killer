package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.Gdx;
import static com.smp.zombiebirdkiller.assets.AssetHandler.*;
import static com.smp.zombiebirdkiller.assets.Constants.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smp.zombiebirdkiller.assets.AssetHandler;

public class GameRenderer
{
	private GameWorld world;
	private OrthographicCamera camera;
	private Viewport viewport;
	private ShapeRenderer shapeRenderer;

	private SpriteBatch batcher;

	// Game Objects
	private Helicopter player;

	// Numerical values

	public GameRenderer(GameWorld world)
	{
		this.world = world;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, DIMENSION_GAME_WIDTH, DIMENSION_GAME_HEIGHT);
		viewport = new FitViewport(DIMENSION_GAME_WIDTH, DIMENSION_GAME_HEIGHT, camera);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		initGameObjects();
		initAssets();
	}

	private void initGameObjects()
	{
		player = world.getPlayer();
	}

	private void initAssets()
	{

	}

	private void drawplayerCentered(float runTime)
	{
		batcher.draw(playerAnimation.getKeyFrame(runTime), 59, player.getY() - 15,
				player.getWidth() / 2.0f, player.getHeight() / 2.0f,
				player.getWidth(), player.getHeight(), 1, 1, player.getRotation());
	}

	/*
	 * private void drawShots() { for (PlayerShot shot : world.getPlayerShots())
	 * { batcher.draw(playerMid, shot.getX(), shot.getY(), shot.getWidth() /
	 * 2.0f, shot.getHeight() / 2.0f, shot.getWidth(), shot.getHeight(), 1, 1,
	 * shot.getRotation()); } }
	 */

	// TODO magic numbers
	private void drawPlayer(float runTime)
	{
		batcher.draw(helicopter, player.getX(), player.getY(),
				player.getWidth() / 2.0f, player.getHeight() / 2.0f,
				player.getWidth(), player.getHeight(), 1, 1, player.getRotation());
		
		/*
		if (player.shouldntFlap())
		{
			batcher.draw(playerMid, player.getX(), player.getY(),
					player.getWidth() / 2.0f, player.getHeight() / 2.0f,
					player.getWidth(), player.getHeight(), 1, 1, player.getRotation());

		}
		else
		{
			batcher.draw(playerAnimation.getKeyFrame(runTime), player.getX(),
					player.getY(), player.getWidth() / 2.0f,
					player.getHeight() / 2.0f, player.getWidth(), player.getHeight(),
					1, 1, player.getRotation());
		}
		*/
	}

	public void render(float delta, float runTime)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, DIMENSION_GAME_WIDTH, DIMENSION_GAME_HEIGHT);

		// Draw Grass
		shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
		shapeRenderer.rect(0, COORDINATE_GRASS_LOCATION_Y, DIMENSION_GAME_WIDTH, DIMENSION_GRASS_HEIGHT);

		// Draw Dirt
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(0, COORDINATE_DIRT_LOCATION_Y, DIMENSION_GAME_WIDTH, DIMENSION_DIRT_HEIGHT);
		
		/*
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		*/
		
		shapeRenderer.end();

		batcher.begin();
		batcher.disableBlending();

		// batcher.draw(bg, 0, midPointY + 23, gameWidth, 43);

		batcher.enableBlending();

		drawPlayer(runTime);

		batcher.end();
	}

	public void resize(int width, int height)
	{
		viewport.update(width, height);

	}
}
