package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class ShotgunGuy extends Baddie {
	
	public Matrix aMatrix;
	
	public int width;
	
	public final static int RESPAWN_TIME = 100;
	
	public int direction;
	public float scaling = 1;
	
	public static final int SPEED = 2;
	
	public Bitmap[] shotgunGuyWalking1 = new Bitmap[4];
	public int[] shotgunGuyWalking1XOffset = new int[] {-18, -19, -17, -16};
	public int[] shotgunGuyWalking1YOffset = new int[] {-50, -52, -50, -52};
	
	public Bitmap[] shotgunGuyWalking2 = new Bitmap[4];
	public int[] shotgunGuyWalking2XOffset = new int[] {-17, -18, -17, -17};
	public int[] shotgunGuyWalking2YOffset = new int[] {-50, -52, -51, -52};
	
	public Bitmap[] shotgunGuyWalking3 = new Bitmap[4];
	public int[] shotgunGuyWalking3XOffset = new int[] {-21, -18, -18, -21};
	public int[] shotgunGuyWalking3YOffset = new int[] {-50, -52, -51, -52};
	
	public Bitmap[] shotgunGuyWalking4 = new Bitmap[4];
	public int[] shotgunGuyWalking4XOffset = new int[] {-21, -21, -22, -23};
	public int[] shotgunGuyWalking4YOffset = new int[] {-49, -52, -51, -52};
	
	public Bitmap[] shotgunGuyWalking5 = new Bitmap[4];
	public int[] shotgunGuyWalking5XOffset = new int[] {-21, -18, -17, -19};
	public int[] shotgunGuyWalking5YOffset = new int[] {-47, -51, -50, -51};
	
	public Bitmap[] shotgunGuyShooting1 = new Bitmap[3];
	public int[] shotgunGuyShooting1XOffset = new int[] {-12, -13, -12};
	public int[] shotgunGuyShooting1YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] shotgunGuyShooting2 = new Bitmap[3];
	public int[] shotgunGuyShooting2XOffset = new int[] {-17, -21, -17};
	public int[] shotgunGuyShooting2YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] shotgunGuyShooting3 = new Bitmap[3];
	public int[] shotgunGuyShooting3XOffset = new int[] {-19, -24, -19};
	public int[] shotgunGuyShooting3YOffset = new int[] {-49, -49, -49};
	
	public Bitmap[] shotgunGuyShooting4 = new Bitmap[3];
	public int[] shotgunGuyShooting4XOffset = new int[] {-14, -19, -14};
	public int[] shotgunGuyShooting4YOffset = new int[] {-48, -48, -48};
	
	public Bitmap[] shotgunGuyShooting5 = new Bitmap[3];
	public int[] shotgunGuyShooting5XOffset = new int[] {-12, -11, -12};
	public int[] shotgunGuyShooting5YOffset = new int[] {-46, -46, -46};
	
	public Bitmap[] shotgunGuyDyingDirectional1stFrame = new Bitmap[5];
	public int[] shotgunGuyDyingDirectional1stFrameXOffset = new int[] {-12, -13, -21, -20, -17};
	public int[] shotgunGuyDyingDirectional1stFrameYOffset = new int[] {-52, -51, -50, -50, -49};
	
	public Bitmap[] shotgunGuyDeathFinalFrames = new Bitmap[5];
	public int[] shotgunGuyDeathFinalFramesXOffset = new int[] {-14, -16, -22, -23, -24};
	public int[] shotgunGuyDeathFinalFramesYOffset = new int[] {-57, -51, -43, -29, -12};
	
	public Bitmap[] shotgunGuyRocketDeath = new Bitmap[9];
	public int[] shotgunGuyRocketDeathXOffset = new int[]{-14, -18, -25, -24, -27, -24, -24, -24, -24};
	public int[] shotgunGuyRocketDeathYOffset = new int[]{-56, -59, -58, -52, -47, -39, -32, -22, -17};
	
	// constructor to populate stuff
	public ShotgunGuy(Resources res) {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;
		
		shotgunGuyWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.sposa1);
		shotgunGuyWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.sposb1);
		shotgunGuyWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.sposc1);
		shotgunGuyWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.sposd1);
		
		shotgunGuyWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.sposa2a8);
		shotgunGuyWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.sposb2b8);
		shotgunGuyWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.sposc2c8);
		shotgunGuyWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.sposd2d8);
		
		shotgunGuyWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.sposa3a7);
		shotgunGuyWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.sposb3b7);
		shotgunGuyWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.sposc3c7);
		shotgunGuyWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.sposd3d7);
		
		shotgunGuyWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.sposa4a6);
		shotgunGuyWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.sposb4b6);
		shotgunGuyWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.sposc4c6);
		shotgunGuyWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.sposd4d6);
		
		shotgunGuyWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.sposa5);
		shotgunGuyWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.sposb5);
		shotgunGuyWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.sposc5);
		shotgunGuyWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.sposd5);
		
		shotgunGuyShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.spose1);
		shotgunGuyShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.sposf1);
		shotgunGuyShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.spose1);
		
		shotgunGuyShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.spose2e8);
		shotgunGuyShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.sposf2f8);
		shotgunGuyShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.spose2e8);
		
		shotgunGuyShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.spose3e7);
		shotgunGuyShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.sposf3f7);
		shotgunGuyShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.spose3e7);
		
		shotgunGuyShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.spose4e6);
		shotgunGuyShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.sposf4f6);
		shotgunGuyShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.spose4e6);
		
		shotgunGuyShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.spose5);
		shotgunGuyShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.sposf5);
		shotgunGuyShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.spose5);
		
		shotgunGuyDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.sposg1);
		shotgunGuyDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.sposg2g8);
		shotgunGuyDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.sposg3g7);
		shotgunGuyDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.sposg4g6);
		shotgunGuyDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.sposg5);
		
		shotgunGuyDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.sposh0);
		shotgunGuyDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.sposi0);
		shotgunGuyDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.sposj0);
		shotgunGuyDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.sposk0);
		shotgunGuyDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.sposl0);
		
		shotgunGuyRocketDeath[0] = BitmapFactory.decodeResource(res, R.drawable.sposm0);
		shotgunGuyRocketDeath[1] = BitmapFactory.decodeResource(res, R.drawable.sposn0);
		shotgunGuyRocketDeath[2] = BitmapFactory.decodeResource(res, R.drawable.sposo0);
		shotgunGuyRocketDeath[3] = BitmapFactory.decodeResource(res, R.drawable.sposp0);
		shotgunGuyRocketDeath[4] = BitmapFactory.decodeResource(res, R.drawable.sposq0);
		shotgunGuyRocketDeath[5] = BitmapFactory.decodeResource(res, R.drawable.sposr0);
		shotgunGuyRocketDeath[6] = BitmapFactory.decodeResource(res, R.drawable.sposs0);
		shotgunGuyRocketDeath[7] = BitmapFactory.decodeResource(res, R.drawable.spost0);
		shotgunGuyRocketDeath[8] = BitmapFactory.decodeResource(res, R.drawable.sposu0);
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
						shotgunGuyDyingDirectional1stFrame[0],
						Math.round (shotgunGuyDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[1],
						Math.round (shotgunGuyDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[2],
						Math.round (shotgunGuyDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[3],
						Math.round (shotgunGuyDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[4],
						Math.round (shotgunGuyDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[3],
						Math.round ((-shotgunGuyDyingDirectional1stFrame[3].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[2],
						Math.round ((-shotgunGuyDyingDirectional1stFrame[2].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						shotgunGuyDyingDirectional1stFrame[1],
						Math.round ((-shotgunGuyDyingDirectional1stFrame[1].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (shotgunGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}
	
		if (state == SHOOTING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						shotgunGuyShooting1[animationCounter],
						Math.round (shotgunGuyShooting1XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyShooting1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						shotgunGuyShooting2[animationCounter],
						Math.round (shotgunGuyShooting2XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyShooting2YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						shotgunGuyShooting3[animationCounter],
						Math.round (shotgunGuyShooting3XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						shotgunGuyShooting4[animationCounter],
						Math.round (shotgunGuyShooting4XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						shotgunGuyShooting5[animationCounter],
						Math.round (shotgunGuyShooting5XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyShooting5YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						shotgunGuyShooting4[animationCounter],
						Math.round ((-shotgunGuyShooting4[animationCounter].getWidth() + -shotgunGuyShooting4XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						shotgunGuyShooting3[animationCounter],
						Math.round ((-shotgunGuyShooting3[animationCounter].getWidth() + -shotgunGuyShooting3XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						shotgunGuyShooting2[animationCounter],
						Math.round ((-shotgunGuyShooting2[animationCounter].getWidth() + -shotgunGuyShooting2XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyShooting2YOffset[animationCounter] * scaling), 
						offset,	c, -1);
				break;
			}
			
			animationCounter++;
			if (animationCounter > 2)  {
				animationCounter = 0;
				state = WALKING;
			}
			return;
		}
		
		if (state == SPAWNING) {
			
			if (animationCounter > 7) {
				isSolid = true;
				drawScaled(
						shotgunGuyWalking1[0],
						Math.round (shotgunGuyWalking1XOffset[0] * scaling), 
						Math.round (shotgunGuyWalking1YOffset[0] * scaling), 
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
						shotgunGuyWalking1[animationCounter],
						Math.round (shotgunGuyWalking1XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						shotgunGuyWalking2[animationCounter],
						Math.round (shotgunGuyWalking2XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						shotgunGuyWalking3[animationCounter],
						Math.round (shotgunGuyWalking3XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						shotgunGuyWalking4[animationCounter],
						Math.round (shotgunGuyWalking4XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						shotgunGuyWalking5[animationCounter],
						Math.round (shotgunGuyWalking5XOffset[animationCounter] * scaling), 
						Math.round (shotgunGuyWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						shotgunGuyWalking4[animationCounter],
						Math.round ((-shotgunGuyWalking4[animationCounter].getWidth() + -shotgunGuyWalking4XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						shotgunGuyWalking3[animationCounter],
						Math.round ((-shotgunGuyWalking3[animationCounter].getWidth() + -shotgunGuyWalking3XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						shotgunGuyWalking2[animationCounter],
						Math.round ((-shotgunGuyWalking2[animationCounter].getWidth() + -shotgunGuyWalking2XOffset[animationCounter]) * scaling), 
						Math.round (shotgunGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			}

			
			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && Math.random() > 0.80) {
					state = SHOOTING;
				}
			}
			return;
		}
		
		if (state == DYING || state == DEAD) {
			
			if (killedByRocket) {
				if (animationCounter < 9) {
					drawScaled(
							shotgunGuyRocketDeath[animationCounter],
							Math.round (shotgunGuyRocketDeathXOffset[animationCounter] * scaling), 
							Math.round (shotgunGuyRocketDeathYOffset[animationCounter] * scaling),
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							shotgunGuyRocketDeath[8],
							Math.round (shotgunGuyRocketDeathXOffset[8] * scaling), 
							Math.round (shotgunGuyRocketDeathYOffset[8] * scaling), 
							offset,	c, 1, opacity);
				}
			} else {
				if (animationCounter == 0 || animationCounter == 1) {
					switch (direction) {
					case 1:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[0],
								Math.round (shotgunGuyDyingDirectional1stFrameXOffset[0] * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[0] * scaling), 
								offset,	c, 1);
						break;
					case 2:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[1],
								Math.round (shotgunGuyDyingDirectional1stFrameXOffset[1] * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, 1);
						break;
					case 3:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[2],
								Math.round (shotgunGuyDyingDirectional1stFrameXOffset[2] * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, 1);
						break;
					case 4:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[3],
								Math.round (shotgunGuyDyingDirectional1stFrameXOffset[3] * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, 1);
						break;
					case 5:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[4],
								Math.round (shotgunGuyDyingDirectional1stFrameXOffset[4] * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[4] * scaling), 
								offset, c, 1);
						break;
					case 6:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[3],
								Math.round ((-shotgunGuyDyingDirectional1stFrame[3].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, -1);
						break;
					case 7:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[2],
								Math.round ((-shotgunGuyDyingDirectional1stFrame[2].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, -1);
						break;
					case 8:
						drawScaled(
								shotgunGuyDyingDirectional1stFrame[1],
								Math.round ((-shotgunGuyDyingDirectional1stFrame[1].getWidth() + -shotgunGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
								Math.round (shotgunGuyDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, -1);
						break;
					}
				} else if (animationCounter < 11) {
					int counter = (int) Math.ceil((float) animationCounter / 2);
					drawScaled(
							shotgunGuyDeathFinalFrames[counter - 1],
							Math.round (shotgunGuyDeathFinalFramesXOffset[counter - 1] * scaling), 
							Math.round (shotgunGuyDeathFinalFramesYOffset[counter - 1] * scaling), 
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							shotgunGuyDeathFinalFrames[4],
							Math.round (shotgunGuyDeathFinalFramesXOffset[4] * scaling), 
							Math.round (shotgunGuyDeathFinalFramesYOffset[4] * scaling), 
							offset,	c, 1, opacity);
				}
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
		
		if (!hasDroppedPowerUp && health <= 0) {
			hasDroppedPowerUp = true;
			PowerUp powerUp = new PowerUp();
			powerUp.collected = false;
			powerUp.spawned = true;
			powerUp.xLoc = xLoc;
			powerUp.yLoc = yLoc + 2;
			powerUp.type = PowerUp.SHOTGUN;
			powerUpList.add(powerUp);
		}
		if (state == WALKING && doomGuy.state != DoomGuy.SPAWNING) {
			
			if (Math.abs(xLoc - doomGuy.xLoc) > 50
					|| Math.abs(yLoc - doomGuy.yLoc) > 50) {
				
				xDiff = doomGuy.xLoc - xLoc;
				yDiff = doomGuy.yLoc - yLoc;
				
				if (Math.abs(xDiff) > Math.abs(yDiff)) {
					if (xDiff < 0) {
						xSpeed = -3;
					} else {
						xSpeed = 4;
					}
					if (yDiff < 0) {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -4;
					} else {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 4;
					}
				} else {
					if (yDiff < 0) {
						ySpeed = -4;
					} else {
						ySpeed = 3;
					}
					if (xDiff < 0) {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -4;
					} else {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 4;
					}
				}
			}
			
			xSpeed *= random.nextFloat() + 0.2;
			ySpeed *= random.nextFloat() + 0.2;
			
			
			isOkToMove = true;
			for (Actor actor : actors) {
				
				if (actor.isSolid && calculateDistance(actor) < 15 * scaling) {
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
			if (random.nextFloat() > (calculateDistance(doomGuy) / 1000) && !godMode) {
				doomGuy.health -= 3;
				doomGuy.takingDamage = true;
				bloodSplatter.add(doomGuy.createBloodSplatter(random));
			}
		}
	}

}
