package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.smp.zombiebirdkiller.assets.AssetHandler;

public class GameRenderer
{

	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	private SpriteBatch batcher;

	// Game Objects
	private Player player;
	//private ScrollHandler scroller;
	//private Grass frontGrass, backGrass;
	//private Pipe pipe1, pipe2, pipe3;

	// Game Assets
	private TextureRegion bg, grass, playerMid;
	private Animation playerAnimation;

	// Tween stuff
	//private TweenManager manager;
	//private Value alpha = new Value();

	// Buttons
	//private List<SimpleButton> menuButtons;
	//private Color transitionColor;
	
	//Numerical values
	float gameWidth;
	float gameHeight;
	int midPointY;

	public GameRenderer(GameWorld world, float gameWidth, float gameHeight, int midPointY) {
		this.world = world;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		/*
		this.menuButtons = ((InputHandler) Gdx.input.getInputProcessor())
				.getMenuButtons();
		*/
		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initGameObjects();
		initAssets();

		//transitionColor = new Color();
		//prepareTransition(255, 255, 255, .5f);
	}

	private void initGameObjects() {
		player = world.getPlayer();
		//scroller = world.getScroller();
		//frontGrass = scroller.getFrontGrass();
		//backGrass = scroller.getBackGrass();
	}

	private void initAssets() {
		bg = AssetHandler.background;
		grass = AssetHandler.grass;
		playerAnimation = AssetHandler.playerAnimation;
		playerMid = AssetHandler.player;
		
	}
	/*
	private void drawGrass() {
		// Draw the grass
		batcher.draw(grass, frontGrass.getX(), frontGrass.getY(),
				frontGrass.getWidth(), frontGrass.getHeight());
		batcher.draw(grass, backGrass.getX(), backGrass.getY(),
				backGrass.getWidth(), backGrass.getHeight());
	}
	*/
	/*
	private void drawSkulls() {

		batcher.draw(skullUp, pipe1.getX() - 1,
				pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
		batcher.draw(skullDown, pipe1.getX() - 1,
				pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

		batcher.draw(skullUp, pipe2.getX() - 1,
				pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
		batcher.draw(skullDown, pipe2.getX() - 1,
				pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

		batcher.draw(skullUp, pipe3.getX() - 1,
				pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
		batcher.draw(skullDown, pipe3.getX() - 1,
				pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
	}
	*/
	/*
	private void drawPipes() {
		batcher.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
				pipe1.getHeight());
		batcher.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45,
				pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

		batcher.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
				pipe2.getHeight());
		batcher.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45,
				pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

		batcher.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
				pipe3.getHeight());
		batcher.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45,
				pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
	}
	*/
	private void drawplayerCentered(float runTime) {
		batcher.draw(playerAnimation.getKeyFrame(runTime), 59, player.getY() - 15,
				player.getWidth() / 2.0f, player.getHeight() / 2.0f,
				player.getWidth(), player.getHeight(), 1, 1, player.getRotation());
	}
	/*
	private void drawShots()
	{
		for (PlayerShot shot : world.getPlayerShots())
		{
			batcher.draw(playerMid, shot.getX(), shot.getY(),
					shot.getWidth() / 2.0f, shot.getHeight() / 2.0f,
					shot.getWidth(), shot.getHeight(), 1, 1, shot.getRotation());
		}
	}
	*/
	
