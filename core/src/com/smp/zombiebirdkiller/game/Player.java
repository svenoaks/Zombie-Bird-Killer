package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject
{
	private Vector2 acceleration;

	private float originalY;

	private boolean isAlive;

	private Circle boundingCircle;
	
	private int flapCycle;
	private boolean flapping;

	public Player(float x, float y, float width, float height) {
		this.width = width;
		this.height = height;
		this.originalY = y;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 180);
		boundingCircle = new Circle();
		isAlive = true;
	}
	
	@Override
	public void update(float delta) {
		
		if (flapping) flap();

		velocity.add(acceleration.cpy().scl(delta));

		if (velocity.y > 200) {
			velocity.y = 200;
		}

		// CEILING CHECK
		if (position.y < 0) {
			position.y = 0;
			velocity.y = 0;
		}
		
		//FLOOR CHECK
		//TODO WHERE IS THE FLOOR LOL.
		if (position.y > 180) {
			position.y = 180;
			velocity.y = 0;
		}

		position.add(velocity.cpy().scl(delta));

		// Set the circle's center to be (9, 6) with respect to the bird.
		// Set the circle's radius to be 6.5f;
		boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

		// Rotate counterclockwise
		if (velocity.y < 0) {
			rotation -= 600 * delta;

			if (rotation < -50) {
				rotation = -50;
			}
		}

		// Rotate clockwise
		if (isFalling() || !isAlive) {
			rotation += 200 * delta;
			if (rotation > 75) {
				rotation = 75;
			}

		}

	}

	public void updateReady(float runTime) {
		position.y = 2 * (float) Math.sin(7 * runTime) + originalY;
	}

	public boolean isFalling() {
		return velocity.y > 110;
	}

	public boolean shouldntFlap() {
		return velocity.y > 70 || !isAlive;
	}

	public void flap() {
		if (isAlive) {
			velocity.y = -100;
		}
	}

	public void die() {
		isAlive = false;
		velocity.y = 0;
	}

	public void decelerate() {
		acceleration.y = 0;
	}

	public void onRestart(int y) {
		rotation = 0;
		position.y = y;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 460;
		isAlive = true;
	}
	
	

	public Circle getBoundingCircle() {
		return boundingCircle;
	}

	public boolean isAlive() {
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