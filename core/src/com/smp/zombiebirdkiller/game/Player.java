package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import static com.smp.zombiebirdkiller.assets.Constants.*;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject
{
	private static final int ACCELERATION_GRAVITY_Y = 180;
	private static final int COORDINATE_CEILING_Y = 0;
	
	private static final int VELOCITY_MAXIMUM_Y = 35;
	private static final int ROTATION_MAXIMUM_DOWN = 10;
	private static final int ROTATION_MAXIMUM_UP = -18;
	private static final int ROTATION_ADDER_FALLING = 35;
	private static final int ROTATION_ADDER_RISING = 150;
	
	private final int WIDTH = 33;
	private final int HEIGHT = 12;

	private Vector2 acceleration;

	private float originalY;

	private boolean isAlive;

	private Circle boundingCircle;

	private boolean flapping;
	private boolean atCeiling;

	public Player(float x, float y)
	{
		this.originalY = y;
		this.width = WIDTH;
		this.height = HEIGHT;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, ACCELERATION_GRAVITY_Y);
		boundingCircle = new Circle();
		isAlive = true;
	}

	@Override
	public void update(float delta)
	{

		if (flapping)
			flap();

		if (velocity.y > VELOCITY_MAXIMUM_Y)
		{
			velocity.y = VELOCITY_MAXIMUM_Y;
		}
		if (position.y + velocity.cpy().scl(delta).y < COORDINATE_CEILING_Y)
		{
			position.y = COORDINATE_CEILING_Y;
			velocity.y = 0;
		}
		else if (position.y + velocity.cpy().scl(delta).y > COORDINATE_GRASS_LOCATION_Y - height)
		{
			position.y = COORDINATE_GRASS_LOCATION_Y - height;
			velocity.y = 0;
		}
		else
		{
		    velocity.add(acceleration.cpy().scl(delta));
			position.add(velocity.cpy().scl(delta));
		}

		// Set the circle's center to be (9, 6) with respect to the bird.
		// Set the circle's radius to be 6.5f;
		boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

		// Rotate counterclockwise
		if (velocity.y < 0)
		{
			rotation -= ROTATION_ADDER_RISING * delta;

			if (rotation < ROTATION_MAXIMUM_UP)
			{
				rotation = ROTATION_MAXIMUM_UP;
			}
		}

		// Rotate clockwise
		if (isFalling())
		{
			rotation += ROTATION_ADDER_FALLING * delta;
			if (rotation > ROTATION_MAXIMUM_DOWN)
			{
				rotation = ROTATION_MAXIMUM_DOWN;
			}
		}
	}

	public void updateReady(float runTime)
	{
		position.y = 2 * (float) Math.sin(7 * runTime) + originalY;
	}

	public boolean isFalling()
	{
		return velocity.y > 5;
	}

	public boolean shouldntFlap()
	{
		return velocity.y > 70 || !isAlive;
	}

	public void flap()
	{
		if (!atCeiling)
			velocity.y = -35;
	}

	public void die()
	{
		isAlive = false;
		velocity.y = 0;
	}

	public void decelerate()
	{
		acceleration.y = 0;
	}

	public void onRestart(int y)
	{
		rotation = 0;
		position.y = y;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 460;
		isAlive = true;
	}

	public Circle getBoundingCircle()
	{
		return boundingCircle;
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public void startFlapping()
	{
		flapping = true;
	}

	public void stopFlapping()
	{
		flapping = false;
	}

}