	//TODO magic numbers
	private void drawPlayer(float runTime) {

		if (player.shouldntFlap()) {
			batcher.draw(playerMid, player.getX(), player.getY(),
					player.getWidth() / 2.0f, player.getHeight() / 2.0f,
					player.getWidth(), player.getHeight(), 1, 1, player.getRotation());

		} else {
			batcher.draw(playerAnimation.getKeyFrame(runTime), player.getX(),
					player.getY(), player.getWidth() / 2.0f,
					player.getHeight() / 2.0f, player.getWidth(), player.getHeight(),
					1, 1, player.getRotation());
		}

	}
	/*
	private void drawMenuUI() {
		batcher.draw(zbLogo, gameWidth / 2 - 56, midPointY - 50,
				zbLogo.getRegionWidth() / 1.2f, zbLogo.getRegionHeight() / 1.2f);

		for (SimpleButton button : menuButtons) {
			button.draw(batcher);
		}

	}
	
	private void drawScoreboard() {
		batcher.draw(scoreboard, 22, midPointY - 30, 97, 37);

		batcher.draw(noStar, 25, midPointY - 15, 10, 10);
		batcher.draw(noStar, 37, midPointY - 15, 10, 10);
		batcher.draw(noStar, 49, midPointY - 15, 10, 10);
		batcher.draw(noStar, 61, midPointY - 15, 10, 10);
		batcher.draw(noStar, 73, midPointY - 15, 10, 10);

		if (world.getScore() > 2) {
			batcher.draw(star, 73, midPointY - 15, 10, 10);
		}

		if (world.getScore() > 17) {
			batcher.draw(star, 61, midPointY - 15, 10, 10);
		}

		if (world.getScore() > 50) {
			batcher.draw(star, 49, midPointY - 15, 10, 10);
		}

		if (world.getScore() > 80) {
			batcher.draw(star, 37, midPointY - 15, 10, 10);
		}

		if (world.getScore() > 120) {
			batcher.draw(star, 25, midPointY - 15, 10, 10);
		}

		int length = ("" + world.getScore()).length();

		AssetLoader.whiteFont.draw(batcher, "" + world.getScore(),
				104 - (2 * length), midPointY - 20);

		int length2 = ("" + AssetLoader.getHighScore()).length();
		AssetLoader.whiteFont.draw(batcher, "" + AssetLoader.getHighScore(),
				104 - (2.5f * length2), midPointY - 3);

	}
	
	private void drawRetry() {
		batcher.draw(retry, 36, midPointY + 10, 66, 14);
	}

	private void drawReady() {
		batcher.draw(ready, 36, midPointY - 50, 68, 14);
	}

	private void drawGameOver() {
		batcher.draw(gameOver, 24, midPointY - 50, 92, 14);
	}
	*/
	/*
	private void drawScore() {
		int length = ("" + world.getScore()).length();
		AssetLoader.shadow.draw(batcher, "" + world.getScore(),
				68 - (3 * length), midPointY - 82);
		AssetLoader.font.draw(batcher, "" + world.getScore(),
				68 - (3 * length), midPointY - 83);
	}
	
	private void drawHighScore() {
		batcher.draw(highScore, 22, midPointY - 50, 96, 14);
	}
	*/
	public void render(float delta, float runTime) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, gameWidth, midPointY + 66);

		// Draw Grass
		shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 66, gameWidth, 11);

		// Draw Dirt
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 77, gameWidth, 52);

		shapeRenderer.end();

		batcher.begin();
		batcher.disableBlending();

		batcher.draw(bg, 0, midPointY + 23, gameWidth, 43);

		//drawPipes();

		batcher.enableBlending();
		//drawSkulls();
		
		drawPlayer(runTime);
		/*
		if (world.isRunning()) {
			drawPlayer(runTime);
			drawScore();
		} else if (world.isReady()) {
			drawPlayer(runTime);
			drawReady();
		} else if (world.isMenu()) {
			drawBirdCentered(runTime);
			drawMenuUI();
		} else if (world.isGameOver()) {
			drawScoreboard();
			drawPlayer(runTime);
			drawGameOver();
			drawRetry();
		} else if (world.isHighScore()) {
			drawScoreboard();
			drawPlayer(runTime);
			drawHighScore();
			drawRetry();
		}
		*/
		//drawGrass();
		//drawShots();
		batcher.end();
		//drawTransition(delta);

	}
	/*
	public void prepareTransition(int r, int g, int b, float duration) {
		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
		alpha.setValue(1);
		Tween.registerAccessor(Value.class, new ValueAccessor());
		manager = new TweenManager();
		Tween.to(alpha, -1, duration).target(0)
				.ease(TweenEquations.easeOutQuad).start(manager);
	}

	private void drawTransition(float delta) {
		if (alpha.getValue() > 0) {
			manager.update(delta);
			Gdx.gl.glEnable(GL10.GL_BLEND);
			Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(transitionColor.r, transitionColor.g,
					transitionColor.b, alpha.getValue());
			shapeRenderer.rect(0, 0, gameWidth, 300);
			shapeRenderer.end();
			Gdx.gl.glDisable(GL10.GL_BLEND);

		}
	}
	*/
}

