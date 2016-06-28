package com.jamesmgittins.livewallpaper.doom;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;

public class PowerUp extends Actor {
	
	public long spawnTime;	
	public boolean spawned = false;
	public boolean collected = true;
	
	public float scaling = 1;
	
	
	
	public Paint textPaint;
	
	public int type;
	
	public static final int HEALTH = 1;
	public static final int MINIGUN = 2;
	public static final int LAUNCHER = 3;
	public static final int SHOTGUN = 4;
	public static final int AMMO_CLIP = 5;
	public static final int PLASMA_RIFLE = 6;
	
//	public float yLoc;
//	public float xLoc;
	
	private Matrix aMatrix;
	
	public Paint linePaint;
	
	
	public PowerUp() {
		isSolid = false;
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);
		
		textPaint = new Paint();
		textPaint.setARGB(150, 255, 255, 255);
		textPaint.setTextSize(25);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setAntiAlias(true);
		
		linePaint = new Paint();
		linePaint.setStrokeWidth(5);
		linePaint.setARGB(150, 255, 255, 255);
		linePaint.setStyle(Style.STROKE);
		linePaint.setStrokeCap(Cap.BUTT);
		linePaint.setAntiAlias(true);
	}
	
	public void draw(Canvas c, float offset, Sprites sprites) {
		
		if (System.currentTimeMillis() > spawnTime + 5000) {
			spawned = true;
		}
		if (!collected) {
			if (spawned) {
				scaling = 2.3f + (yLoc * SCALING);
							
				aMatrix.setScale(scaling, scaling);
				aMatrix.postTranslate(xLoc - (15f * scaling) - (c.getWidth() * offset), yLoc - (10f * scaling));
				c.drawBitmap(sprites.shadow, aMatrix, null);
				aMatrix.setScale(scaling, scaling);
				switch (type) {
				case HEALTH:
					aMatrix.postTranslate(xLoc - (14f * scaling) - (c.getWidth() * offset), yLoc - (18f * scaling));
					c.drawBitmap(sprites.healthSprite, aMatrix, null);
					break;
				case MINIGUN:
					aMatrix.postTranslate(xLoc - (31f * scaling) - (c.getWidth() * offset), yLoc - (18f * scaling));
					c.drawBitmap(sprites.minigunSprite, aMatrix, null);
					break;
				case SHOTGUN:
					aMatrix.postTranslate(xLoc - (31f * scaling) - (c.getWidth() * offset), yLoc - (17f * scaling));
					c.drawBitmap(sprites.shotgunSprite, aMatrix, null);
					break;
				case LAUNCHER:
					aMatrix.postTranslate(xLoc - (31f * scaling) - (c.getWidth() * offset), yLoc - (18f * scaling));
					c.drawBitmap(sprites.launcherSprite, aMatrix, null);
					break;
				case AMMO_CLIP:
					aMatrix.postTranslate(xLoc - (4f * scaling) - (c.getWidth() * offset), yLoc - (10f * scaling));
					c.drawBitmap(sprites.ammoClip, aMatrix, null);
					break;
				case PLASMA_RIFLE:
					aMatrix.postTranslate(xLoc - (27f * scaling) - (c.getWidth() * offset), yLoc - (19f * scaling));
					c.drawBitmap(sprites.plasmaSprite, aMatrix, null);
					break;
				}
				
			} else {
				float phase = 360f - (360f * (float)(System.currentTimeMillis() - spawnTime) / 5000f);
				linePaint.setPathEffect(new DashPathEffect(new float[]{23f,40f}, phase));
				c.drawCircle(xLoc - (c.getWidth() * offset), yLoc - 5, 40, linePaint);
				c.drawText(String.valueOf(5 - Math.round((System.currentTimeMillis() - spawnTime) / 1000)), xLoc - (c.getWidth() * offset), yLoc, textPaint);
			}	
		}
	}

}
