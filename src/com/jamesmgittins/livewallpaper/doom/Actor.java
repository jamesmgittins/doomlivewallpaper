package com.jamesmgittins.livewallpaper.doom;

import java.util.Random;

public abstract class Actor {
	
	public float xLoc;
	public float yLoc;
	public boolean isSolid = true;
//	public static final float SCALING = 0.001f;
	public static final float SCALING = 0.00101f;
	public int animationCounter;
	
	public float calculateDistance(Actor actor) {
		return (float) Math.sqrt(Math.pow(actor.xLoc - xLoc, 2) + Math.pow(actor.yLoc - yLoc, 2));
	}
	
	public BloodSplatter createBloodSplatter(Random random) {
		BloodSplatter blood = new BloodSplatter();
		blood.xLoc = xLoc - 40 + random.nextInt(80);
		blood.yLoc = yLoc - ((15 + random.nextInt(35)) * 3.2f);
		return blood;
	}

}
