package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class PistolGuy extends Baddie {
	

	public Matrix aMatrix;
	public int width;
	
	public final static int RESPAWN_TIME = 100;
	
	
	public int direction;
	public float scaling = 1;
	
	public static final int SPEED = 2;
	
	public Bitmap[] pistolGuyWalking1 = new Bitmap[4];
	public int[] pistolGuyWalking1XOffset = new int[] {-18, -19, -17, -16};
	public int[] pistolGuyWalking1YOffset = new int[] {-50, -52, -50, -52};
	
	public Bitmap[] pistolGuyWalking2 = new Bitmap[4];
	public int[] pistolGuyWalking2XOffset = new int[] {-17, -18, -17, -18};
	public int[] pistolGuyWalking2YOffset = new int[] {-50, -52, -50, -51};
	
	public Bitmap[] pistolGuyWalking3 = new Bitmap[4];
	public int[] pistolGuyWalking3XOffset = new int[] {-21, -18, -18, -21};
	public int[] pistolGuyWalking3YOffset = new int[] {-50, -52, -52, -52};
	
	public Bitmap[] pistolGuyWalking4 = new Bitmap[4];
	public int[] pistolGuyWalking4XOffset = new int[] {-21, -20, -20, -22};
	public int[] pistolGuyWalking4YOffset = new int[] {-48, -52, -51, -52};
	
	public Bitmap[] pistolGuyWalking5 = new Bitmap[4];
	public int[] pistolGuyWalking5XOffset = new int[] {-21, -18, -17, -19};
	public int[] pistolGuyWalking5YOffset = new int[] {-47, -51, -50, -51};
	
	public Bitmap[] pistolGuyShooting1 = new Bitmap[3];
	public int[] pistolGuyShooting1XOffset = new int[] {-12, -13, -12};
	public int[] pistolGuyShooting1YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] pistolGuyShooting2 = new Bitmap[3];
	public int[] pistolGuyShooting2XOffset = new int[] {-21, -23, -21};
	public int[] pistolGuyShooting2YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] pistolGuyShooting3 = new Bitmap[3];
	public int[] pistolGuyShooting3XOffset = new int[] {-26, -27, -26};
	public int[] pistolGuyShooting3YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] pistolGuyShooting4 = new Bitmap[3];
	public int[] pistolGuyShooting4XOffset = new int[] {-18, -20, -18};
	public int[] pistolGuyShooting4YOffset = new int[] {-48, -48, -48};
	
	public Bitmap[] pistolGuyShooting5 = new Bitmap[3];
	public int[] pistolGuyShooting5XOffset = new int[] {-12, -11, -12};
	public int[] pistolGuyShooting5YOffset = new int[] {-46, -46, -46};
	
	public Bitmap[] pistolGuyDyingDirectional1stFrame = new Bitmap[5];
	public int[] pistolGuyDyingDirectional1stFrameXOffset = new int[] {-20, -16, -21, -20, -17};
	public int[] pistolGuyDyingDirectional1stFrameYOffset = new int[] {-52, -53, -53, -51, -49};
	
	public Bitmap[] pistolGuyDeathFinalFrames = new Bitmap[5];
	public int[] pistolGuyDeathFinalFramesXOffset = new int[] {-29, -16, -22, -23, -22};
	public int[] pistolGuyDeathFinalFramesYOffset = new int[] {-52, -47, -42, -29, -12};
	
	public Bitmap[] pistolGuyRocketDeath = new Bitmap[9];
	public int[] pistolGuyRocketDeathXOffset = new int[]{-19, -18, -25, -24, -27, -24, -24, -24, -24};
	public int[] pistolGuyRocketDeathYOffset = new int[]{-56, -59, -58, -52, -47, -39, -32, -22, -17};
		
	// constructor to populate stuff
	public PistolGuy(Resources res) {
		opacPaint = new Paint();		
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;
		
		pistolGuyWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.possa1);
		pistolGuyWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.possb1);
		pistolGuyWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.possc1);
		pistolGuyWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.possd1);
		
		pistolGuyWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.possa2a8);
		pistolGuyWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.possb2b8);
		pistolGuyWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.possc2c8);
		pistolGuyWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.possd2d8);
		
		pistolGuyWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.possa3a7);
		pistolGuyWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.possb3b7);
		pistolGuyWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.possc3c7);
		pistolGuyWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.possd3d7);
		
		pistolGuyWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.possa4a6);
		pistolGuyWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.possb4b6);
		pistolGuyWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.possc4c6);
		pistolGuyWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.possd4d6);
		
		pistolGuyWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.possa5);
		pistolGuyWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.possb5);
		pistolGuyWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.possc5);
		pistolGuyWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.possd5);
		
		pistolGuyShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.posse1);
		pistolGuyShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.possf1);
		pistolGuyShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.posse1);
		
		pistolGuyShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.posse2e8);
		pistolGuyShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.possf2f8);
		pistolGuyShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.posse2e8);
		
		pistolGuyShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.posse3e7);
		pistolGuyShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.possf3f7);
		pistolGuyShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.posse3e7);
		
		pistolGuyShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.posse4e6);
		pistolGuyShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.possf4f6);
		pistolGuyShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.posse4e6);
		
		pistolGuyShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.posse5);
		pistolGuyShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.possf5);
		pistolGuyShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.posse5);
		
		pistolGuyDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.possg1);
		pistolGuyDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.possg2g8);
		pistolGuyDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.possg3g7);
		pistolGuyDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.possg4g6);
		pistolGuyDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.possg5);
		
		pistolGuyDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.possh0);
		pistolGuyDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.possi0);
		pistolGuyDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.possj0);
		pistolGuyDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.possk0);
		pistolGuyDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.possl0);
		
		pistolGuyRocketDeath[0] = BitmapFactory.decodeResource(res, R.drawable.possm0);
		pistolGuyRocketDeath[1] = BitmapFactory.decodeResource(res, R.drawable.possn0);
		pistolGuyRocketDeath[2] = BitmapFactory.decodeResource(res, R.drawable.posso0);
		pistolGuyRocketDeath[3] = BitmapFactory.decodeResource(res, R.drawable.possp0);
		pistolGuyRocketDeath[4] = BitmapFactory.decodeResource(res, R.drawable.possq0);
		pistolGuyRocketDeath[5] = BitmapFactory.decodeResource(res, R.drawable.possr0);
		pistolGuyRocketDeath[6] = BitmapFactory.decodeResource(res, R.drawable.posss0);
		pistolGuyRocketDeath[7] = BitmapFactory.decodeResource(res, R.drawable.posst0);
		pistolGuyRocketDeath[8] = BitmapFactory.decodeResource(res, R.drawable.possu0);
	}
	
	public void draw(Canvas c, float offset, DoomGuy doomGuy, int width, int height, Sprites sprites) {
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
						pistolGuyDyingDirectional1stFrame[0],
						Math.round (pistolGuyDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[1],
						Math.round (pistolGuyDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[2],
						Math.round (pistolGuyDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[3],
						Math.round (pistolGuyDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[4],
						Math.round (pistolGuyDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[3],
						Math.round ((-pistolGuyDyingDirectional1stFrame[3].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[2],
						Math.round ((-pistolGuyDyingDirectional1stFrame[2].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						pistolGuyDyingDirectional1stFrame[1],
						Math.round ((-pistolGuyDyingDirectional1stFrame[1].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (pistolGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}
		
		if (state == SHOOTING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						pistolGuyShooting1[animationCounter],
						Math.round (pistolGuyShooting1XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyShooting1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						pistolGuyShooting2[animationCounter],
						Math.round (pistolGuyShooting2XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyShooting2YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						pistolGuyShooting3[animationCounter],
						Math.round (pistolGuyShooting3XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						pistolGuyShooting4[animationCounter],
						Math.round (pistolGuyShooting4XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						pistolGuyShooting5[animationCounter],
						Math.round (pistolGuyShooting5XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyShooting5YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						pistolGuyShooting4[animationCounter],
						Math.round ((-pistolGuyShooting4[animationCounter].getWidth() + -pistolGuyShooting4XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						pistolGuyShooting3[animationCounter],
						Math.round ((-pistolGuyShooting3[animationCounter].getWidth() + -pistolGuyShooting3XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						pistolGuyShooting2[animationCounter],
						Math.round ((-pistolGuyShooting2[animationCounter].getWidth() + -pistolGuyShooting2XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyShooting2YOffset[animationCounter] * scaling), 
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
						pistolGuyWalking1[0],
						Math.round (pistolGuyWalking1XOffset[0] * scaling), 
						Math.round (pistolGuyWalking1YOffset[0] * scaling), 
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
						pistolGuyWalking1[animationCounter],
						Math.round (pistolGuyWalking1XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						pistolGuyWalking2[animationCounter],
						Math.round (pistolGuyWalking2XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						pistolGuyWalking3[animationCounter],
						Math.round (pistolGuyWalking3XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						pistolGuyWalking4[animationCounter],
						Math.round (pistolGuyWalking4XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						pistolGuyWalking5[animationCounter],
						Math.round (pistolGuyWalking5XOffset[animationCounter] * scaling), 
						Math.round (pistolGuyWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						pistolGuyWalking4[animationCounter],
						Math.round ((-pistolGuyWalking4[animationCounter].getWidth() + -pistolGuyWalking4XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						pistolGuyWalking3[animationCounter],
						Math.round ((-pistolGuyWalking3[animationCounter].getWidth() + -pistolGuyWalking3XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						pistolGuyWalking2[animationCounter],
						Math.round ((-pistolGuyWalking2[animationCounter].getWidth() + -pistolGuyWalking2XOffset[animationCounter]) * scaling), 
						Math.round (pistolGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			}

			
			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && Math.random() > 0.60) {
					state = SHOOTING;
				}
			}
			return;
		}
		
		if (state == DYING || state == DEAD) {
			
			if (killedByRocket) {
				if (animationCounter < 9) {
					drawScaled(
							pistolGuyRocketDeath[animationCounter],
							Math.round (pistolGuyRocketDeathXOffset[animationCounter] * scaling),
							Math.round (pistolGuyRocketDeathYOffset[animationCounter] * scaling), 
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							pistolGuyRocketDeath[8],
							Math.round (pistolGuyRocketDeathXOffset[8] * scaling), 
							Math.round (pistolGuyRocketDeathYOffset[8] * scaling), 
							offset,	c, 1, opacity);
				}
			} else {
				if (animationCounter == 0 || animationCounter == 1) {
					switch (direction) {
					case 1:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[0],
								Math.round (pistolGuyDyingDirectional1stFrameXOffset[0] * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[0] * scaling), 
								offset,	c, 1);
						break;
					case 2:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[1],
								Math.round (pistolGuyDyingDirectional1stFrameXOffset[1] * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, 1);
						break;
					case 3:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[2],
								Math.round (pistolGuyDyingDirectional1stFrameXOffset[2] * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, 1);
						break;
					case 4:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[3],
								Math.round (pistolGuyDyingDirectional1stFrameXOffset[3] * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, 1);
						break;
					case 5:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[4],
								Math.round (pistolGuyDyingDirectional1stFrameXOffset[4] * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[4] * scaling), 
								offset, c, 1);
						break;
					case 6:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[3],
								Math.round ((-pistolGuyDyingDirectional1stFrame[3].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, -1);
						break;
					case 7:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[2],
								Math.round ((-pistolGuyDyingDirectional1stFrame[2].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, -1);
						break;
					case 8:
						drawScaled(
								pistolGuyDyingDirectional1stFrame[1],
								Math.round ((-pistolGuyDyingDirectional1stFrame[1].getWidth() + -pistolGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
								Math.round (pistolGuyDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, -1);
						break;
					}
				} else if (animationCounter < 11) {
					int counter = (int) Math.ceil((float) animationCounter / 2);
					drawScaled(
							pistolGuyDeathFinalFrames[counter - 1],
							Math.round (pistolGuyDeathFinalFramesXOffset[counter - 1] * scaling), 
							Math.round (pistolGuyDeathFinalFramesYOffset[counter - 1] * scaling), 
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							pistolGuyDeathFinalFrames[4],
							Math.round (pistolGuyDeathFinalFramesXOffset[4] * scaling), 
							Math.round (pistolGuyDeathFinalFramesYOffset[4] * scaling), 
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
	private void drawScaled(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int flip) {
		aMatrix.setScale(scaling * flip, scaling);
		if (flip == 1) {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset), yLoc + offsetY);	
		} else {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset) + (drawMe.getWidth() * scaling), yLoc + offsetY);
		}
		c.drawBitmap(drawMe, aMatrix, null);
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
	boolean isOkToMove;
	
	public void updateState(DoomGuy doomGuy, boolean godMode, Random random, ArrayList<Actor> projectiles, ArrayList<Actor> actors, ArrayList<BloodSplatter> bloodSplatter, ArrayList<PowerUp> powerUpList) {
		
		if (!hasDroppedPowerUp && health <= 0) {
			hasDroppedPowerUp = true;
			PowerUp powerUp = new PowerUp();
			powerUp.collected = false;
			powerUp.spawned = true;
			powerUp.xLoc = xLoc;
			powerUp.yLoc = yLoc + 2;
			powerUp.type = PowerUp.AMMO_CLIP;
			powerUpList.add(powerUp);
		}
		
		if (state == WALKING && doomGuy.state != DoomGuy.SPAWNING) {
			
			if (Math.abs(xLoc - doomGuy.xLoc) > 50
					|| Math.abs(yLoc - doomGuy.yLoc) > 50) {
				
				xDiff = doomGuy.xLoc - xLoc;
				yDiff = doomGuy.yLoc - yLoc;
				
				if (Math.abs(xDiff) > Math.abs(yDiff)) {
					if (xDiff < 0) {
						xSpeed = -4;
					} else {
						xSpeed = 3;
					}
					if (yDiff < 0) {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -4;
					} else {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 4;
					}
				} else {
					if (yDiff < 0) {
						ySpeed = -3;
					} else {
						ySpeed = 4;
					}
					if (xDiff < 0) {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -4;
					} else {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 4;
					}
				}
			}
			
			xSpeed *= random.nextFloat() + 0.3;
			ySpeed *= random.nextFloat() + 0.3;

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
				doomGuy.health -= 1;
				doomGuy.takingDamage = true;
				bloodSplatter.add(doomGuy.createBloodSplatter(random));
			}
		}
	}

}
