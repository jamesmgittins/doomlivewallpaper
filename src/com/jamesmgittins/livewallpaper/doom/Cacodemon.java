package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Cacodemon extends Baddie {

	public Matrix aMatrix;

	public int width;

	public final static int RESPAWN_TIME = 100;

	public int direction;
	public float scaling = 1;

	public static final int SPEED = 2;

	public Bitmap[] walking1 = new Bitmap[1];
	public int[] walking1XOffset = new int[] {-31};
	public int[] walking1YOffset = new int[] {-67};

	public Bitmap[] walking2 = new Bitmap[1];
	public int[] walking2XOffset = new int[] {-26};
	public int[] walking2YOffset = new int[] {-67};

	public Bitmap[] walking3 = new Bitmap[1];
	public int[] walking3XOffset = new int[] {-27};
	public int[] walking3YOffset = new int[] {-68};

	public Bitmap[] walking4 = new Bitmap[1];
	public int[] walking4XOffset = new int[] {-32};
	public int[] walking4YOffset = new int[] {-68};

	public Bitmap[] walking5 = new Bitmap[1];
	public int[] walking5XOffset = new int[] {-28};
	public int[] walking5YOffset = new int[] {-66};

	public Bitmap[] shooting1 = new Bitmap[3];
	public int[] shooting1XOffset = new int[] {-31, -31, -31};
	public int[] shooting1YOffset = new int[] {-70, -71, -72};

	public Bitmap[] shooting2 = new Bitmap[3];
	public int[] shooting2XOffset = new int[] {-29, -29, -29};
	public int[] shooting2YOffset = new int[] {-69, -72, -72};

	public Bitmap[] shooting3 = new Bitmap[3];
	public int[] shooting3XOffset = new int[] {-30, -30, -30};
	public int[] shooting3YOffset = new int[] {-68, -68, -72};

	public Bitmap[] shooting4 = new Bitmap[3];
	public int[] shooting4XOffset = new int[] {-32, -32, -32};
	public int[] shooting4YOffset = new int[] {-67, -67, -70};

	public Bitmap[] shooting5 = new Bitmap[3];
	public int[] shooting5XOffset = new int[] {-32, -32, -32};
	public int[] shooting5YOffset = new int[] {-68, -68, -68};

	public Bitmap[] dyingDirectional1stFrame = new Bitmap[5];
	public int[] dyingDirectional1stFrameXOffset = new int[] {-31, -30, -29, -31, -30};
	public int[] dyingDirectional1stFrameYOffset = new int[] {-68, -67, -68, -69, -68};

	public Bitmap[] deathFinalFrames = new Bitmap[7];
	public int[] deathFinalFramesXOffset = new int[] {-31, -31, -31, -31, -31, -35, -37};
	public int[] deathFinalFramesYOffset = new int[] {-68, -68, -68, -68, -72, -63, -47};

	// constructor to populate stuff
	public Cacodemon(Resources res) {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	
		state = WALKING;
		isSolid = false;

		walking1[0] = BitmapFactory.decodeResource(res, R.drawable.heada1);

		walking2[0] = BitmapFactory.decodeResource(res, R.drawable.heada2a8);

		walking3[0] = BitmapFactory.decodeResource(res, R.drawable.heada3a7);

		walking4[0] = BitmapFactory.decodeResource(res, R.drawable.heada4a6);

		walking5[0] = BitmapFactory.decodeResource(res, R.drawable.heada5);

		shooting1[0] = BitmapFactory.decodeResource(res, R.drawable.headb1);
		shooting1[1] = BitmapFactory.decodeResource(res, R.drawable.headc1);
		shooting1[2] = BitmapFactory.decodeResource(res, R.drawable.headd1);

		shooting2[0] = BitmapFactory.decodeResource(res, R.drawable.headb2b8);
		shooting2[1] = BitmapFactory.decodeResource(res, R.drawable.headc2c8);
		shooting2[2] = BitmapFactory.decodeResource(res, R.drawable.headd2d8);

		shooting3[0] = BitmapFactory.decodeResource(res, R.drawable.headb3b7);
		shooting3[1] = BitmapFactory.decodeResource(res, R.drawable.headc3c7);
		shooting3[2] = BitmapFactory.decodeResource(res, R.drawable.headd3d7);

		shooting4[0] = BitmapFactory.decodeResource(res, R.drawable.headb4b6);
		shooting4[1] = BitmapFactory.decodeResource(res, R.drawable.headc4c6);
		shooting4[2] = BitmapFactory.decodeResource(res, R.drawable.headd4d6);

		shooting5[0] = BitmapFactory.decodeResource(res, R.drawable.headb5);
		shooting5[1] = BitmapFactory.decodeResource(res, R.drawable.headc5);
		shooting5[2] = BitmapFactory.decodeResource(res, R.drawable.headd5);

		dyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.heade1);
		dyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.heade2e8);
		dyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.heade3e7);
		dyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.heade4e6);
		dyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.heade5);

		deathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.headf1);
		deathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.headg0);
		deathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.headh0);
		deathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.headi0);
		deathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.headj0);
		deathFinalFrames[5] = BitmapFactory.decodeResource(res, R.drawable.headk0);
		deathFinalFrames[6] = BitmapFactory.decodeResource(res, R.drawable.headl0);
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
						dyingDirectional1stFrame[0],
						Math.round (dyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						dyingDirectional1stFrame[1],
						Math.round (dyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						dyingDirectional1stFrame[2],
						Math.round (dyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						dyingDirectional1stFrame[3],
						Math.round (dyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						dyingDirectional1stFrame[4],
						Math.round (dyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						dyingDirectional1stFrame[3],
						Math.round ((-dyingDirectional1stFrame[3].getWidth() + -dyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						dyingDirectional1stFrame[2],
						Math.round ((-dyingDirectional1stFrame[2].getWidth() + -dyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						dyingDirectional1stFrame[1],
						Math.round ((-dyingDirectional1stFrame[1].getWidth() + -dyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (dyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1);
				break;
			}
			return;
		}

		if (state == SHOOTING) {

			switch (direction) {
			case 1:
				drawScaled(
						shooting1[animationCounter / 2],
						Math.round (shooting1XOffset[animationCounter / 2] * scaling), 
						Math.round (shooting1YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						shooting2[animationCounter / 2],
						Math.round (shooting2XOffset[animationCounter / 2] * scaling), 
						Math.round (shooting2YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 3:
				drawScaled(
						shooting3[animationCounter / 2],
						Math.round (shooting3XOffset[animationCounter / 2] * scaling), 
						Math.round (shooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 4:
				drawScaled(
						shooting4[animationCounter / 2],
						Math.round (shooting4XOffset[animationCounter / 2] * scaling), 
						Math.round (shooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 5:
				drawScaled(
						shooting5[animationCounter / 2],
						Math.round (shooting5XOffset[animationCounter / 2] * scaling), 
						Math.round (shooting5YOffset[animationCounter / 2] * scaling), 
						offset,	c, 1);
				break;
			case 6:
				drawScaled(
						shooting4[animationCounter / 2],
						Math.round ((-shooting4[animationCounter / 2].getWidth() + -shooting4XOffset[animationCounter / 2]) * scaling), 
						Math.round (shooting4YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 7:
				drawScaled(
						shooting3[animationCounter / 2],
						Math.round ((-shooting3[animationCounter / 2].getWidth() + -shooting3XOffset[animationCounter / 2]) * scaling), 
						Math.round (shooting3YOffset[animationCounter / 2] * scaling), 
						offset,	c, -1);
				break;
			case 8:
				drawScaled(
						shooting2[animationCounter / 2],
						Math.round ((-shooting2[animationCounter / 2].getWidth() + -shooting2XOffset[animationCounter / 2]) * scaling), 
						Math.round (shooting2YOffset[animationCounter / 2] * scaling), 
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
						walking1[0],
						Math.round (walking1XOffset[0] * scaling), 
						Math.round (walking1YOffset[0] * scaling), 
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
						walking1[0],
						Math.round (walking1XOffset[0] * scaling), 
						Math.round (walking1YOffset[0] * scaling), 
						offset,	c, 1);
				break;
			case 2:
				drawScaled(
						walking2[0],
						Math.round (walking2XOffset[0] * scaling), 
						Math.round (walking2YOffset[0] * scaling), 
						offset, c, 1);
				break;
			case 3:
				drawScaled(
						walking3[0],
						Math.round (walking3XOffset[0] * scaling), 
						Math.round (walking3YOffset[0] * scaling), 
						offset, c, 1);
				break;
			case 4:
				drawScaled(
						walking4[0],
						Math.round (walking4XOffset[0] * scaling), 
						Math.round (walking4YOffset[0] * scaling), 
						offset, c, 1);
				break;
			case 5:
				drawScaled(
						walking5[0],
						Math.round (walking5XOffset[0] * scaling), 
						Math.round (walking5YOffset[0] * scaling), 
						offset, c, 1);
				break;
			case 6:
				drawScaled(
						walking4[0],
						Math.round ((-walking4[0].getWidth() + -walking4XOffset[0]) * scaling), 
						Math.round (walking4YOffset[0] * scaling), 
						offset, c, -1);
				break;
			case 7:
				drawScaled(
						walking3[0],
						Math.round ((-walking3[0].getWidth() + -walking3XOffset[0]) * scaling), 
						Math.round (walking3YOffset[0] * scaling), 
						offset, c, -1);
				break;
			case 8:
				drawScaled(
						walking2[0],
						Math.round ((-walking2[0].getWidth() + -walking2XOffset[0]) * scaling), 
						Math.round (walking2YOffset[0] * scaling), 
						offset, c, -1);
				break;
			}


			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				if ((doomGuy.state == WALKING || doomGuy.state == SHOOTING) && (Math.random() > 0.70 || calculateDistance(doomGuy) < 45 * scaling)) {
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
							dyingDirectional1stFrame[0],
							Math.round (dyingDirectional1stFrameXOffset[0] * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[0] * scaling), 
							offset,	c, 1);
					break;
				case 2:
					drawScaled(
							dyingDirectional1stFrame[1],
							Math.round (dyingDirectional1stFrameXOffset[1] * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, 1);
					break;
				case 3:
					drawScaled(
							dyingDirectional1stFrame[2],
							Math.round (dyingDirectional1stFrameXOffset[2] * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, 1);
					break;
				case 4:
					drawScaled(
							dyingDirectional1stFrame[3],
							Math.round (dyingDirectional1stFrameXOffset[3] * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, 1);
					break;
				case 5:
					drawScaled(
							dyingDirectional1stFrame[4],
							Math.round (dyingDirectional1stFrameXOffset[4] * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[4] * scaling), 
							offset, c, 1);
					break;
				case 6:
					drawScaled(
							dyingDirectional1stFrame[3],
							Math.round ((-dyingDirectional1stFrame[3].getWidth() + -dyingDirectional1stFrameXOffset[3]) * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, -1);
					break;
				case 7:
					drawScaled(
							dyingDirectional1stFrame[2],
							Math.round ((-dyingDirectional1stFrame[2].getWidth() + -dyingDirectional1stFrameXOffset[2]) * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, -1);
					break;
				case 8:
					drawScaled(
							dyingDirectional1stFrame[1],
							Math.round ((-dyingDirectional1stFrame[1].getWidth() + -dyingDirectional1stFrameXOffset[1]) * scaling), 
							Math.round (dyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, -1);
					break;
				}
			} else if (animationCounter < 15) {
				int counter = (int) Math.ceil((float) animationCounter / 2);
				drawScaled(
						deathFinalFrames[counter - 1],
						Math.round (deathFinalFramesXOffset[counter - 1] * scaling), 
						Math.round (deathFinalFramesYOffset[counter - 1] * scaling), 
						offset,	c, 1);
			} else {
				opacity =  Math.max(260 - (animationCounter), 0);
				drawScaledOpac(
						deathFinalFrames[6],
						Math.round (deathFinalFramesXOffset[6] * scaling), 
						Math.round (deathFinalFramesYOffset[6] * scaling), 
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
					xSpeed = -3;
				} else {
					xSpeed = 3;
				}
				if (yDiff < 0) {
					ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -3;
				} else {
					ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 3;
				}
			} else {
				if (yDiff < 0) {
					ySpeed = -3;
				} else {
					ySpeed = 3;
				}
				if (xDiff < 0) {
					xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -3;
				} else {
					xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 3;
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
			if (random.nextFloat() > 0.1) {
				xLoc += (xSpeed * (1 + (yLoc * SCALING)));
				yLoc += (ySpeed * (1 + (yLoc * SCALING)));	
			} else {
				yLoc += (xSpeed * (1 + (yLoc * SCALING)));
				xLoc += (ySpeed * (1 + (yLoc * SCALING)));
			}
				
		}
	}
	if (state == SHOOTING && animationCounter == 4) {

		if (calculateDistance(doomGuy) > 45 * scaling) {
			Projectile fireball = new Projectile();

			if (Math.abs(xLoc - doomGuy.xLoc) > 50
					|| Math.abs(yLoc - doomGuy.yLoc) > 50) {

				xDiff = doomGuy.xLoc - xLoc;
				yDiff = doomGuy.yLoc - yLoc;

				if (Math.abs(xDiff) > Math.abs(yDiff)) {
					if (xDiff < 0) {
						fireball.xSpeed = -18;
					} else {
						fireball.xSpeed = 18;
					}
					if (yDiff < 0) {
						fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -18;
					} else {
						fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 18;
					}
				} else {
					if (yDiff < 0) {
						fireball.ySpeed = -18;
					} else {
						fireball.ySpeed = 18;
					}
					if (xDiff < 0) {
						fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -18;
					} else {
						fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 18;
					}
				}
			}
			fireball.xLoc = this.xLoc + (fireball.xSpeed * (1 + (yLoc * SCALING)));
			fireball.yLoc = this.yLoc + (fireball.ySpeed * (1 + (yLoc * SCALING)));
			fireball.state = Projectile.FLYING;
			fireball.type = Projectile.FIREBALL2;
			projectiles.add(fireball);
		} else {
			if (!godMode && random.nextFloat() > 0.2) {
				doomGuy.health -= 9;
				doomGuy.takingDamage = true;
				bloodSplatter.add(doomGuy.createBloodSplatter(random));
			}
		}
	}
}

}
