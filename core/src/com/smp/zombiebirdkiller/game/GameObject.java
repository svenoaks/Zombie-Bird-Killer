package com.smp.zombiebirdkiller.game;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{
	protected Vector2 position;
	protected Vector2 velocity;
	
	protected float width;
	protected float height;
	protected float rotation;
	
	public float getTailX() {
		return position.x + width;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}
	
	public abstract void update (float delta);
}
