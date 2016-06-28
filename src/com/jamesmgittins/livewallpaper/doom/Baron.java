package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Baron extends Baddie {
	
	public Matrix aMatrix;
	
	public int width;
	
	public final static int RESPAWN_TIME = 100;
	
	public int direction;
	public float scaling = 1;
	
	public static final int SPEED = 2;
	
	public Bitmap[] baronWalking1 = new Bitmap[4];
	public int[] baronWalking1XOffset = new int[] {-19, -23, -20, -24};
	public int[] baronWalking1YOffset = new int[] {-69, -72, -69, -72};
	
	public Bitmap[] baronWalking2 = new Bitmap[4];
	public int[] baronWalking2XOffset = new int[] {-20, -21, -26, -25};
	public int[] baronWalking2YOffset = new int[] {-68, -70, -69, -71};
	
	public Bitmap[] baronWalking3 = new Bitmap[4];
	public int[] baronWalking3XOffset = new int[] {-26, -19, -23, -21};
	public int[] baronWalking3YOffset = new int[] {-66, -69, -66, -69};
	
	public Bitmap[] baronWalking4 = new Bitmap[4];
	public int[] baronWalking4XOffset = new int[] {-22, -24, -18, -18};
	public int[] baronWalking4YOffset = new int[] {-64, -67, -64, -66};
	
	public Bitmap[] baronWalking5 = new Bitmap[4];
	public int[] baronWalking5XOffset = new int[] {-19, -24, -20, -21};
	public int[] baronWalking5YOffset = new int[] {-65, -66, -65, -66};
	
	public Bitmap[] baronShooting1 = new Bitmap[3];
	public int[] baronShooting1XOffset = new int[] {-30, -34, -14};
	public int[] baronShooting1YOffset = new int[] {-65, -65, -59};
	
	public Bitmap[] baronShooting2 = new Bitmap[3];
	public int[] baronShooting2XOffset = new int[] {-12, -29, -29};
	public int[] baronShooting2YOffset = new int[] {-67, -65, -59};
	
	public Bitmap[] baronShooting3 = new Bitmap[3];
	public int[] baronShooting3XOffset = new int[] {-30, -29, -26};
	public int[] baronShooting3YOffset = new int[] {-62, -64, -58};
	
	public Bitmap[] baronShooting4 = new Bitmap[3];
	public int[] baronShooting4XOffset = new int[] {-27, -30, -25};
	public int[] baronShooting4YOffset = new int[] {-63, -64, -56};
	
	public Bitmap[] baronShooting5 = new Bitmap[3];
	public int[] baronShooting5XOffset = new int[] {-28, -28, -30};
	public int[] baronShooting5YOffset = new int[] {-69, -62, -55};
	
	public Bitmap[] baronDyingDirectional1stFrame = new Bitmap[5];
	public int[] baronDyingDirectional1stFrameXOffset = new int[] {-23, -26, -25, -26, -22};
	public int[] baronDyingDirectional1stFrameYOffset = new int[] {-69, -68, -67, -64, -62};
	
	public Bitmap[] baronDeathFinalFrames = new Bitmap[7];
	public int[] baronDeathFinalFramesXOffset = new int[] {-20, -26, -26, -29, -30, -30, -30};
	public int[] baronDeathFinalFramesYOffset = new int[] {-69, -60, -50, -32, -26, -26, -26};
	
	// constructor to populate stuff
	public Baron(Resources res) {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;
		
		baronWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.bossa1);
		baronWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.bossb1);
		baronWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.bossc1);
		baronWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.bossd1);
		
		baronWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.bossa2a8);
		baronWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.bossb2b8);
		baronWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.bossc2c8);
		baronWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.bossd2d8);
		
		baronWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.bossa3a7);
		baronWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.bossb3b7);
		baronWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.bossc3c7);
		baronWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.bossd3d7);
		
		baronWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.bossa4a6);
		baronWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.bossb4b6);
		baronWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.bossc4c6);
		baronWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.bossd4d6);
		
		baronWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.bossa5);
		baronWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.bossb5);
		baronWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.bossc5);
		baronWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.bossd5);
		
		baronShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.bosse1);
		baronShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.bossf1);
		baronShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.bossg1);
		
		baronShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.bosse2);
		baronShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.bossf2);
		baronShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.bossg2);
		
		baronShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.bosse3);
		baronShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.bossf3);
		baronShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.bossg3);
		
		baronShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.bosse4);
		baronShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.bossf4);
		baronShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.bossg4);
		
		baronShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.bosse5);
		baronShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.bossf5);
		baronShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.bossg5);
		
		baronDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.bossh1);
		baronDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.bossh2);
		baronDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.bossh3);
		baronDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.bossh4);
		baronDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.bossh5);
		
		baronDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.bossi0);
		baronDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.bossj0);
		baronDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.bossk0);
		baronDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.bossl0);
		baronDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.bossm0);
		baronDeathFinalFrames[5] = BitmapFactory.decodeResource(res, R.drawable.bossn0);
		baronDeathFinalFrames[6] = BitmapFactory.decodeResource(res, R.drawable.bosso0);
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
			if (state == SHOOTING) {
				animationCounter++;
				if (animationCounter > 5)  {
					animationCounter = 0;
					state = WALKING;
				}
			}
			switch (direction) {
			case 1:
				drawScaled(
						baronDyingDirectional1stFrame[0],
						Math.round (baronDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						baronDyingDirectional1stFrame[1],
						Math.round (baronDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						baronDyingDirectional1stFrame[2],
						Math.round (baronDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						baronDyingDirectional1stFrame[3],
						Math.round (baronDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						baronDyingDirectional1stFrame[4],
						Math.round (baronDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						baronDyingDirectional1stFrame[3],
						Math.round ((-baronDyingDirectional1stFrame[3].getWidth() + -baronDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						baronDyingDirectional1stFrame[2],
						Math.round ((-baronDyingDirectional1stFrame[2].getWidth() + -baronDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						baronDyingDirectional1stFrame[1],
						Math.round ((-baronDyingDirectional1stFrame[1].getWidth() + -baronDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (baronDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}
	
		if (state == SHOOTING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						baronShooting1[animationCounter / 2],
						Math.round (baronShooting1XOffset[animationCounter / 2] * scaling), 
						Math.round (baronShooting1YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						baronShooting2[animationCounter / 2],
						Math.round (baronShooting2XOffset[animationCounter / 2] * scaling), 
						Math.round (baronShooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						baronShooting3[animationCounter / 2],
						Math.round (baronShooting3XOffset[animationCounter / 2] * scaling), 
						Math.round (baronShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						baronShooting4[animationCounter / 2],
						Math.round (baronShooting4XOffset[animationCounter / 2] * scaling), 
						Math.round (baronShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						baronShooting5[animationCounter / 2],
						Math.round (baronShooting5XOffset[animationCounter / 2] * scaling), 
						Math.round (baronShooting5YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						baronShooting4[animationCounter / 2],
						Math.round ((-baronShooting4[animationCounter / 2].getWidth() + -baronShooting4XOffset[animationCounter / 2]) * scaling), 
						Math.round (baronShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						baronShooting3[animationCounter / 2],
						Math.round ((-baronShooting3[animationCounter / 2].getWidth() + -baronShooting3XOffset[animationCounter / 2]) * scaling), 
						Math.round (baronShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						baronShooting2[animationCounter / 2],
						Math.round ((-baronShooting2[animationCounter / 2].getWidth() + -baronShooting2XOffset[animationCounter / 2]) * scaling), 
						Math.round (baronShooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			}
			
			animationCounter++;
			if (animationCounter > 5)  {
				animationCounter = 0;
				state = WALKING;
			}
			return;
		}
		
		if (state == SPAWNING) {
			
			if (animationCounter > 7) {
				isSolid = true;
				drawScaled(
						baronWalking1[0],
						Math.round (baronWalking1XOffset[0] * scaling), 
						Math.round (baronWalking1YOffset[0] * scaling), 
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
						baronWalking1[animationCounter],
						Math.round (baronWalking1XOffset[animationCounter] * scaling), 
						Math.round (baronWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						baronWalking2[animationCounter],
						Math.round (baronWalking2XOffset[animationCounter] * scaling), 
						Math.round (baronWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						baronWalking3[animationCounter],
						Math.round (baronWalking3XOffset[animationCounter] * scaling), 
						Math.round (baronWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						baronWalking4[animationCounter],
						Math.round (baronWalking4XOffset[animationCounter] * scaling), 
						Math.round (baronWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						baronWalking5[animationCounter],
						Math.round (baronWalking5XOffset[animationCounter] * scaling), 
						Math.round (baronWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						baronWalking4[animationCounter],
						Math.round ((-baronWalking4[animationCounter].getWidth() + -baronWalking4XOffset[animationCounter]) * scaling), 
						Math.round (baronWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						baronWalking3[animationCounter],
						Math.round ((-baronWalking3[animationCounter].getWidth() + -baronWalking3XOffset[animationCounter]) * scaling), 
						Math.round (baronWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						baronWalking2[animationCounter],
						Math.round ((-baronWalking2[animationCounter].getWidth() + -baronWalking2XOffset[animationCounter]) * scaling), 
						Math.round (baronWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			}

			
			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && (Math.random() > 0.75 || calculateDistance(doomGuy) < 50 * scaling)) {
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
							baronDyingDirectional1stFrame[0],
							Math.round (baronDyingDirectional1stFrameXOffset[0] * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[0] * scaling), 
							offset,	c, 1);
					break;
				case 2:
					drawScaled(
							baronDyingDirectional1stFrame[1],
							Math.round (baronDyingDirectional1stFrameXOffset[1] * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, 1);
					break;
				case 3:
					drawScaled(
							baronDyingDirectional1stFrame[2],
							Math.round (baronDyingDirectional1stFrameXOffset[2] * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, 1);
					break;
				case 4:
					drawScaled(
							baronDyingDirectional1stFrame[3],
							Math.round (baronDyingDirectional1stFrameXOffset[3] * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, 1);
					break;
				case 5:
					drawScaled(
							baronDyingDirectional1stFrame[4],
							Math.round (baronDyingDirectional1stFrameXOffset[4] * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[4] * scaling), 
							offset, c, 1);
					break;
				case 6:
					drawScaled(
							baronDyingDirectional1stFrame[3],
							Math.round ((-baronDyingDirectional1stFrame[3].getWidth() + -baronDyingDirectional1stFrameXOffset[3]) * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, -1);
					break;
				case 7:
					drawScaled(
							baronDyingDirectional1stFrame[2],
							Math.round ((-baronDyingDirectional1stFrame[2].getWidth() + -baronDyingDirectional1stFrameXOffset[2]) * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, -1);
					break;
				case 8:
					drawScaled(
							baronDyingDirectional1stFrame[1],
							Math.round ((-baronDyingDirectional1stFrame[1].getWidth() + -baronDyingDirectional1stFrameXOffset[1]) * scaling), 
							Math.round (baronDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, -1);
					break;
				}
			} else if (animationCounter < 11) {
				int counter = (int) Math.ceil((float) animationCounter / 2);
				drawScaled(
						baronDeathFinalFrames[counter - 1],
						Math.round (baronDeathFinalFramesXOffset[counter - 1] * scaling), 
						Math.round (baronDeathFinalFramesYOffset[counter - 1] * scaling), 
						offset,	c, 1);
			} else {
				opacity =  Math.max(260 - (animationCounter), 0);
				drawScaledOpac(
						baronDeathFinalFrames[4],
						Math.round (baronDeathFinalFramesXOffset[4] * scaling), 
						Math.round (baronDeathFinalFramesYOffset[4] * scaling), 
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
						xSpeed = -5;
					} else {
						xSpeed = 5;
					}
					if (yDiff < 0) {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -5;
					} else {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 5;
					}
				} else {
					if (yDiff < 0) {
						ySpeed = -5;
					} else {
						ySpeed = 5;
					}
					if (xDiff < 0) {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -5;
					} else {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 5;
					}
				}
			}
			
			xSpeed *= random.nextFloat() + 0.5;
			ySpeed *= random.nextFloat() + 0.5;
			
			
			isOkToMove = true;
			for (Actor actor : actors) {
				
				if (actor.isSolid && calculateDistance(actor) < 30 * scaling) {
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
		if (state == SHOOTING && animationCounter == 4) {
			
			if (calculateDistance(doomGuy) > 50 * scaling) {
				Projectile fireball = new Projectile();
				
				if (Math.abs(xLoc - doomGuy.xLoc) > 50
						|| Math.abs(yLoc - doomGuy.yLoc) > 50) {
					
					xDiff = doomGuy.xLoc - xLoc;
					yDiff = doomGuy.yLoc - yLoc;
					
					if (Math.abs(xDiff) > Math.abs(yDiff)) {
						if (xDiff < 0) {
							fireball.xSpeed = -25;
						} else {
							fireball.xSpeed = 25;
						}
						if (yDiff < 0) {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -25;
						} else {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 25;
						}
					} else {
						if (yDiff < 0) {
							fireball.ySpeed = -25;
						} else {
							fireball.ySpeed = 25;
						}
						if (xDiff < 0) {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -25;
						} else {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 25;
						}
					}
				}
				fireball.xLoc = this.xLoc + (fireball.xSpeed * (1 + (yLoc * SCALING)));
				fireball.yLoc = this.yLoc + (fireball.ySpeed * (1 + (yLoc * SCALING)));
				fireball.state = Projectile.FLYING;
				fireball.type = Projectile.GREEN_FIREBALL;
				projectiles.add(fireball);
			} else {
				if (!godMode) {
					doomGuy.health -= 8;
					doomGuy.takingDamage = true;
					bloodSplatter.add(doomGuy.createBloodSplatter(random));
				}
			}
		}
	}

}
