package com.jamesmgittins.livewallpaper.doom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class BloodSplatter extends Actor {
	
	public Matrix aMatrix;
	public float scaling = 1;
	public int animationCounter;
	
	public BloodSplatter() {
		isSolid = false;
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);
		
		
	}
	
	public void draw(Canvas c, float offset, int width, Sprites sprites) {
		
		if (animationCounter < 3) {
			scaling = 3 + (yLoc * SCALING);
			drawScaled(
					sprites.blood[animationCounter],
					Math.round (sprites.bloodXOffset[animationCounter] * scaling),
					Math.round (sprites.bloodYOffset[animationCounter] * scaling),
					offset, c, width);
			animationCounter++;
		}
		
	}
	
	/**
	 * 
	 * @param drawMe
	 * @param offsetX
	 * @param offsetY
	 * @param offset
	 * @param c
	 */
	private void drawScaled(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int width) {
		aMatrix.setScale(scaling, scaling);
		aMatrix.postTranslate(xLoc + offsetX - (width * offset), yLoc + offsetY);	
		
		c.drawBitmap(drawMe, aMatrix, null);
	}

}
