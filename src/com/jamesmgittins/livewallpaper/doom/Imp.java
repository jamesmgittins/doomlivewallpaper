package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Imp extends Baddie {
	
	public Matrix aMatrix;
	
	public int width;
	
	public final static int RESPAWN_TIME = 100;
	
	public int direction;
	public float scaling = 1;
	
	public static final int SPEED = 2;
	
	public Bitmap[] impWalking1 = new Bitmap[4];
	public int[] impWalking1XOffset = new int[] {-19, -17, -17, -16};
	public int[] impWalking1YOffset = new int[] {-52, -51, -55, -52};
	
	public Bitmap[] impWalking2 = new Bitmap[4];
	public int[] impWalking2XOffset = new int[] {-17, -13, -14, -17};
	public int[] impWalking2YOffset = new int[] {-50, -52, -53, -50};
	
	public Bitmap[] impWalking3 = new Bitmap[4];
	public int[] impWalking3XOffset = new int[] {-15, -16, -13, -19};
	public int[] impWalking3YOffset = new int[] {-44, -46, -48, -43};
	
	public Bitmap[] impWalking4 = new Bitmap[4];
	public int[] impWalking4XOffset = new int[] {-20, -19, -12, -17};
	public int[] impWalking4YOffset = new int[] {-42, -42, -46, -41};
	
	public Bitmap[] impWalking5 = new Bitmap[4];
	public int[] impWalking5XOffset = new int[] {-21, -20, -22, -21};
	public int[] impWalking5YOffset = new int[] {-44, -41, -44, -41};
	
	public Bitmap[] impShooting1 = new Bitmap[3];
	public int[] impShooting1XOffset = new int[] {-30, -18, -5};
	public int[] impShooting1YOffset = new int[] {-55, -50, -50};
	
	public Bitmap[] impShooting2 = new Bitmap[3];
	public int[] impShooting2XOffset = new int[] {-11, -25, -25};
	public int[] impShooting2YOffset = new int[] {-51, -49, -50};
	
	public Bitmap[] impShooting3 = new Bitmap[3];
	public int[] impShooting3XOffset = new int[] {-23, -18, -27};
	public int[] impShooting3YOffset = new int[] {-44, -44, -46};
	
	public Bitmap[] impShooting4 = new Bitmap[3];
	public int[] impShooting4XOffset = new int[] {-20, -16, -23};
	public int[] impShooting4YOffset = new int[] {-42, -42, -42};
	
	public Bitmap[] impShooting5 = new Bitmap[3];
	public int[] impShooting5XOffset = new int[] {-17, -12, -16};
	public int[] impShooting5YOffset = new int[] {-43, -41, -44};
	
	public Bitmap[] impDyingDirectional1stFrame = new Bitmap[5];
	public int[] impDyingDirectional1stFrameXOffset = new int[] {-18, -6, -12, -9, -21};
	public int[] impDyingDirectional1stFrameYOffset = new int[] {-50, -51, -52, -51, -52};
	
	public Bitmap[] impDeathFinalFrames = new Bitmap[5];
	public int[] impDeathFinalFramesXOffset = new int[] {-22, -21, -18, -23, -29};
	public int[] impDeathFinalFramesYOffset = new int[] {-57, -54, -54, -45, -18};
	
	public Bitmap[] impRocketDeath = new Bitmap[8];
	public int[] impRocketDeathXOffset = new int[]{-24, -20, -24, -24, -24, -27, -27, -27};
	public int[] impRocketDeathYOffset = new int[]{-54, -56, -56, -56, -39, -29, -26, -13};
	
	// constructor to populate stuff
	public Imp(Resources res) {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;
		
		impWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.trooa1);
		impWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.troob1);
		impWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.trooc1);
		impWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.trood1);
		
		impWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.trooa2a8);
		impWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.troob2b8);
		impWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.trooc2c8);
		impWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.trood2d8);
		
		impWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.trooa3a7);
		impWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.troob3b7);
		impWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.trooc3c7);
		impWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.trood3d7);
		
		impWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.trooa4a6);
		impWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.troob4b6);
		impWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.trooc4c6);
		impWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.trood4d6);
		
		impWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.trooa5);
		impWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.troob5);
		impWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.trooc5);
		impWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.trood5);
		
		impShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.trooe1);
		impShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.troof1);
		impShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.troog1);
		
		impShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.trooe2e8);
		impShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.troof2f8);
		impShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.troog2g8);
		
		impShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.trooe3e7);
		impShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.troof3f7);
		impShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.troog3g7);
		
		impShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.trooe4e6);
		impShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.troof4f6);
		impShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.troog4g6);
		
		impShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.trooe5);
		impShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.troof5);
		impShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.troog5);
		
		impDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.trooh1);
		impDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.trooh2h8);
		impDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.trooh3h7);
		impDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.trooh4h6);
		impDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.trooh5);
		
		impDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.trooi0);
		impDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.trooj0);
		impDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.trook0);
		impDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.trool0);
		impDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.troom0);
		
		impRocketDeath[0] = BitmapFactory.decodeResource(res, R.drawable.troon0);
		impRocketDeath[1] = BitmapFactory.decodeResource(res, R.drawable.trooo0);
		impRocketDeath[2] = BitmapFactory.decodeResource(res, R.drawable.troop0);
		impRocketDeath[3] = BitmapFactory.decodeResource(res, R.drawable.trooq0);
		impRocketDeath[4] = BitmapFactory.decodeResource(res, R.drawable.troor0);
		impRocketDeath[5] = BitmapFactory.decodeResource(res, R.drawable.troos0);
		impRocketDeath[6] = BitmapFactory.decodeResource(res, R.drawable.troot0);
		impRocketDeath[7] = BitmapFactory.decodeResource(res, R.drawable.troou0);
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
						impDyingDirectional1stFrame[0],
						Math.round (impDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						impDyingDirectional1stFrame[1],
						Math.round (impDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						impDyingDirectional1stFrame[2],
						Math.round (impDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						impDyingDirectional1stFrame[3],
						Math.round (impDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						impDyingDirectional1stFrame[4],
						Math.round (impDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						impDyingDirectional1stFrame[3],
						Math.round ((-impDyingDirectional1stFrame[3].getWidth() + -impDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						impDyingDirectional1stFrame[2],
						Math.round ((-impDyingDirectional1stFrame[2].getWidth() + -impDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						impDyingDirectional1stFrame[1],
						Math.round ((-impDyingDirectional1stFrame[1].getWidth() + -impDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (impDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}
	
		if (state == SHOOTING) {
			
			switch (direction) {
			case 1:
				drawScaled(
						impShooting1[animationCounter / 2],
						Math.round (impShooting1XOffset[animationCounter / 2] * scaling), 
						Math.round (impShooting1YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						impShooting2[animationCounter / 2],
						Math.round (impShooting2XOffset[animationCounter / 2] * scaling), 
						Math.round (impShooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						impShooting3[animationCounter / 2],
						Math.round (impShooting3XOffset[animationCounter / 2] * scaling), 
						Math.round (impShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						impShooting4[animationCounter / 2],
						Math.round (impShooting4XOffset[animationCounter / 2] * scaling), 
						Math.round (impShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						impShooting5[animationCounter / 2],
						Math.round (impShooting5XOffset[animationCounter / 2] * scaling), 
						Math.round (impShooting5YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						impShooting4[animationCounter / 2],
						Math.round ((-impShooting4[animationCounter / 2].getWidth() + -impShooting4XOffset[animationCounter / 2]) * scaling), 
						Math.round (impShooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						impShooting3[animationCounter / 2],
						Math.round ((-impShooting3[animationCounter / 2].getWidth() + -impShooting3XOffset[animationCounter / 2]) * scaling), 
						Math.round (impShooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						impShooting2[animationCounter / 2],
						Math.round ((-impShooting2[animationCounter / 2].getWidth() + -impShooting2XOffset[animationCounter / 2]) * scaling), 
						Math.round (impShooting2YOffset[animationCounter / 2] * scaling), 
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
						impWalking1[0],
						Math.round (impWalking1XOffset[0] * scaling), 
						Math.round (impWalking1YOffset[0] * scaling), 
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
						impWalking1[animationCounter],
						Math.round (impWalking1XOffset[animationCounter] * scaling), 
						Math.round (impWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						impWalking2[animationCounter],
						Math.round (impWalking2XOffset[animationCounter] * scaling), 
						Math.round (impWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						impWalking3[animationCounter],
						Math.round (impWalking3XOffset[animationCounter] * scaling), 
						Math.round (impWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						impWalking4[animationCounter],
						Math.round (impWalking4XOffset[animationCounter] * scaling), 
						Math.round (impWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						impWalking5[animationCounter],
						Math.round (impWalking5XOffset[animationCounter] * scaling), 
						Math.round (impWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						impWalking4[animationCounter],
						Math.round ((-impWalking4[animationCounter].getWidth() + -impWalking4XOffset[animationCounter]) * scaling), 
						Math.round (impWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						impWalking3[animationCounter],
						Math.round ((-impWalking3[animationCounter].getWidth() + -impWalking3XOffset[animationCounter]) * scaling), 
						Math.round (impWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						impWalking2[animationCounter],
						Math.round ((-impWalking2[animationCounter].getWidth() + -impWalking2XOffset[animationCounter]) * scaling), 
						Math.round (impWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1);
				break;
			}

			
			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && (Math.random() > 0.80 || calculateDistance(doomGuy) < 50 * scaling)) {
					state = SHOOTING;
				}
			}
			return;
		}
		
		if (state == DYING || state == DEAD) {
			
			if (killedByRocket) {
				if (animationCounter < 8) {
					drawScaled(
							impRocketDeath[animationCounter],
							Math.round (impRocketDeathXOffset[animationCounter] * scaling), 
							Math.round (impRocketDeathYOffset[animationCounter] * scaling), 
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							impRocketDeath[7],
							Math.round (impRocketDeathXOffset[7] * scaling), 
							Math.round (impRocketDeathYOffset[7] * scaling), 
							offset,	c, 1, opacity);
				}
			} else {
				if (animationCounter == 0 || animationCounter == 1) {
					switch (direction) {
					case 1:
						drawScaled(
								impDyingDirectional1stFrame[0],
								Math.round (impDyingDirectional1stFrameXOffset[0] * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[0] * scaling), 
								offset,	c, 1);
						break;
					case 2:
						drawScaled(
								impDyingDirectional1stFrame[1],
								Math.round (impDyingDirectional1stFrameXOffset[1] * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, 1);
						break;
					case 3:
						drawScaled(
								impDyingDirectional1stFrame[2],
								Math.round (impDyingDirectional1stFrameXOffset[2] * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, 1);
						break;
					case 4:
						drawScaled(
								impDyingDirectional1stFrame[3],
								Math.round (impDyingDirectional1stFrameXOffset[3] * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, 1);
						break;
					case 5:
						drawScaled(
								impDyingDirectional1stFrame[4],
								Math.round (impDyingDirectional1stFrameXOffset[4] * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[4] * scaling), 
								offset, c, 1);
						break;
					case 6:
						drawScaled(
								impDyingDirectional1stFrame[3],
								Math.round ((-impDyingDirectional1stFrame[3].getWidth() + -impDyingDirectional1stFrameXOffset[3]) * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[3] * scaling), 
								offset, c, -1);
						break;
					case 7:
						drawScaled(
								impDyingDirectional1stFrame[2],
								Math.round ((-impDyingDirectional1stFrame[2].getWidth() + -impDyingDirectional1stFrameXOffset[2]) * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[2] * scaling), 
								offset, c, -1);
						break;
					case 8:
						drawScaled(
								impDyingDirectional1stFrame[1],
								Math.round ((-impDyingDirectional1stFrame[1].getWidth() + -impDyingDirectional1stFrameXOffset[1]) * scaling), 
								Math.round (impDyingDirectional1stFrameYOffset[1] * scaling), 
								offset, c, -1);
						break;
					}
				} else if (animationCounter < 11) {
					int counter = (int) Math.ceil((float) animationCounter / 2);
					drawScaled(
							impDeathFinalFrames[counter - 1],
							Math.round (impDeathFinalFramesXOffset[counter - 1] * scaling), 
							Math.round (impDeathFinalFramesYOffset[counter - 1] * scaling), 
							offset,	c, 1);
				} else {
					opacity =  Math.max(260 - (animationCounter), 0);
					drawScaledOpac(
							impDeathFinalFrames[4],
							Math.round (impDeathFinalFramesXOffset[4] * scaling), 
							Math.round (impDeathFinalFramesYOffset[4] * scaling), 
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
		if (state == SHOOTING && animationCounter == 4) {
			
			if (calculateDistance(doomGuy) > 50 * scaling) {
				Projectile fireball = new Projectile();
				
				if (Math.abs(xLoc - doomGuy.xLoc) > 50
						|| Math.abs(yLoc - doomGuy.yLoc) > 50) {
					
					xDiff = doomGuy.xLoc - xLoc;
					yDiff = doomGuy.yLoc - yLoc;
					
					if (Math.abs(xDiff) > Math.abs(yDiff)) {
						if (xDiff < 0) {
							fireball.xSpeed = -20;
						} else {
							fireball.xSpeed = 20;
						}
						if (yDiff < 0) {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -20;
						} else {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 20;
						}
					} else {
						if (yDiff < 0) {
							fireball.ySpeed = -20;
						} else {
							fireball.ySpeed = 20;
						}
						if (xDiff < 0) {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -20;
						} else {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 20;
						}
					}
				}
				fireball.xLoc = this.xLoc + (fireball.xSpeed * (1 + (yLoc * SCALING)));
				fireball.yLoc = this.yLoc + (fireball.ySpeed * (1 + (yLoc * SCALING)));
				fireball.state = Projectile.FLYING;
				fireball.type = Projectile.FIREBALL;
				projectiles.add(fireball);
			} else {
				if (!godMode && random.nextFloat() > 0.2) {
					doomGuy.health -= 3;
					doomGuy.takingDamage = true;
					bloodSplatter.add(doomGuy.createBloodSplatter(random));
				}
			}
		}
	}

}
