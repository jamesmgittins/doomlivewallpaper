package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Baddie extends Actor {
	
	public static final int SPAWNING = 5;
	public static final int WALKING = 1;
	public static final int SHOOTING = 2;
	public static final int DYING = 3;
	public static final int DEAD = 4;
	public int opacity = 255;
	public boolean takingDamage;
	public int health;
	public int state;
	public int badguy_id;
	public float xSpeed;
	public float ySpeed;
	public boolean hasDroppedPowerUp;
	public boolean killedByRocket;
	
	public Paint opacPaint;
	
	public abstract void draw(Canvas c, float offset, DoomGuy doomGuy, int width, int height, Sprites sprites);
	
	public abstract void updateState(DoomGuy doomGuy, boolean godMode, Random random, ArrayList<Actor> projectiles, ArrayList<Actor> actors, ArrayList<BloodSplatter> bloodSplatter, ArrayList<PowerUp> powerUpList);

	public float calculateDistanceAfterMove(Actor actor) {
		return (float) Math.sqrt(Math.pow(actor.xLoc - (xLoc + xSpeed), 2) + Math.pow(actor.yLoc - (yLoc + ySpeed), 2));
	}
}
