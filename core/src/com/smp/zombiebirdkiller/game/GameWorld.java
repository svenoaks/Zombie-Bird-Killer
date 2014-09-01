package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld
{
	private static final int MAX_PLAYER_SHOTS = 10;

	private Helicopter player;
	//private ScrollHandler scroller;
	private Rectangle ground;
	private Rectangle gameRectangle;

	private int score;
	private int midPointY;
	private float runTime;

	private GameRenderer renderer;

	//private GameState currentState;

	//private Pool<PlayerShot> shotPool;
	//private Array<PlayerShot> playerShots;

	public enum GameState
	{
		MENU, READY, RUNNING, GAMEOVER, HIGHSCORE
	}

	public GameWorld(int midPointY, Rectangle gameRectangle)
	{
		//currentState = GameState.MENU;
		this.midPointY = midPointY;
		this.gameRectangle = gameRectangle;
		player = new Helicopter(33, midPointY - 5);
		// The grass should start 66 pixels below the midPointY
		//scroller = new ScrollHandler(this, midPointY + 66);
		ground = new Rectangle(0, midPointY + 66, 137, 11);

		//createPlayerShots();
	}

	public void update(float delta)
	{
		runTime += delta;
		updateRunning(delta);

		/*
		switch (currentState)
		{
			case READY:
			case MENU:
				updateReady(delta);
				break;

			case RUNNING:
				updateRunning(delta);
				break;
			default:
				break;
		}
		*/
	}
	/*
	private void createPlayerShots()
	{
		shotPool = new Pool<PlayerShot>(MAX_PLAYER_SHOTS, MAX_PLAYER_SHOTS)
		{
			@Override
			protected PlayerShot newObject()
			{
				return new PlayerShot();
			}
		};
		playerShots = Pools.makeArrayFromPool(playerShots, shotPool, MAX_PLAYER_SHOTS);
	}
	
	void addPlayerShot () {
		if (playerShots.size < MAX_PLAYER_SHOTS) {
			
			PlayerShot shot = shotPool.obtain();
			
			float x = player.getX() + player.width / 2 - shot.width / 2;
			float y = player.getY() + player.height / 2 - shot.height / 2;
			
			shot.setRotation(player.getRotation());
			shot.setVelocity(player.getRotation());
			shot.fire(x, y);
			
			playerShots.add(shot);
		}
	}
	*/
	private void updateReady(float delta)
	{
		player.updateReady(runTime);
		//scroller.updateReady(delta);
	}

	public void updateRunning(float delta)
	{
		
		//TODO magic numbers...
		if (delta > .15f)
		{
			delta = .15f;
		}

		player.update(delta);
		//scroller.update(delta);

		//GameObjectRemover.removeOutOfBounds(shotPool, playerShots, gameRectangle);
		//updateShots(delta);

		//checkPlayerCollidesPipe();
		//checkPlayerCollidesGround();
	}
	/*
	private void checkPlayerCollidesPipe()
	{
		if (scroller.collides(player) && player.isAlive())
		{
			scroller.stop();
			player.die();
			AssetLoader.dead.play();
			renderer.prepareTransition(255, 255, 255, .3f);
			AssetLoader.fall.play();
			
			currentState = GameState.GAMEOVER;

			if (score > AssetLoader.getHighScore())
			{
				AssetLoader.setHighScore(score);
				currentState = GameState.HIGHSCORE;
			}
		}
	}
	
	private void checkPlayerCollidesGround()
	{
		if (Intersector.overlaps(player.getBoundingCircle(), ground))
		{

			if (player.isAlive())
			{
				AssetLoader.dead.play();
				renderer.prepareTransition(255, 255, 255, .3f);
				player.die();
			}

			scroller.stop();
			player.decelerate();
			currentState = GameState.GAMEOVER;

			if (score > AssetLoader.getHighScore())
			{
				AssetLoader.setHighScore(score);
				currentState = GameState.HIGHSCORE;
			}
		}
	}
	*/
	/*
	private void updateShots(float delta)
	{
		for (PlayerShot shot : playerShots)
		{
			shot.update(delta);
		}
	}
	*/
	public Helicopter getPlayer()
	{
		return player;

	}

	public int getMidPointY()
	{
		return midPointY;
	}
	/*
	public ScrollHandler getScroller()
	{
		return scroller;
	}
	*/
	public int getScore()
	{
		return score;
	}

	public void addScore(int increment)
	{
		score += increment;
	}
	/*
	public void start()
	{
		currentState = GameState.RUNNING;
	}

	public void ready()
	{
		currentState = GameState.READY;
		renderer.prepareTransition(0, 0, 0, 1f);
	}

	public void restart()
	{
		score = 0;
		player.onRestart(midPointY - 5);
		scroller.onRestart();
		ready();
	}

	public boolean isReady()
	{
		return currentState == GameState.READY;
	}

	public boolean isGameOver()
	{
		return currentState == GameState.GAMEOVER;
	}

	public boolean isHighScore()
	{
		return currentState == GameState.HIGHSCORE;
	}

	public boolean isMenu()
	{
		return currentState == GameState.MENU;
	}

	public boolean isRunning()
	{
		return currentState == GameState.RUNNING;
	}
	*/
	public void setRenderer(GameRenderer renderer)
	{
		this.renderer = renderer;
	}
	/*
	public void newShot()
	{
		AssetLoader.dead.play();
	}
	
	public Array<PlayerShot> getPlayerShots()
	{
		return playerShots;
	}
	*/
}

