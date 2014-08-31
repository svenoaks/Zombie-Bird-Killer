package com.smp.zombiebirdkiller.assets;

import static com.smp.zombiebirdkiller.assets.Constants.DIMENSION_GAME_HEIGHT;

import com.badlogic.gdx.math.Rectangle;

public class Constants
{
	public static final String NAME_APP = "Zombie Bird Killer";
	
	public static final float DIMENSION_GAME_WIDTH = 203;
	public static final float DIMENSION_GAME_HEIGHT = 105;
	
	public static final int DIMENSION_GRASS_HEIGHT = 5;
	public static final int DIMENSION_DIRT_HEIGHT = 7;
	
	public static final int COORDINATE_MIDPOINT_Y;
	public static final float COORDINATE_GRASS_LOCATION_Y;
	public static final float COORDINATE_DIRT_LOCATION_Y;
	public static final Rectangle SHAPE_GAME_RECTANGLE;
	
	static
	{
		COORDINATE_MIDPOINT_Y = (int) (DIMENSION_GAME_HEIGHT / 2);
		COORDINATE_GRASS_LOCATION_Y = DIMENSION_GAME_HEIGHT - DIMENSION_DIRT_HEIGHT - DIMENSION_GRASS_HEIGHT;
	    COORDINATE_DIRT_LOCATION_Y = DIMENSION_GAME_HEIGHT - DIMENSION_DIRT_HEIGHT;
		SHAPE_GAME_RECTANGLE = new Rectangle(0 ,0, DIMENSION_GAME_WIDTH, DIMENSION_GAME_HEIGHT);
	}
}
