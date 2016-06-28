package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Sarge extends Baddie {
	
	public Matrix aMatrix;
	
	public int width;
	
	public final static int RESPAWN_TIME = 100;
	
	public int direction;
	
	public float scaling = 1;
	
	public static final int SPEED = 2;
	
	public Bitmap[] sargeWalking1 = new Bitmap[4];
	public int[] sargeWalking1XOffset = new int[] {-18, -19, -17, -19};
	public int[] sargeWalking1YOffset = new int[] {-51, -53, -50, -53};
	
	public Bitmap[] sargeWalking2 = new Bitmap[4];
	public int[] sargeWalking2XOffset = new int[] {-29, -23, -28, -29};
	public int[] sargeWalking2YOffset = new int[] {-50, -54, -49, -53};
	
	public Bitmap[] sargeWalking3 = new Bitmap[4];
	public int[] sargeWalking3XOffset = new int[] {-28, -28, -29, -29};
	public int[] sargeWalking3YOffset = new int[] {-48, -51, -48, -53};
	
	public Bitmap[] sargeWalking4 = new Bitmap[4];
	public int[] sargeWalking4XOffset = new int[] {-25, -30, -29, -30};
	public int[] sargeWalking4YOffset = new int[] {-48, -51, -48, -53};
	
	public Bitmap[] sargeWalking5 = new Bitmap[4];
	public int[] sargeWalking5XOffset = new int[] {-18, -20, -18, -20};
	public int[] sargeWalking5YOffset = new int[] {-49, -48, -49, -48};
	
	public Bitmap[] sargeShooting1 = new Bitmap[3];
	public int[] sargeShooting1XOffset = new int[] {-22, -22, -22};
	public int[] sargeShooting1YOffset = new int[] {-52, -52, -52};
	
	public Bitmap[] sargeShooting2 = new Bitmap[3];
	public int[] sargeShooting2XOffset = new int[] {-20, -23, -25};
	public int[] sargeShooting2YOffset = new int[] {-50, -50, -53};
	
	public Bitmap[] sargeShooting3 = new Bitmap[3];
	public int[] sargeShooting3XOffset = new int[] {-23, -30, -33};
	public int[] sargeShooting3YOffset = new int[] {-48, -48, -50};
	
	public Bitmap[] sargeShooting4 = new Bitmap[3];
	public int[] sargeShooting4XOffset = new int[] {-25, -28, -28};
	public int[] sargeShooting4YOffset = new int[] {-46, -47, -48};
	
	public Bitmap[] sargeShooting5 = new Bitmap[3];
	public int[] sargeShooting5XOffset = new int[] {-20, -20, -20};
	public int[] sargeShooting5YOffset = new int[] {-48, -49, -51};
	
	public Bitmap[] sargeDyingDirectional1stFrame = new Bitmap[5];
	public int[] sargeDyingDirectional1stFrameXOffset = new int[] {-18, -27, -29, -23, -15};
	public int[] sargeDyingDirectional1stFrameYOffset = new int[] {-51, -48, -46, -44, -45};
	
	public Bitmap[] sargeDeathFinalFrames = new Bitmap[6];
	public int[] sargeDeathFinalFramesXOffset = new int[] {-25, -28, -21, -29, -33, -33};
	public int[] sargeDeathFinalFramesYOffset = new int[] {-51, -59, -57, -55, -41, -27};
	

	// constructor to populate stuff
	public Sarge(Resources res) {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;
		
		sargeWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.sarga1);
		sargeWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.sargb1);
		sargeWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.sargc1);
		sargeWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.sargd1);
		
		sargeWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.sarga2a8);
		sargeWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.sargb2b8);
		sargeWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.sargc2c8);
		sargeWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.sargd2d8);
		
		sargeWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.sarga3a7);
		sargeWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.sargb3b7);
		sargeWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.sargc3c7);
		sargeWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.sargd3d7);
		
		sargeWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.sarga4a6);
		sargeWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.sargb4b6);
		sargeWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.sargc4c6);
		sargeWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.sargd4d6);
		
		sargeWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.sarga5);
		sargeWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.sargb5);
		sargeWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.sargc5);
		sargeWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.sargd5);
		
		sargeShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.sarge1);
		sargeShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.sargf1);
		sargeShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.sargg1);
		
		sargeShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.sarge2);
		sargeShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.sargf2);
		sargeShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.sargg2);
		
		sargeShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.sarge3);
		sargeShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.sargf3);
		sargeShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.sargg3);
		
		sargeShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.sarge4);
		sargeShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.sargf4);
		sargeShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.sargg4);
		
		sargeShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.sarge5);
		sargeShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.sargf5);
		sargeShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.sargg5);
		
		sargeDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.sargh1);
		sargeDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.sargh2);
		sargeDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.sargh3);
		sargeDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.sargh4);
		sargeDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.sargh5);
		
		sargeDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.sargi0);
		sargeDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.sargj0);
		sargeDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.sargk0);
		sargeDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.sargl0);
		sargeDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.sargm0);
		sargeDeathFinalFrames[5] = BitmapFactory.decodeResource(res, R.drawable.sargn0);
	}
	
	public void draw(Canvas c, float offset, DoomGuy doomGuy, int width, int height, Sprites sprites) {
		
		opacPaint = new Paint();
		
		if (health <= 0 && state != DEAD && state != DYING) {
			isSolid = false;
			state = DYING;
			animationCounter = 0;
		}
		this.width = width;
		
		calculateDirection(doomGuy);
		scaling = 3 + (yLoc * SCALING);
		
		if (takingDamage && health > 0) {
			takingDamage = false;
			switch (direction) {
			case 1:
				drawScaled(
						sargeDyingDirectional1stFrame[0],
						Math.round (sargeDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						sargeDyingDirectional1stFrame[1],
						Math.round (sargeDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						sargeDyingDirectional1stFrame[2],
						Math.round (sargeDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						sargeDyingDirectional1stFrame[3],
						Math.round (sargeDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						sargeDyingDirectional1stFrame[4],
						Math.round (sargeDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						sargeDyingDirectional1stFrame[3],
						Math.round ((-sargeDyingDirectional1stFrame[3].getWidth() + -sargeDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						sargeDyingDirectional1stFrame[2],
						Math.round ((-sargeDyingDirectional1stFrame[2].getWidth() + -sargeDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						sargeDyingDirectional1stFrame[1],
						Math.round ((-sargeDyingDirectional1stFrame[1].getWidth() + -sargeDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (sargeDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}
	
		if (state == SHOOTING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						sargeShooting1[animationCounter / 2],
						Math.round (sargeShooting1XOffset[animationCounter / 2] * scaling), 
						Math.round (sargeShooting1YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						sargeShooting2[animationCounter / 2],
						Math.round (sargeShooting2XOffset[animationCounter / 2] * scaling), 
						Math.round (sargeShooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						sargeShooting3[animationCounter / 2],
						Math.round (sargeShooting3XOffset[animationCounter / 2] * scaling), 
						Math.round (sargeShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						sargeShooting4[animationCounter / 2],
						Math.round (sargeShooting4XOffset[animationCounter / 2] * scaling), 
						Math.round (sargeShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						sargeShooting5[animationCounter / 2],
						Math.round (sargeShooting5XOffset[animationCounter / 2] * scaling), 
						Math.round (sargeShooting5YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						sargeShooting4[animationCounter / 2],
						Math.round ((-sargeShooting4[animationCounter / 2].getWidth() + -sargeShooting4XOffset[animationCounter / 2]) * scaling), 
						Math.round (sargeShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						sargeShooting3[animationCounter / 2],
						Math.round ((-sargeShooting3[animationCounter / 2].getWidth() + -sargeShooting3XOffset[animationCounter / 2]) * scaling), 
						Math.round (sargeShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						sargeShooting2[animationCounter / 2],
						Math.round ((-sargeShooting2[animationCounter /2].getWidth() + -sargeShooting2XOffset[animationCounter / 2]) * scaling), 
						Math.round (sargeShooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			}
			
			animationCounter++;
			if (animationCounter > 5)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && calculateDistance(doomGuy) < 30 * scaling) {
					state = SHOOTING;
				} else {
					state = WALKING;	
				}
			}
			return;
		}
		
		if (state == SPAWNING) {
			
			if (animationCounter > 7) {
				isSolid = true;
				drawScaled(
						sargeWalking1[0],
						Math.round (sargeWalking1XOffset[0] * scaling), 
						Math.round (sargeWalking1YOffset[0] * scaling), 
						offset,	c, 1);
			}
			if (animationCounter >= 0) {
				drawScaled(
						sprites.spawning[animationCounter],
						Math.round (sprites.spawningXOffset[animationCounter] * scaling), 
						Math.round (sprites.spawningYOffset[animationCounter] * scaling), 
						offset,	c, 1);	
			}
			
			animationCounter++;
			if (animationCounter > 9)  {
				animationCounter = 0;
				state = WALKING;
			}
			return;
		}
		
		if (state == WALKING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						sargeWalking1[animationCounter],
						Math.round (sargeWalking1XOffset[animationCounter] * scaling), 
						Math.round (sargeWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						sargeWalking2[animationCounter],
						Math.round (sargeWalking2XOffset[animationCounter] * scaling), 
						Math.round (sargeWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						sargeWalking3[animationCounter],
						Math.round (sargeWalking3XOffset[animationCounter] * scaling), 
						Math.round (sargeWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						sargeWalking4[animationCounter],
						Math.round (sargeWalking4XOffset[animationCounter] * scaling), 
						Math.round (sargeWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						sargeWalking5[animationCounter],
						Math.round (sargeWalking5XOffset[animationCounter] * scaling), 
						Math.round (sargeWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						sargeWalking4[animationCounter],
						Math.round ((-sargeWalking4[animationCounter].getWidth() + -sargeWalking4XOffset[animationCounter]) * scaling), 
						Math.round (sargeWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						sargeWalking3[animationCounter],
						Math.round ((-sargeWalking3[animationCounter].getWidth() + -sargeWalking3XOffset[animationCounter]) * scaling), 
						Math.round (sargeWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						sargeWalking2[animationCounter],
						Math.round ((-sargeWalking2[animationCounter].getWidth() + -sargeWalking2XOffset[animationCounter]) * scaling), 
						Math.round (sargeWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			}

			
			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && calculateDistance(doomGuy) < 30 * scaling) {
					state = SHOOTING;
				}
			}
			return;
		}
		
		if (state == DYING || state == DEAD) {
			
			if (animationCounter == 0 || animationCounter == 1) {
				switch (direction) {
				case 1:
					drawScaled(
							sargeDyingDirectional1stFrame[0],
							Math.round (sargeDyingDirectional1stFrameXOffset[0] * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[0] * scaling), 
							offset,	c, 1);
					break;
				case 2:
					drawScaled(
							sargeDyingDirectional1stFrame[1],
							Math.round (sargeDyingDirectional1stFrameXOffset[1] * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, 1);
					break;
				case 3:
					drawScaled(
							sargeDyingDirectional1stFrame[2],
							Math.round (sargeDyingDirectional1stFrameXOffset[2] * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, 1);
					break;
				case 4:
					drawScaled(
							sargeDyingDirectional1stFrame[3],
							Math.round (sargeDyingDirectional1stFrameXOffset[3] * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, 1);
					break;
				case 5:
					drawScaled(
							sargeDyingDirectional1stFrame[4],
							Math.round (sargeDyingDirectional1stFrameXOffset[4] * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[4] * scaling), 
							offset, c, 1);
					break;
				case 6:
					drawScaled(
							sargeDyingDirectional1stFrame[3],
							Math.round ((-sargeDyingDirectional1stFrame[3].getWidth() + -sargeDyingDirectional1stFrameXOffset[3]) * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, -1);
					break;
				case 7:
					drawScaled(
							sargeDyingDirectional1stFrame[2],
							Math.round ((-sargeDyingDirectional1stFrame[2].getWidth() + -sargeDyingDirectional1stFrameXOffset[2]) * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, -1);
					break;
				case 8:
					drawScaled(
							sargeDyingDirectional1stFrame[1],
							Math.round ((-sargeDyingDirectional1stFrame[1].getWidth() + -sargeDyingDirectional1stFrameXOffset[1]) * scaling), 
							Math.round (sargeDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, -1);
					break;
				}
			} else if (animationCounter < 13) {
				int counter = (int) Math.ceil((float) animationCounter / 2);
				drawScaled(
						sargeDeathFinalFrames[counter - 1],
						Math.round (sargeDeathFinalFramesXOffset[counter - 1] * scaling), 
						Math.round (sargeDeathFinalFramesYOffset[counter - 1] * scaling), 
						offset,	c, 1);
			} else {
				opacity =  Math.max(260 - (animationCounter), 0);
				drawScaledOpac(
						sargeDeathFinalFrames[5],
						Math.round (sargeDeathFinalFramesXOffset[5] * scaling), 
						Math.round (sargeDeathFinalFramesYOffset[5] * scaling), 
						offset,	c, 1, opacity);
			}
			
			
			animationCounter++;
			return;
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
	private void drawScaledOpac(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int flip, int opacity) {
		aMatrix.setScale(scaling * flip, scaling);
		if (flip == 1) {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset), yLoc + offsetY);	
		} else {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset) + (drawMe.getWidth() * scaling), yLoc + offsetY);
		}
		opacPaint.setAlpha(opacity);
		c.drawBitmap(drawMe, aMatrix, opacPaint);
	}
	
	/**
	 * 
	 * @param drawMe
	 * @param offsetX
	 * @param offsetY
	 * @param offset
	 * @param c
	 */
	private void drawScaled(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int flip) {
		aMatrix.setScale(scaling * flip, scaling);
		if (flip == 1) {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset), yLoc + offsetY);	
		} else {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset) + (drawMe.getWidth() * scaling), yLoc + offsetY);
		}
		c.drawBitmap(drawMe, aMatrix, null);
	}
	
	private float angle;
	
	public void calculateDirection(DoomGuy doomGuy) {
		
		angle = (float) Math.atan2(xSpeed, -ySpeed) * 180f / (float) Math.PI;
		
		if (doomGuy.state == DoomGuy.WALKING || doomGuy.state == DoomGuy.SHOOTING) {
			angle = (float) Math.atan2(doomGuy.xLoc - xLoc, -(doomGuy.yLoc - yLoc)) * 180f / (float) Math.PI;	
		}
		
		if (angle >= -22.5 && angle <= 22.5) {
			direction = 5;
			return;
		}
		if (angle >= 22.5 && angle <= 67.5) {
			direction = 6;
			return;
		}
		if (angle >= 67.5 && angle <= 112.5) {
			direction = 7;
			return;
		}
		if (angle >= 112.5 && angle <= 157.5) {
			direction = 8;
			return;
		}
		if (angle >= 157.5 || angle <= -157.5) {
			direction = 1;
			return;
		}
		if (angle >= -157.5 && angle <= -112.5) {
			direction = 2;
			return;
		}
		if (angle >= -112.5 && angle <= -67.5) {
			direction = 3;
			return;
		}
		if (angle >= -67.5 && angle <= -22.5) {
			direction = 4;
			return;
		}
		direction = 1;
	}	
	
	
	private float xDiff;
	private float yDiff;
	private boolean isOkToMove;
	
	public void updateState(DoomGuy doomGuy, boolean godMode, Random random, ArrayList<Actor> projectiles, ArrayList<Actor> actors, ArrayList<BloodSplatter> bloodSplatter, ArrayList<PowerUp> powerUpList) {
		if (state == WALKING && doomGuy.state != DoomGuy.SPAWNING) {
			
			if (Math.abs(xLoc - doomGuy.xLoc) > 50
					|| Math.abs(yLoc - doomGuy.yLoc) > 50) {
				
				xDiff = doomGuy.xLoc - xLoc;
				yDiff = doomGuy.yLoc - yLoc;
				
				if (Math.abs(xDiff) > Math.abs(yDiff)) {
					if (xDiff < 0) {
						xSpeed = -6;
					} else {
						xSpeed = 6;
					}
					if (yDiff < 0) {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -6;
					} else {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 6;
					}
				} else {
					if (yDiff < 0) {
						ySpeed = -6;
					} else {
						ySpeed = 6;
					}
					if (xDiff < 0) {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -6;
					} else {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 6;
					}
				}
			}
			
			xSpeed *= random.nextFloat() + 1;
			ySpeed *= random.nextFloat() + 1;
			
			
			isOkToMove = true;
			for (Actor actor : actors) {
				
				if (actor instanceof Sarge && actor.isSolid && calculateDistance(actor) < 20 * scaling) {
					if (calculateDistanceAfterMove(actor) < calculateDistance(actor)) {
						isOkToMove = false;
					}
				}				
			}
			if (isOkToMove) {
				xLoc += (xSpeed * (1 + (yLoc * SCALING)));
				yLoc += (ySpeed * (1 + (yLoc * SCALING)));	
			}
		}
		if (state == SHOOTING && animationCounter == 1) {
			if (random.nextFloat() > 0.2 && !godMode) {
				doomGuy.health -= 3;
				doomGuy.takingDamage = true;
				bloodSplatter.add(doomGuy.createBloodSplatter(random));
			}
		}
	}

}
