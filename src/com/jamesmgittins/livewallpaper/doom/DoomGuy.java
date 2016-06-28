package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
public class DoomGuy extends Actor {

	public static final int SPAWNING = 5;
	public static final int WALKING = 1;
	public static final int SHOOTING = 2;
	public static final int DYING = 3;
	public static final int DEAD = 4;

	public int health = 100;
	public Matrix aMatrix;

	public int minigunBullets;
	public int shotgunBullets;
	public int rockets;
	public int plasmaCells;

	//	public float xLoc;
	//	public float yLoc;

	public boolean takingDamage;

	public float xSpeed;
	public float ySpeed;
	public int direction;

	public static final int RESPAWN_TIME = 150;

	public int animationCounter;
	public int state;

	public float scaling = 1;

	public static final int SPEED = 5;

	public int loopsSinceLastShot = 0;
	public boolean lastShotWasRocket = false;

	// constructor to populate stuff
	public DoomGuy() {
		aMatrix = new Matrix();
		aMatrix.preTranslate(0, 0);	

		state = WALKING;
	}

	public void draw(Canvas c, float offset, Baddie badGuy, int width, int height, Sprites sprites) {

		if (health <= 0 && state != DEAD && state != DYING) {
			isSolid = false;
			state = DYING;
			animationCounter = 0;
		}
		if (state != SHOOTING) {
			calculateDirection(badGuy);	
		}

		scaling = 3 + (yLoc * SCALING);

		if (takingDamage && health > 0) {
			if (state == SHOOTING && animationCounter == 1) {
				animationCounter++;
			}
			takingDamage = false;
			switch (direction) {
			case 1:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[0],
						Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[0] * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[0] * scaling), 
						offset,	c, 1, width);
				break;
			case 2:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[1],
						Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[1] * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, 1, width);
				break;
			case 3:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[2],
						Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[2] * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, 1, width);
				break;
			case 4:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[3],
						Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[3] * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, 1, width);
				break;
			case 5:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[4],
						Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[4] * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[4] * scaling), 
						offset, c, 1, width);
				break;
			case 6:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[3],
						Math.round ((-sprites.doomGuyDyingDirectional1stFrame[3].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[3] * scaling), 
						offset, c, -1, width);
				break;
			case 7:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[2],
						Math.round ((-sprites.doomGuyDyingDirectional1stFrame[2].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[2] * scaling), 
						offset, c, -1, width);
				break;
			case 8:
				drawScaled(
						sprites.doomGuyDyingDirectional1stFrame[1],
						Math.round ((-sprites.doomGuyDyingDirectional1stFrame[1].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
						Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[1] * scaling), 
						offset, c, -1, width);
				break;
			}
			return;
		}

		if (state == SHOOTING) {

			if (animationCounter == 2) {
				calculateDirection(badGuy);
			}

			switch (direction) {
			case 1:
				drawScaled(
						sprites.doomGuyShooting1[animationCounter],
						Math.round (sprites.doomGuyShooting1XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyShooting1YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 2:
				drawScaled(
						sprites.doomGuyShooting2[animationCounter],
						Math.round (sprites.doomGuyShooting2XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyShooting2YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 3:
				drawScaled(
						sprites.doomGuyShooting3[animationCounter],
						Math.round (sprites.doomGuyShooting3XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 4:
				drawScaled(
						sprites.doomGuyShooting4[animationCounter],
						Math.round (sprites.doomGuyShooting4XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 5:
				drawScaled(
						sprites.doomGuyShooting5[animationCounter],
						Math.round (sprites.doomGuyShooting5XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyShooting5YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 6:
				drawScaled(
						sprites.doomGuyShooting4[animationCounter],
						Math.round ((-sprites.doomGuyShooting4[animationCounter].getWidth() + -sprites.doomGuyShooting4XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyShooting4YOffset[animationCounter] * scaling), 
						offset,	c, -1, width);
				break;
			case 7:
				drawScaled(
						sprites.doomGuyShooting3[animationCounter],
						Math.round ((-sprites.doomGuyShooting3[animationCounter].getWidth() + -sprites.doomGuyShooting3XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyShooting3YOffset[animationCounter] * scaling), 
						offset,	c, -1, width);
				break;
			case 8:
				drawScaled(
						sprites.doomGuyShooting2[animationCounter],
						Math.round ((-sprites.doomGuyShooting2[animationCounter].getWidth() + -sprites.doomGuyShooting2XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyShooting2YOffset[animationCounter] * scaling), 
						offset,	c, -1, width);
				break;
			}

			animationCounter++;
			if (animationCounter > 2)  {
				animationCounter = 0;
				loopsSinceLastShot = 0;
				state = WALKING;
				if (!lastShotWasRocket && (minigunBullets > 0 || plasmaCells > 0) && (badGuy.state == Baddie.WALKING || badGuy.state == Baddie.SHOOTING) && (rockets == 0 || calculateDistance(badGuy) < 80 * scaling)) {
					animationCounter = 1;
					state = SHOOTING;
				}
			}
			return;
		}

		if (state == SPAWNING) {

			if (animationCounter > 7) {
				drawScaled(
						sprites.doomGuyWalking1[0],
						Math.round (sprites.doomGuyWalking1XOffset[0] * scaling), 
						Math.round (sprites.doomGuyWalking1YOffset[0] * scaling), 
						offset,	c, 1, width);
			}
			if (animationCounter >= 0) {
				drawScaled(
						sprites.spawning[animationCounter],
						Math.round (sprites.spawningXOffset[animationCounter] * scaling), 
						Math.round (sprites.spawningYOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
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
						sprites.doomGuyWalking1[animationCounter],
						Math.round (sprites.doomGuyWalking1XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyWalking1YOffset[animationCounter] * scaling), 
						offset,	c, 1, width);
				break;
			case 2:
				drawScaled(
						sprites.doomGuyWalking2[animationCounter],
						Math.round (sprites.doomGuyWalking2XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, 1, width);
				break;
			case 3:
				drawScaled(
						sprites.doomGuyWalking3[animationCounter],
						Math.round (sprites.doomGuyWalking3XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, 1, width);
				break;
			case 4:
				drawScaled(
						sprites.doomGuyWalking4[animationCounter],
						Math.round (sprites.doomGuyWalking4XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, 1, width);
				break;
			case 5:
				drawScaled(
						sprites.doomGuyWalking5[animationCounter],
						Math.round (sprites.doomGuyWalking5XOffset[animationCounter] * scaling), 
						Math.round (sprites.doomGuyWalking5YOffset[animationCounter] * scaling), 
						offset, c, 1, width);
				break;
			case 6:
				drawScaled(
						sprites.doomGuyWalking4[animationCounter],
						Math.round ((-sprites.doomGuyWalking4[animationCounter].getWidth() + -sprites.doomGuyWalking4XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyWalking4YOffset[animationCounter] * scaling), 
						offset, c, -1, width);
				break;
			case 7:
				drawScaled(
						sprites.doomGuyWalking3[animationCounter],
						Math.round ((-sprites.doomGuyWalking3[animationCounter].getWidth() + -sprites.doomGuyWalking3XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyWalking3YOffset[animationCounter] * scaling), 
						offset, c, -1, width);
				break;
			case 8:
				drawScaled(
						sprites.doomGuyWalking2[animationCounter],
						Math.round ((-sprites.doomGuyWalking2[animationCounter].getWidth() + -sprites.doomGuyWalking2XOffset[animationCounter]) * scaling), 
						Math.round (sprites.doomGuyWalking2YOffset[animationCounter] * scaling), 
						offset, c, -1, width);
				break;
			}


			animationCounter++;
			if (animationCounter > 3)  {
				animationCounter = 0;
				loopsSinceLastShot++;

				if (badGuy.state == WALKING || badGuy.state == SHOOTING) {

					if (!lastShotWasRocket && (Math.random() > 0.80 || minigunBullets > 0 || plasmaCells > 0)) {
						state = SHOOTING;
					} else if (!lastShotWasRocket && (loopsSinceLastShot == 2 && Math.random() > 0.5)) {
						state = SHOOTING;
					} else if (loopsSinceLastShot > 2) {
						state = SHOOTING;
					}
				}
			}
		}
		if (state == DYING || state == DEAD) {

			if (animationCounter == 0 || animationCounter == 1) {
				switch (direction) {
				case 1:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[0],
							Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[0] * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[0] * scaling), 
							offset,	c, 1, width);
					break;
				case 2:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[1],
							Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[1] * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, 1, width);
					break;
				case 3:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[2],
							Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[2] * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, 1, width);
					break;
				case 4:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[3],
							Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[3] * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, 1, width);
					break;
				case 5:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[4],
							Math.round (sprites.doomGuyDyingDirectional1stFrameXOffset[4] * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[4] * scaling), 
							offset, c, 1, width);
					break;
				case 6:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[3],
							Math.round ((-sprites.doomGuyDyingDirectional1stFrame[3].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[3]) * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[3] * scaling), 
							offset, c, -1, width);
					break;
				case 7:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[2],
							Math.round ((-sprites.doomGuyDyingDirectional1stFrame[2].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[2]) * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[2] * scaling), 
							offset, c, -1, width);
					break;
				case 8:
					drawScaled(
							sprites.doomGuyDyingDirectional1stFrame[1],
							Math.round ((-sprites.doomGuyDyingDirectional1stFrame[1].getWidth() + -sprites.doomGuyDyingDirectional1stFrameXOffset[1]) * scaling), 
							Math.round (sprites.doomGuyDyingDirectional1stFrameYOffset[1] * scaling), 
							offset, c, -1, width);
					break;
				}
			} else if (animationCounter < 15) {
				int counter = (int) Math.ceil((float) animationCounter / 2);
				drawScaled(
						sprites.doomGuyDeathFinalFrames[counter - 1],
						Math.round (sprites.doomGuyDeathFinalFramesXOffset[counter - 1] * scaling), 
						Math.round (sprites.doomGuyDeathFinalFramesYOffset[counter - 1] * scaling), 
						offset,	c, 1, width);
			} else {
				drawScaled(
						sprites.doomGuyDeathFinalFrames[6],
						Math.round (sprites.doomGuyDeathFinalFramesXOffset[4] * scaling), 
						Math.round (sprites.doomGuyDeathFinalFramesYOffset[4] * scaling), 
						offset,	c, 1, width);
			}

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
	private void drawScaled(Bitmap drawMe, int offsetX, int offsetY, float offset, Canvas c, int flip, int width) {
		aMatrix.setScale(scaling * flip, scaling);
		if (flip == 1) {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset), yLoc + offsetY);	
		} else {
			aMatrix.postTranslate(xLoc + offsetX - (width * offset) + (drawMe.getWidth() * scaling), yLoc + offsetY);
		}
		c.drawBitmap(drawMe, aMatrix, null);
	}

	private float angle;

	public void calculateDirection(Baddie badGuy) {
		angle = (float) Math.atan2(xSpeed, -ySpeed) * 180f / (float) Math.PI;

		if (badGuy != null && (badGuy.state == Baddie.WALKING || badGuy.state == Baddie.SHOOTING)) {
			angle = (float) Math.atan2(badGuy.xLoc - xLoc, -(badGuy.yLoc - yLoc)) * 180f / (float) Math.PI;	
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
	public void updateState(PowerUp powerUp, Baddie badGuy, int width, float height, float mOffset, Random random, ArrayList<BloodSplatter> bloodSplatter, ArrayList<Actor> projectiles) {
		// calculate doomguy's movements
		if (state == WALKING) {

			if (powerUp != null && !powerUp.collected && powerUp.spawned) {

				xDiff = powerUp.xLoc - xLoc;
				yDiff = powerUp.yLoc - yLoc;

				if (Math.abs(xDiff) > Math.abs(yDiff)) {
					if (xDiff < 0) {
						xSpeed = -10;
					} else {
						xSpeed = 10;
					}
					if (yDiff < 0) {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -10;
					} else {
						ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 10;
					}
				} else {
					if (yDiff < 0) {
						ySpeed = -10;
					} else {
						ySpeed = 10;
					}
					if (xDiff < 0) {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -10;
					} else {
						xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 10;
					}
				}

				// see if he got it
				if (xLoc > powerUp.xLoc - 20 && xLoc < powerUp.xLoc + 20
						&& yLoc > powerUp.yLoc - 20 && yLoc < powerUp.yLoc + 40) {

					// GOT IT!
					powerUp.collected = true;
					powerUp.spawned = false;

					switch (powerUp.type) {
					case PowerUp.HEALTH:
						health += 25;
						health = Math.min(100, health);	
						break;
					case PowerUp.MINIGUN:
						minigunBullets += 25;
						break;
					case PowerUp.SHOTGUN:
						shotgunBullets += 5;
						break;
					case PowerUp.LAUNCHER:
						rockets += 4;
						break;
					case PowerUp.AMMO_CLIP:
						minigunBullets += 10;
						break;
					case PowerUp.PLASMA_RIFLE:
						plasmaCells += 25;
						break;
					}
				}
			}

			xLoc += (xSpeed * (1 + (yLoc * SCALING)));
			yLoc += (ySpeed * (1 + (yLoc * SCALING)));

			if (powerUp == null || !powerUp.spawned || powerUp.collected) {
				if (xLoc > (width + (mOffset * width)) - 25) {
					xSpeed = random.nextFloat() * -5;
				}
				if (xLoc < 25 + (mOffset * width)) {
					xSpeed = random.nextFloat() * 5;
				}
				if (yLoc < 130) {
					ySpeed = random.nextFloat() * 5;
				}
				if (yLoc > height - 35) {
					ySpeed = random.nextFloat() * -5;
				}
			}

			if (xSpeed > -10 && xSpeed < 10 && ySpeed > -10 && ySpeed < 10) {
				xSpeed *= 1.5;
				ySpeed *= 1.5;
			}
		}
		if (state == SHOOTING && animationCounter == 1 && badGuy.health > 0 && badGuy.state != Baddie.SPAWNING) {

			if (rockets > 0 && calculateDistance(badGuy) > 80 * scaling) {
				lastShotWasRocket = true;
				rockets--;
				Projectile fireball = new Projectile();

				if (Math.abs(xLoc - badGuy.xLoc) > 50
						|| Math.abs(yLoc - badGuy.yLoc) > 50) {

					xDiff = badGuy.xLoc - xLoc;
					yDiff = badGuy.yLoc - yLoc;

					if (Math.abs(xDiff) > Math.abs(yDiff)) {
						if (xDiff < 0) {
							fireball.xSpeed = -21;
						} else {
							fireball.xSpeed = 21;
						}
						if (yDiff < 0) {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -21;
						} else {
							fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 21;
						}
					} else {
						if (yDiff < 0) {
							fireball.ySpeed = -21;
						} else {
							fireball.ySpeed = 21;
						}
						if (xDiff < 0) {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -21;
						} else {
							fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 21;
						}
					}
				}
				fireball.xLoc = this.xLoc + (fireball.xSpeed * (1 + (yLoc * SCALING)));
				fireball.yLoc = this.yLoc + (fireball.ySpeed * (1 + (yLoc * SCALING)));
				fireball.state = Projectile.FLYING;
				fireball.type = Projectile.ROCKET;
				projectiles.add(fireball);
			} else {
				lastShotWasRocket = false;
				if (plasmaCells > 0) {
					plasmaCells--;
					Projectile fireball = new Projectile();
					

					if (Math.abs(xLoc - badGuy.xLoc) > 50
							|| Math.abs(yLoc - badGuy.yLoc) > 50) {

						xDiff = badGuy.xLoc - xLoc;
						yDiff = badGuy.yLoc - yLoc;

						if (Math.abs(xDiff) > Math.abs(yDiff)) {
							if (xDiff < 0) {
								fireball.xSpeed = -29;
							} else {
								fireball.xSpeed = 29;
							}
							if (yDiff < 0) {
								fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * -29;
							} else {
								fireball.ySpeed = Math.abs(yDiff)/Math.abs(xDiff) * 29;
							}
						} else {
							if (yDiff < 0) {
								fireball.ySpeed = -29;
							} else {
								fireball.ySpeed = 29;
							}
							if (xDiff < 0) {
								fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * -29;
							} else {
								fireball.xSpeed = Math.abs(xDiff)/Math.abs(yDiff) * 29;
							}
						}
					}
					fireball.xLoc = this.xLoc + (fireball.xSpeed * (1 + (yLoc * SCALING)));
					fireball.yLoc = this.yLoc + (fireball.ySpeed * (1 + (yLoc * SCALING)));
					fireball.spawned = 4;
					fireball.state = Projectile.FLYING;
					fireball.type = Projectile.PLASMA;
					projectiles.add(fireball);
				} else {
					if (minigunBullets > 0) {
						minigunBullets--;
					} else if (shotgunBullets > 0) {
						shotgunBullets--;
					}
					if (random.nextFloat() > (calculateDistance(badGuy) / 1500)) {
						if (minigunBullets <= 0 && plasmaCells <= 0 && shotgunBullets > 0) {
							badGuy.health -= 8;
						} else {
							badGuy.health -= 2;	
						}
						if (badGuy.health > 0) {
							badGuy.takingDamage = true;
							bloodSplatter.add(badGuy.createBloodSplatter(random));
						}
						if (badGuy instanceof Sarge || badGuy instanceof Cacodemon) {
							badGuy.xLoc -= (badGuy.xSpeed * (1 + (badGuy.yLoc * SCALING)));
							badGuy.yLoc -= (badGuy.ySpeed * (1 + (badGuy.yLoc * SCALING)));
						} else {
							badGuy.xLoc -= 2 * (badGuy.xSpeed * (1 + (badGuy.yLoc * SCALING)));
							badGuy.yLoc -= 2 * (badGuy.ySpeed * (1 + (badGuy.yLoc * SCALING)));	
						}
					}
				}
			}
		}
	}


}
