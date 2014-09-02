package com.smp.zombiebirdkiller.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.smp.zombiebirdkiller.ZombieBirdKillerGame;

public class AndroidLauncher extends AndroidApplication {
	public static int HH = 1;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ZombieBirdKillerGame(), config);
	}
}
