package com.jamesmgittins.livewallpaper.doom;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Sprites {
	
	public Bitmap[] blood = new Bitmap[3];
	public int[] bloodXOffset = new int[] {-2, -4, -7};
	public int[] bloodYOffset = new int[] {-3, -4, -6};
	
	public Bitmap healthSprite;
	public Bitmap plasmaSprite;
	public Bitmap launcherSprite;
	public Bitmap minigunSprite;
	public Bitmap shotgunSprite;
	public Bitmap shadow;
	public Bitmap ammoClip;
	
	public Bitmap[] plasmaFlying = new Bitmap[2];
	public int[] plasmaFlyingXOffset = new int[] {-7, -6};
	public int[] plasmaFlyingYOffset = new int[] {-39, -38};
	
	public Bitmap[] plasmaExploding = new Bitmap[4];
	public int[] plasmaExplodingXOffset = new int[] {-12, -19, -17, -13};
	public int[] plasmaExplodingYOffset = new int[] {-41, -48, -48, -43};
	
	public Bitmap[] fireballFlying = new Bitmap[2];
	public int[] fireballFlyingXOffset = new int[] {-8, -8};
	public int[] fireballFlyingYOffset = new int[] {-38, -38};
	
	public Bitmap[] fireballExploding = new Bitmap[3];
	public int[] fireballExplodingXOffset = new int[] {-19, -22, -25};
	public int[] fireballExplodingYOffset = new int[] {-48, -52, -54};
	
	public Bitmap[] fireball2Flying = new Bitmap[2];
	public int[] fireball2FlyingXOffset = new int[] {-7, -7};
	public int[] fireball2FlyingYOffset = new int[] {-38, -37};
	
	public Bitmap[] fireball2Exploding = new Bitmap[3];
	public int[] fireball2ExplodingXOffset = new int[] {-23, -25, -26};
	public int[] fireball2ExplodingYOffset = new int[] {-54, -51, -53};
	
	public Bitmap[] greenFireballFlying = new Bitmap[2];
	public int[] greenFireballFlyingXOffset = new int[] {-10, -10};
	public int[] greenFireballFlyingYOffset = new int[] {-38, -38};
	
	public Bitmap[] greenFireballExploding = new Bitmap[3];
	public int[] greenFireballExplodingXOffset = new int[] {-20, -23, -23};
	public int[] greenFireballExplodingYOffset = new int[] {-35, -36, -38};
	
	public Bitmap[] rocketFlying = new Bitmap[5];
	public int[] rocketFlyingXOffset = new int[] {-7, -16, -25, -12, -7};
	public int[] rocketFlyingYOffset = new int[] {-43, -43, -43, -43, -43};
	
	public Bitmap[] rocketExploding = new Bitmap[3];
	public int[] rocketExplodingXOffset = new int[] {-37, -42, -50};
	public int[] rocketExplodingYOffset = new int[] {-59, -64, -73};
	
	public Bitmap[] doomGuyWalking1 = new Bitmap[4];
	public int[] doomGuyWalking1XOffset = new int[] {-18, -19, -17, -16};
	public int[] doomGuyWalking1YOffset = new int[] {-51, -53, -51, -52};
	
	public Bitmap[] doomGuyWalking2 = new Bitmap[4];
	public int[] doomGuyWalking2XOffset = new int[] {-17, -18, -17, -17};
	public int[] doomGuyWalking2YOffset = new int[] {-50, -52, -51, -52};
	
	public Bitmap[] doomGuyWalking3 = new Bitmap[4];
	public int[] doomGuyWalking3XOffset = new int[] {-21, -18, -18, -21};
	public int[] doomGuyWalking3YOffset = new int[] {-50, -52, -51, -52};
	
	public Bitmap[] doomGuyWalking4 = new Bitmap[4];
	public int[] doomGuyWalking4XOffset = new int[] {-21, -21, -22, -23};
	public int[] doomGuyWalking4YOffset = new int[] {-49, -52, -51, -52};
	
	public Bitmap[] doomGuyWalking5 = new Bitmap[4];
	public int[] doomGuyWalking5XOffset = new int[] {-21, -18, -17, -19};
	public int[] doomGuyWalking5YOffset = new int[] {-47, -51, -50, -51};
	
	public Bitmap[] doomGuyShooting1 = new Bitmap[3];
	public int[] doomGuyShooting1XOffset = new int[] {-12, -12, -12};
	public int[] doomGuyShooting1YOffset = new int[] {-51, -51, -51};
	
	public Bitmap[] doomGuyShooting2 = new Bitmap[3];
	public int[] doomGuyShooting2XOffset = new int[] {-21, -23, -21};
	public int[] doomGuyShooting2YOffset = new int[] {-51, -51, -51};
	
	public Bitmap[] doomGuyShooting3 = new Bitmap[3];
	public int[] doomGuyShooting3XOffset = new int[] {-26, -27, -26};
	public int[] doomGuyShooting3YOffset = new int[] {-50, -50, -50};
	
	public Bitmap[] doomGuyShooting4 = new Bitmap[3];
	public int[] doomGuyShooting4XOffset = new int[] {-18, -20, -18};
	public int[] doomGuyShooting4YOffset = new int[] {-48, -48, -48};
	
	public Bitmap[] doomGuyShooting5 = new Bitmap[3];
	public int[] doomGuyShooting5XOffset = new int[] {-12, -11, -12};
	public int[] doomGuyShooting5YOffset = new int[] {-46, -46, -46};
	
	public Bitmap[] doomGuyDyingDirectional1stFrame = new Bitmap[5];
	public int[] doomGuyDyingDirectional1stFrameXOffset = new int[] {-20, -16, -21, -20, -17};
	public int[] doomGuyDyingDirectional1stFrameYOffset = new int[] {-52, -52, -52, -50, -50};
	
	public Bitmap[] doomGuyDeathFinalFrames = new Bitmap[7];
	public int[] doomGuyDeathFinalFramesXOffset = new int[] {-16, -11, -12, -17, -27, -27, -27};
	public int[] doomGuyDeathFinalFramesYOffset = new int[] {-47, -39, -43, -34, -9, -9, -9};
	
	public Bitmap[] spawning = new Bitmap[10];
	public int[] spawningXOffset = new int[] {-19, -19, -20, -15, -8, -4, -1, -3, -6, -8};
	public int[] spawningYOffset = new int[] {-58, -51, -45, -44, -34, -30, -27, -29, -28, -30};
	
	public Sprites(Resources res) {
		blood[0] = BitmapFactory.decodeResource(res, R.drawable.bluda0);
		blood[1] = BitmapFactory.decodeResource(res, R.drawable.bludb0);
		blood[2] = BitmapFactory.decodeResource(res, R.drawable.bludc0);
		
		rocketFlying[0] = BitmapFactory.decodeResource(res, R.drawable.misla1);		
		rocketFlying[1] = BitmapFactory.decodeResource(res, R.drawable.misla8a2);
		rocketFlying[2] = BitmapFactory.decodeResource(res, R.drawable.misla7a3);
		rocketFlying[3] = BitmapFactory.decodeResource(res, R.drawable.misla6a4);
		rocketFlying[4] = BitmapFactory.decodeResource(res, R.drawable.misla5);	
		
		rocketExploding[0] = BitmapFactory.decodeResource(res, R.drawable.mislb0);
		rocketExploding[1] = BitmapFactory.decodeResource(res, R.drawable.mislc0);
		rocketExploding[2] = BitmapFactory.decodeResource(res, R.drawable.misld0);
		
		doomGuyWalking1[0] = BitmapFactory.decodeResource(res, R.drawable.playa1);
		doomGuyWalking1[1] = BitmapFactory.decodeResource(res, R.drawable.playb1);
		doomGuyWalking1[2] = BitmapFactory.decodeResource(res, R.drawable.playc1);
		doomGuyWalking1[3] = BitmapFactory.decodeResource(res, R.drawable.playd1);
		
		doomGuyWalking2[0] = BitmapFactory.decodeResource(res, R.drawable.playa2a8);
		doomGuyWalking2[1] = BitmapFactory.decodeResource(res, R.drawable.playb2b8);
		doomGuyWalking2[2] = BitmapFactory.decodeResource(res, R.drawable.playc2c8);
		doomGuyWalking2[3] = BitmapFactory.decodeResource(res, R.drawable.playd2d8);
		
		doomGuyWalking3[0] = BitmapFactory.decodeResource(res, R.drawable.playa3a7);
		doomGuyWalking3[1] = BitmapFactory.decodeResource(res, R.drawable.playb3b7);
		doomGuyWalking3[2] = BitmapFactory.decodeResource(res, R.drawable.playc3c7);
		doomGuyWalking3[3] = BitmapFactory.decodeResource(res, R.drawable.playd3d7);
		
		doomGuyWalking4[0] = BitmapFactory.decodeResource(res, R.drawable.playa4a6);
		doomGuyWalking4[1] = BitmapFactory.decodeResource(res, R.drawable.playb4b6);
		doomGuyWalking4[2] = BitmapFactory.decodeResource(res, R.drawable.playc4c6);
		doomGuyWalking4[3] = BitmapFactory.decodeResource(res, R.drawable.playd4d6);
		
		doomGuyWalking5[0] = BitmapFactory.decodeResource(res, R.drawable.playa5);
		doomGuyWalking5[1] = BitmapFactory.decodeResource(res, R.drawable.playb5);
		doomGuyWalking5[2] = BitmapFactory.decodeResource(res, R.drawable.playc5);
		doomGuyWalking5[3] = BitmapFactory.decodeResource(res, R.drawable.playd5);
		
		doomGuyShooting1[0] = BitmapFactory.decodeResource(res, R.drawable.playe1);
		doomGuyShooting1[1] = BitmapFactory.decodeResource(res, R.drawable.playf1);
		doomGuyShooting1[2] = BitmapFactory.decodeResource(res, R.drawable.playe1);
		
		doomGuyShooting2[0] = BitmapFactory.decodeResource(res, R.drawable.playe2e8);
		doomGuyShooting2[1] = BitmapFactory.decodeResource(res, R.drawable.playf2f8);
		doomGuyShooting2[2] = BitmapFactory.decodeResource(res, R.drawable.playe2e8);
		
		doomGuyShooting3[0] = BitmapFactory.decodeResource(res, R.drawable.playe3e7);
		doomGuyShooting3[1] = BitmapFactory.decodeResource(res, R.drawable.playf3f7);
		doomGuyShooting3[2] = BitmapFactory.decodeResource(res, R.drawable.playe3e7);
		
		doomGuyShooting4[0] = BitmapFactory.decodeResource(res, R.drawable.playe4e6);
		doomGuyShooting4[1] = BitmapFactory.decodeResource(res, R.drawable.playf4f6);
		doomGuyShooting4[2] = BitmapFactory.decodeResource(res, R.drawable.playe4e6);
		
		doomGuyShooting5[0] = BitmapFactory.decodeResource(res, R.drawable.playe5);
		doomGuyShooting5[1] = BitmapFactory.decodeResource(res, R.drawable.playf5);
		doomGuyShooting5[2] = BitmapFactory.decodeResource(res, R.drawable.playe5);
		
		doomGuyDyingDirectional1stFrame[0] = BitmapFactory.decodeResource(res, R.drawable.playg1);
		doomGuyDyingDirectional1stFrame[1] = BitmapFactory.decodeResource(res, R.drawable.playg2g8);
		doomGuyDyingDirectional1stFrame[2] = BitmapFactory.decodeResource(res, R.drawable.playg3g7);
		doomGuyDyingDirectional1stFrame[3] = BitmapFactory.decodeResource(res, R.drawable.playg4g6);
		doomGuyDyingDirectional1stFrame[4] = BitmapFactory.decodeResource(res, R.drawable.playg5);
		
		doomGuyDeathFinalFrames[0] = BitmapFactory.decodeResource(res, R.drawable.playh0);
		doomGuyDeathFinalFrames[1] = BitmapFactory.decodeResource(res, R.drawable.playi0);
		doomGuyDeathFinalFrames[2] = BitmapFactory.decodeResource(res, R.drawable.playj0);
		doomGuyDeathFinalFrames[3] = BitmapFactory.decodeResource(res, R.drawable.playk0);
		doomGuyDeathFinalFrames[4] = BitmapFactory.decodeResource(res, R.drawable.playl0);
		doomGuyDeathFinalFrames[5] = BitmapFactory.decodeResource(res, R.drawable.playm0);
		doomGuyDeathFinalFrames[6] = BitmapFactory.decodeResource(res, R.drawable.playn0);
		
		spawning[0] = BitmapFactory.decodeResource(res, R.drawable.tfoga0);
		spawning[1] = BitmapFactory.decodeResource(res, R.drawable.tfogb0);
		spawning[2] = BitmapFactory.decodeResource(res, R.drawable.tfogc0);
		spawning[3] = BitmapFactory.decodeResource(res, R.drawable.tfogd0);
		spawning[4] = BitmapFactory.decodeResource(res, R.drawable.tfoge0);
		spawning[5] = BitmapFactory.decodeResource(res, R.drawable.tfogf0);
		spawning[6] = BitmapFactory.decodeResource(res, R.drawable.tfogg0);
		spawning[7] = BitmapFactory.decodeResource(res, R.drawable.tfogh0);
		spawning[8] = BitmapFactory.decodeResource(res, R.drawable.tfogi0);
		spawning[9] = BitmapFactory.decodeResource(res, R.drawable.tfogj0);
		
		plasmaSprite = BitmapFactory.decodeResource(res, R.drawable.plasa0);
		healthSprite = BitmapFactory.decodeResource(res, R.drawable.health);
		launcherSprite = BitmapFactory.decodeResource(res, R.drawable.launcher);
		minigunSprite = BitmapFactory.decodeResource(res, R.drawable.minigun);
		shadow = BitmapFactory.decodeResource(res, R.drawable.dropshadow);
		shotgunSprite = BitmapFactory.decodeResource(res, R.drawable.shotgun);
		ammoClip = BitmapFactory.decodeResource(res, R.drawable.clipa0);
		
		plasmaFlying[0] = BitmapFactory.decodeResource(res, R.drawable.plssa0);
		plasmaFlying[1] = BitmapFactory.decodeResource(res, R.drawable.plssb0);
		
		plasmaExploding[0] = BitmapFactory.decodeResource(res, R.drawable.plsea0);
		plasmaExploding[1] = BitmapFactory.decodeResource(res, R.drawable.plseb0);
		plasmaExploding[2] = BitmapFactory.decodeResource(res, R.drawable.plsec0);
		plasmaExploding[3] = BitmapFactory.decodeResource(res, R.drawable.plsed0);
		
		fireballFlying[0] = BitmapFactory.decodeResource(res, R.drawable.fireballfly1);
		fireballFlying[1] = BitmapFactory.decodeResource(res, R.drawable.fireballfly2);
		
		fireballExploding[0] = BitmapFactory.decodeResource(res, R.drawable.fireballexp1);
		fireballExploding[1] = BitmapFactory.decodeResource(res, R.drawable.fireballexp2);
		fireballExploding[2] = BitmapFactory.decodeResource(res, R.drawable.fireballexp3);
		
		fireball2Flying[0] = BitmapFactory.decodeResource(res, R.drawable.bal2a0);
		fireball2Flying[1] = BitmapFactory.decodeResource(res, R.drawable.bal2b0);
		
		fireball2Exploding[0] = BitmapFactory.decodeResource(res, R.drawable.bal2c0);
		fireball2Exploding[1] = BitmapFactory.decodeResource(res, R.drawable.bal2d0);
		fireball2Exploding[2] = BitmapFactory.decodeResource(res, R.drawable.bal2e0);
		
		greenFireballFlying[0] = BitmapFactory.decodeResource(res, R.drawable.bal7a1a5);
		greenFireballFlying[1] = BitmapFactory.decodeResource(res, R.drawable.bal7b1b5);
		
		greenFireballExploding[0] = BitmapFactory.decodeResource(res, R.drawable.bal7c0);
		greenFireballExploding[1] = BitmapFactory.decodeResource(res, R.drawable.bal7d0);
		greenFireballExploding[2] = BitmapFactory.decodeResource(res, R.drawable.bal7e0);
	}

}
