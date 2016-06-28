package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Projectile extends Actor {

	public float xSpeed;
	public float ySpeed;
	public int spawned;
	public Matrix aMatrix;
	public float scaling = 1;
	public int state;
	public static final int FLYING = 1;
	public static final int EXPLODING = 2;

	public int type;
	public static final int FIREBALL = 1;
	public static final int GREEN_FIREBALL = 2;
	public static final int ROCKET = 3;
	public static final int FIREBALL2 = 4;
	public static final int PLASMA = 5;

	private int direction = 0;
	
	public Projectile() {
		isSolid = false;
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);
	}

	public void draw(Canvas c, float offset, int width, Sprites sprites) {
		
		scaling = 3 + (yLoc * SCALING);

		switch (type) {
		case PLASMA:
			if (state == FLYING) {
				drawScaled(
						sprites.plasmaFlying[animationCounter],
						Math.round (sprites.plasmaFlyingXOffset[animationCounter] * scaling), 
						Math.round (sprites.plasmaFlyingYOffset[animationCounter] * scaling), 
						offset,	c, width);
				animationCounter++;
				if (animationCounter > 1) {
					animationCounter = 0;
				}
			}
			if (state == EXPLODING) {
				if (animationCounter < 4) {
					drawScaled(
							sprites.plasmaExploding[animationCounter],
							Math.round (sprites.plasmaExplodingXOffset[animationCounter] * scaling), 
							Math.round (sprites.plasmaExplodingYOffset[animationCounter] * scaling), 
							offset,	c, width);	
				}
				animationCounter++;
			}
			break;
		case FIREBALL:
			if (state == FLYING) {
				drawScaled(
						sprites.fireballFlying[animationCounter],
						Math.round (sprites.fireballFlyingXOffset[animationCounter] * scaling), 
						Math.round (sprites.fireballFlyingYOffset[animationCounter] * scaling), 
						offset,	c, width);
				animationCounter++;
				if (animationCounter > 1) {
					animationCounter = 0;
				}
			}
			if (state == EXPLODING) {
				if (animationCounter < 3) {
					drawScaled(
							sprites.fireballExploding[animationCounter],
							Math.round (sprites.fireballExplodingXOffset[animationCounter] * scaling), 
							Math.round (sprites.fireballExplodingYOffset[animationCounter] * scaling), 
							offset,	c, width);	
				}
				animationCounter++;
			}
			break;
		case FIREBALL2:
			if (state == FLYING) {
				drawScaled(
						sprites.fireball2Flying[animationCounter],
						Math.round (sprites.fireball2FlyingXOffset[animationCounter] * scaling), 
						Math.round (sprites.fireball2FlyingYOffset[animationCounter] * scaling), 
						offset,	c, width);
				animationCounter++;
				if (animationCounter > 1) {
					animationCounter = 0;
				}
			}
			if (state == EXPLODING) {
				if (animationCounter < 3) {
					drawScaled(
							sprites.fireball2Exploding[animationCounter],
							Math.round (sprites.fireball2ExplodingXOffset[animationCounter] * scaling), 
							Math.round (sprites.fireball2ExplodingYOffset[animationCounter] * scaling), 
							offset,	c, width);	
				}
				animationCounter++;
			}
			break;
		case GREEN_FIREBALL:
			if (state == FLYING) {
				drawScaled(
						sprites.greenFireballFlying[animationCounter],
						Math.round (sprites.greenFireballFlyingXOffset[animationCounter] * scaling), 
						Math.round (sprites.greenFireballFlyingYOffset[animationCounter] * scaling), 
						offset,	c, width);
				animationCounter++;
				if (animationCounter > 1) {
					animationCounter = 0;
				}
			}
			if (state == EXPLODING) {
				if (animationCounter < 3) {
					drawScaled(
							sprites.greenFireballExploding[animationCounter],
							Math.round (sprites.greenFireballExplodingXOffset[animationCounter] * scaling), 
							Math.round (sprites.greenFireballExplodingYOffset[animationCounter] * scaling), 
							offset,	c, width);	
				}
				animationCounter++;
			}
			break;
		case ROCKET:
			if (direction == 0) {
				calculateDirection();
			}
			if (state == FLYING) {
				scaling *= 0.7;
				switch (direction) {
				case 1:
					drawScaled(
							sprites.rocketFlying[0],
							Math.round (sprites.rocketFlyingXOffset[0] * scaling), 
							Math.round (sprites.rocketFlyingYOffset[0] * scaling), 
							offset,	c, width);
					break;
				case 2:
					drawFlipped(
							sprites.rocketFlying[1],
							Math.round ((-sprites.rocketFlying[1].getWidth() + -sprites.rocketFlyingXOffset[1]) * scaling),
							Math.round (sprites.rocketFlyingYOffset[1] * scaling), 
							offset,	c, width);
					break;
				case 3:
					drawFlipped(
							sprites.rocketFlying[2],
							Math.round ((-sprites.rocketFlying[2].getWidth() + -sprites.rocketFlyingXOffset[2]) * scaling),
							Math.round (sprites.rocketFlyingYOffset[2] * scaling), 
							offset,	c, width);
					break;
				case 4:
					drawFlipped(
							sprites.rocketFlying[3],
							Math.round ((-sprites.rocketFlying[3].getWidth() + -sprites.rocketFlyingXOffset[3]) * scaling),
							Math.round (sprites.rocketFlyingYOffset[3] * scaling), 
							offset,	c, width);
					break;
				case 5:
					drawScaled(
							sprites.rocketFlying[4],
							Math.round (sprites.rocketFlyingXOffset[4] * scaling), 
							Math.round (sprites.rocketFlyingYOffset[4] * scaling), 
							offset,	c, width);
					break;
				case 6:
					drawScaled(
							sprites.rocketFlying[3],
							Math.round (sprites.rocketFlyingXOffset[3] * scaling), 
							Math.round (sprites.rocketFlyingYOffset[3] * scaling), 
							offset,	c, width);
					break;
				case 7:
					drawScaled(
							sprites.rocketFlying[2],
							Math.round (sprites.rocketFlyingXOffset[2] * scaling), 
							Math.round (sprites.rocketFlyingYOffset[2] * scaling), 
							offset,	c, width);
					break;
				case 8:
					drawScaled(
							sprites.rocketFlying[1],
							Math.round (sprites.rocketFlyingXOffset[1] * scaling), 
							Math.round (sprites.rocketFlyingYOffset[1] * scaling), 
							offset,	c, width);
					break;
				}

			}
			if (state == EXPLODING) {
				if (animationCounter < 3) {
					drawScaled(
							sprites.rocketExploding[animationCounter],
							Math.round (sprites.rocketExplodingXOffset[animationCounter] * scaling), 
							Math.round (sprites.rocketExplodingYOffset[animationCounter] * scaling), 
							offset,	c, width);	
				}
				animationCounter++;
			}
			break;
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
	
	/**
	 * 
	 * @param drawMe
	 * @param offsetX
	 * @param offsetY
	 * @param offset
	 * @param c
	 */
	private void drawFlipped(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int width) {
		aMatrix.setScale(scaling * -1, scaling);
		aMatrix.postTranslate(xLoc + offsetX - (width * offset) + (drawMe.getWidth() * scaling), yLoc + offsetY);
		c.drawBitmap(drawMe, aMatrix, null);
	}

	public void updateState(ArrayList<Actor> actors, boolean godMode) {
		spawned++;

		if (state == EXPLODING && animationCounter < 5) {
			scaling = 3 + (yLoc * SCALING);
			xLoc += (xSpeed * 0.2f * (1 + (yLoc * SCALING)));
			yLoc += (ySpeed * 0.2f * (1 + (yLoc * SCALING)));
		}

		if (state == FLYING) {
			scaling = 3 + (yLoc * SCALING);
			xLoc += (xSpeed * (1 + (yLoc * SCALING)));
			yLoc += (ySpeed * (1 + (yLoc * SCALING)));

			if (spawned > 3) {
				for (Actor actor : actors) {
					switch (type) {
					case FIREBALL:
						
						if (calculateDistance(actor) < 20 * scaling 
								|| (state == EXPLODING && calculateDistance(actor) < 30 * scaling)) {
							
							if (actor instanceof DoomGuy && ((DoomGuy)actor).health > 0) {
								if (!godMode) {
									((DoomGuy) actor).health -= 4;
									((DoomGuy) actor).takingDamage = true;	
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
							if (actor instanceof Baddie && ((Baddie)actor).health > 0 && ((Baddie)actor).state != Baddie.SPAWNING) {
								((Baddie) actor).health -= 3;
								((Baddie) actor).takingDamage = true;
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
						}
						break;
					case FIREBALL2:
						if (calculateDistance(actor) < 20 * scaling
								|| (state == EXPLODING && calculateDistance(actor) < 30 * scaling)) {
							
							if (actor instanceof DoomGuy && ((DoomGuy)actor).health > 0) {
								if (!godMode) {
									((DoomGuy) actor).health -= 8;
									((DoomGuy) actor).takingDamage = true;	
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
							if (actor instanceof Baddie && ((Baddie)actor).health > 0 && ((Baddie)actor).state != Baddie.SPAWNING) {
								((Baddie) actor).health -= 6;
								((Baddie) actor).takingDamage = true;
								if (((Baddie) actor).health < 0) {
									((Baddie) actor).killedByRocket = true;
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
						}
						break;
					case ROCKET:
						if (calculateDistance(actor) < 20 * scaling
								|| (state == EXPLODING && calculateDistance(actor) < 40 * scaling)) {
							
							if (actor instanceof DoomGuy && ((DoomGuy)actor).health > 0) {
								if (!godMode) {
									((DoomGuy) actor).health -= 10;
									((DoomGuy) actor).takingDamage = true;	
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
							if (actor instanceof Baddie && ((Baddie)actor).health > 0 && ((Baddie)actor).state != Baddie.SPAWNING) {
								((Baddie) actor).health -= 12; 
								((Baddie) actor).takingDamage = true;
								if (((Baddie) actor).health < 0) {
									((Baddie) actor).killedByRocket = true;
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
						}
						break;
					case PLASMA:
						if (state == FLYING && calculateDistance(actor) < 20 * scaling) {
							if (actor instanceof Baddie && ((Baddie)actor).health > 0 && ((Baddie)actor).state != Baddie.SPAWNING) {
								((Baddie) actor).health -= 3; 
								((Baddie) actor).takingDamage = true;
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
						}
						break;
					case GREEN_FIREBALL:
						if (calculateDistance(actor) < 20 * scaling
								|| (state == EXPLODING && calculateDistance(actor) < 30 * scaling)) {
							if (actor instanceof DoomGuy && ((DoomGuy)actor).health > 0) {
								if (!godMode) {
									((DoomGuy) actor).health -= 8;
									((DoomGuy) actor).takingDamage = true;	
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
							if (actor instanceof Baddie && ((Baddie)actor).health > 0 && ((Baddie)actor).state != Baddie.SPAWNING) {
								((Baddie) actor).health -= 8;
								((Baddie) actor).takingDamage = true;
								if (((Baddie) actor).health < 0) {
									((Baddie) actor).killedByRocket = true;
								}
								if (state == FLYING) {
									state = EXPLODING;
									animationCounter = 0;	
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	private float angle;

	public void calculateDirection() {
		
		// angles customised for rocket sprites, don't use this code for other sprites!
		
		angle = (float) Math.atan2(xSpeed, -ySpeed) * 180f / (float) Math.PI;

		if (angle >= -35 && angle <= 35) {
			direction = 5;
			return;
		}
		if (angle >= 35 && angle <= 67.5) {
			direction = 6;
			return;
		}
		if (angle >= 67.5 && angle <= 112.5) {
			direction = 7;
			return;
		}
		if (angle >= 112.5 && angle <= 145) {
			direction = 8;
			return;
		}
		if (angle >= 145 || angle <= -145) {
			direction = 1;
			return;
		}
		if (angle >= -145 && angle <= -112.5) {
			direction = 2;
			return;
		}
		if (angle >= -112.5 && angle <= -67.5) {
			direction = 3;
			return;
		}
		if (angle >= -67.5 && angle <= -35) {
			direction = 4;
			return;
		}
		direction = 1;
	}

}
