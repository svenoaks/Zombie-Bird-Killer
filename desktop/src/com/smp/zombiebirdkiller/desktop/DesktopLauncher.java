package com.smp.zombiebirdkiller.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import static com.smp.zombiebirdkiller.assets.Constants.*;

import com.smp.zombiebirdkiller.ZombieBirdKillerGame;

public class DesktopLauncher {
	
	private static final int SCALE_FACTOR_DESKTOP = 4;
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = NAME_APP;
        config.width = (int) DIMENSION_GAME_WIDTH * SCALE_FACTOR_DESKTOP;
        config.height = (int) DIMENSION_GAME_HEIGHT * SCALE_FACTOR_DESKTOP;
		new LwjglApplication(new ZombieBirdKillerGame(), config);
	}
}
