package com.jamesmgittins.livewallpaper.doom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class DoomLiveWallpaper extends WallpaperService {

	public static final String PREFERENCES = "com.gittins.livewallpaper.doom";
	private final Handler mHandler = new Handler();

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public Engine onCreateEngine() {
		return new WallpaperEngine();
	}

	class WallpaperEngine extends Engine implements
			SharedPreferences.OnSharedPreferenceChangeListener {
		
		private static final int PISTOL_GUY = 0;
		private static final int SHOTGUN_GUY = 1;
		private static final int IMP = 2;
		private static final int SARGE = 3;
		private static final int BARON = 4;
		private static final int CACODEMON = 5;
		
		private int[][] waves = new int[][]{
				new int[]{PISTOL_GUY, SHOTGUN_GUY}, // wave 1
				new int[]{IMP, IMP, IMP}, // wave 2
				new int[]{SHOTGUN_GUY, SARGE, SARGE, PISTOL_GUY}, // wave 3
				new int[]{SHOTGUN_GUY, IMP, SARGE, IMP}, // wave 4
				new int[]{CACODEMON, IMP, SARGE}, // wave 5
				new int[]{SHOTGUN_GUY, SARGE, IMP, PISTOL_GUY, IMP}, // wave 6
				new int[]{SHOTGUN_GUY, SARGE, IMP, PISTOL_GUY, CACODEMON}, // wave 7
				new int[]{BARON, BARON}}; // wave 8
		
		private int currentWave = 1;
		private boolean mVisible;
		private float mOffset = 0.5f;
		private Random random;
		private DoomGuy doomGuy;
		private Baddie baddie;
		private Bitmap background;
		private int mTouchX;
		private int mTouchY;
		private boolean newTouchEvent;
		private int threadedWidth = 480;
		private int threadedHeight = 800;
		private int width = 480;
		private int height = 800;
		private PowerUp powerUp;
		private PowerUp targetedPowerUp;
		private int backgroundPreference;
		
		private Sprites sprites;
		
		private int currentBackground = 1;
		
		private long nextWave;
		private static final int SPEED_SLOW = 0;
		private static final int SPEED_NORMAL = 1;
		private static final int SPEED_FAST = 2;
		private static final int SPEED_WARP = 3;
		
		private int animationSpeed = SPEED_NORMAL;
		
		private boolean allBadGuysDead = false;
		
		private volatile boolean godMode;
		private volatile boolean powerUps;
		private volatile boolean randomWaves;
		private volatile int maxMonsters;
		
		private long currentTime;
		
		private ArrayList<Actor> actors;
		private ArrayList<Actor> corpses = new ArrayList<Actor>();
		private ArrayList<Actor> projectiles = new ArrayList<Actor>();
		private ArrayList<BloodSplatter> bloodSplatter = new ArrayList<BloodSplatter>();
		private ArrayList<PowerUp> powerUpList = new ArrayList<PowerUp>();
		
		private Comparator<Actor> actorCompare = new Comparator<Actor>(){
			@Override
			public int compare(Actor object1, Actor object2) {
				return new Float(object1.yLoc).compareTo(object2.yLoc);
			}};
				
		private final Runnable mDrawCube = new Runnable() {
			public void run() {
				drawFrame();
			}
		};

		void drawFrame() {
			
			currentTime = System.currentTimeMillis();
			
			width = threadedWidth;
			height = threadedHeight;
			
			if (sprites == null) {
				sprites = new Sprites(getResources());
			}

			// update all the positions of stuff
			updateState();
			
			final SurfaceHolder holder = getSurfaceHolder();
			Canvas c = null;
			try {
				c = holder.lockCanvas();
				if (c != null) {
					
					// blank the frame
					c.drawARGB(255, 170, 20, 0);
					
					// draw the background
					if (background == null) {
						Options opts = new Options();
						opts.outWidth = width * 2;
						
						switch (backgroundPreference) {
						case 0:
							switch (currentBackground) {
							case 1:
								background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg1), width * 2, height, true);
								break;
							case 2:
								background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg2), width * 2, height, true);
								break;
							case 3:
								background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg3), width * 2, height, true);
								break;
							case 4:
								background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg4), width * 2, height, true);
								break;
							default:
								background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg1), width * 2, height, true);
								break;
							}
							break;
						case 1:
							background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg1), width * 2, height, true);
							break;
						case 2:
							background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg2), width * 2, height, true);
							break;
						case 3:
							background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg3), width * 2, height, true);
							break;
						case 4:
							background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg4), width * 2, height, true);
							break;
						}
					}
					c.drawBitmap(background, Math.round(0 - (width * mOffset)), 0, null);
					
					Collections.sort(actors, actorCompare);
					
					for (Actor actor : actors) {
						if (actor instanceof Baddie) {
							((Baddie)actor).draw(c, mOffset, doomGuy, width, height, sprites);
							continue;
						}
						if (actor instanceof Projectile) {
							((Projectile)actor).draw(c, mOffset, width, sprites);
							continue;
						}
						if (actor instanceof DoomGuy) {
							doomGuy.draw(c, mOffset, baddie, width, height, sprites);
							continue;
						}
						if (actor instanceof PowerUp) {
							((PowerUp)actor).draw(c, mOffset, sprites);
							continue;
						}
					}
					
					for (BloodSplatter blood : bloodSplatter) {
						blood.draw(c, mOffset, width, sprites);
					}
					
					if (doomGuy != null && doomGuy.health <= 0 && currentTime < nextWave) {
						c.drawARGB(255 - Math.round((nextWave - currentTime) / 10000f * 255f), 170, 20, 0);
					}
				}
			} finally {
				if (c != null)
					holder.unlockCanvasAndPost(c);
			}

			// Reschedule the next redraw
			mHandler.removeCallbacks(mDrawCube);
			if (mVisible) {				
				switch (animationSpeed) {
				case SPEED_SLOW:
					mHandler.postDelayed(mDrawCube, 115 - (System.currentTimeMillis() - currentTime));
					break;
				case SPEED_NORMAL:
					mHandler.postDelayed(mDrawCube, 100 - (System.currentTimeMillis() - currentTime));
					break;
				case SPEED_FAST:
					mHandler.postDelayed(mDrawCube, 85 - (System.currentTimeMillis() - currentTime));
					break;
				case SPEED_WARP:
					mHandler.postDelayed(mDrawCube, 20 - (System.currentTimeMillis() - currentTime));
					break;
				default:
					mHandler.postDelayed(mDrawCube, 100 - (System.currentTimeMillis() - currentTime));
					break;
				}
			}
		}
		
		private int randomMobs;
		
		public void updateState() {
			
			projectiles.clear();
			powerUpList.clear();
			
			if (allBadGuysDead && currentTime > nextWave) {				
				corpses.clear();
				bloodSplatter.clear();				
				for (Actor actor : actors) {
					if (actor instanceof Baddie) {
						if (((Baddie)actor).opacity > 0) {
							corpses.add(actor);
						}
					}
					if (actor instanceof PowerUp) {
						if (!((PowerUp)actor).collected) {
							corpses.add(actor);
						}
					}
				}				
				actors = null;				
				currentWave++;
				if (currentWave > waves.length) {
					currentWave = 1;
					background = null;
					currentBackground++;
					if (currentBackground > 6) {
						currentBackground = 1;
					}
				}
			}
			if (doomGuy != null && doomGuy.health <= 0 && currentTime > nextWave) {
				powerUp = null;
				actors = null;
				currentWave = 1;
				doomGuy = null;
				baddie = null;
				background = null;
				currentBackground++;
				if (currentBackground > 6) {
					currentBackground = 1;
				}
				bloodSplatter.clear();
			}
			
			if (actors == null) {
				actors = new ArrayList<Actor> ();
				
				actors.addAll(corpses);
								
				if (doomGuy == null) {
					// create the doomGuy object
					doomGuy = new DoomGuy();
					doomGuy.xLoc = mOffset * (float) width + (width / 2);
					doomGuy.yLoc = height / 2;
					doomGuy.minigunBullets = 0;
					doomGuy.rockets = 0;
					doomGuy.shotgunBullets = 0;
					doomGuy.xSpeed = 1;
					doomGuy.ySpeed = 1;
					doomGuy.state = DoomGuy.SPAWNING;
					doomGuy.animationCounter = -20;
				}
				actors.add(doomGuy);
				
				if (randomWaves) {
					randomMobs = random.nextInt(maxMonsters + 1) + 1;
					
					for (int i = 0; i < randomMobs; i++) {
						
						float probability = random.nextFloat();	
						if (probability > 0.9) {
							actors.add(createCacodemon((currentWave * 10) + i));
							continue;
						}
						if (probability > 0.8) {
							actors.add(createBaron((currentWave * 10) + i));
							continue;
						}
						if (probability > 0.6) {
							actors.add(createSarge((currentWave * 10) + i));
							continue;
						}
						if (probability > 0.4) {
							actors.add(createImp((currentWave * 10) + i));
							continue;
						}
						if (probability > 0.2) {
							actors.add(createShotgunGuy((currentWave * 10) + i));
							continue;
						}
						actors.add(createPistolGuy((currentWave * 10) + i));
					}
				} else {
					for (int i = 0; i < waves[currentWave-1].length; i++) {
						
						switch (waves[currentWave-1][i]) {
						
						case PISTOL_GUY:
							actors.add(createPistolGuy((currentWave * 10) + i));		
							break;
						case SHOTGUN_GUY:
							actors.add(createShotgunGuy((currentWave * 10) + i));						
							break;
						case IMP:
							actors.add(createImp((currentWave * 10) + i));	
							break;
						case SARGE:
							actors.add(createSarge((currentWave * 10) + i));	
							break;
						case BARON:						
							actors.add(createBaron((currentWave * 10) + i));	
							break;
						case CACODEMON:
							actors.add(createCacodemon((currentWave * 10) + i));
							break;
						}
					}
				}
			}
						
			// check for new powerups
			if (newTouchEvent) {
				newTouchEvent = false;
				
				if (powerUp == null || powerUp.spawned) {
					powerUp = new PowerUp();
					powerUp.collected = false;				
					powerUp.spawned = false;
					powerUpList.add(powerUp);
				}
				powerUp.spawnTime = currentTime;
				powerUp.xLoc = mTouchX;
				powerUp.yLoc = mTouchY;
				if (doomGuy.health > 99) {
					switch (random.nextInt(4)) {
					case 0:
						powerUp.type = PowerUp.SHOTGUN;
						break;						
					case 1:
						powerUp.type = PowerUp.LAUNCHER;
						break;						
					case 2:
						powerUp.type = PowerUp.MINIGUN;
						break;
					case 3:
						powerUp.type = PowerUp.PLASMA_RIFLE;
						break;
					}
				} else {
					switch (random.nextInt(5)) {
					case 0:
						powerUp.type = PowerUp.SHOTGUN;
						break;						
					case 1:
						powerUp.type = PowerUp.LAUNCHER;
						break;						
					case 2:
						powerUp.type = PowerUp.MINIGUN;
						break;
					case 3:						
						powerUp.type = PowerUp.HEALTH;
						break;
					case 4:
						powerUp.type = PowerUp.PLASMA_RIFLE;
						break;
					}
				}
			}
			allBadGuysDead = true;
			
			for (Actor actor : actors) {
				if (actor instanceof Baddie) {
					
					((Baddie) actor).updateState(doomGuy, godMode, random, projectiles, actors, bloodSplatter, powerUpList);
					
					if (((Baddie) actor).health > 0) {
						allBadGuysDead = false;
					}
					
					if (baddie == null) {
						baddie = (Baddie) actor;
					}
					
					if ((baddie.health < 1 || baddie.state == Baddie.SPAWNING) && ((Baddie)actor).badguy_id != baddie.badguy_id) {
						baddie = (Baddie) actor;
					}
				}
				if (actor instanceof Projectile) {
					((Projectile) actor).updateState(actors, godMode);
				}
			}
			if (allBadGuysDead && currentTime > nextWave) {
				nextWave = currentTime + 500;
				if (currentWave == waves.length) {
					nextWave = currentTime + 5000;
				}
			}
			
			actors.addAll(powerUpList);
			
			if (targetedPowerUp == null || targetedPowerUp.collected || !targetedPowerUp.spawned) {
				for (Actor actor : actors) {
					if (actor instanceof PowerUp) {
						if (!((PowerUp)actor).collected && ((PowerUp)actor).spawned) {
							targetedPowerUp = (PowerUp) actor;
						}
					}
				}
			}
			
			doomGuy.updateState(targetedPowerUp, baddie, width, height, mOffset, random, bloodSplatter, projectiles);
			
			if (doomGuy.health <= 0 && currentTime > nextWave) {
				nextWave = currentTime + 10000;
			}
			
			actors.addAll(projectiles);
		}
		
		private PistolGuy createPistolGuy(int id) {
			PistolGuy pistolGuy = new PistolGuy(getResources());
			pistolGuy.health = 6;
			pistolGuy.xSpeed = 4;
			pistolGuy.ySpeed = 1;
			pistolGuy.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			pistolGuy.yLoc = 100 + random.nextInt(height - 150);
			pistolGuy.badguy_id = id;
			pistolGuy.state = Baddie.SPAWNING;
			pistolGuy.animationCounter = (-1 * random.nextInt(150)) - 20;
			return pistolGuy;
		}
		
		private ShotgunGuy createShotgunGuy(int id) {
			ShotgunGuy shotgunGuy = new ShotgunGuy(getResources());
			shotgunGuy.health = 9;
			shotgunGuy.xSpeed = 4;
			shotgunGuy.ySpeed = 1;
			shotgunGuy.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			shotgunGuy.yLoc = 100 + random.nextInt(height - 150);
			shotgunGuy.badguy_id = id;
			shotgunGuy.state = Baddie.SPAWNING;
			shotgunGuy.animationCounter = (-1 * random.nextInt(150)) - 20;
			return shotgunGuy;
		}
		
		private Imp createImp(int id) {
			Imp imp = new Imp(getResources());
			imp.health = 11;
			imp.xSpeed = 4;
			imp.ySpeed = 1;
			imp.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			imp.yLoc = 100 + random.nextInt(height - 150);
			imp.badguy_id = id;
			imp.state = Baddie.SPAWNING;
			imp.animationCounter = (-1 * random.nextInt(150)) - 20;
			return imp;
		}
		
		private Cacodemon createCacodemon(int id) {
			Cacodemon caco = new Cacodemon(getResources());
			caco.health = 34;
			caco.xSpeed = 4;
			caco.ySpeed = 1;
			caco.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			caco.yLoc = 100 + random.nextInt(height - 150);
			caco.badguy_id = id;
			caco.state = Baddie.SPAWNING;
			caco.animationCounter = (-1 * random.nextInt(150)) - 20;
			return caco;
		}
		
		private Sarge createSarge(int id) {
			Sarge sarge = new Sarge(getResources());
			sarge.health = 16;
			sarge.xSpeed = 4;
			sarge.ySpeed = 1;
			sarge.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			sarge.yLoc = 100 + random.nextInt(height - 150);
			sarge.badguy_id = id;
			sarge.state = Baddie.SPAWNING;
			sarge.animationCounter = (-1 * random.nextInt(150)) - 20;
			return sarge;
		}
		
		private Baron createBaron(int id) {
			Baron baron = new Baron(getResources());
			baron.health = 40;
			baron.xSpeed = 4;
			baron.ySpeed = 1;
			baron.xLoc = mOffset * (float) width + (float) (random.nextInt(width));
			baron.yLoc = 100 + random.nextInt(height - 150);
			baron.badguy_id = id;
			baron.state = Baddie.SPAWNING;
			baron.animationCounter = (-1 * random.nextInt(150)) - 20;
			return baron;
		}

		@Override
		public void onSharedPreferenceChanged(
				SharedPreferences sharedPreferences, String key) {
			godMode = sharedPreferences.getBoolean("godmode", false);
			powerUps = sharedPreferences.getBoolean("touchscreen", true);
			randomWaves = sharedPreferences.getBoolean("randomWaves", false);
			animationSpeed = Integer.parseInt((sharedPreferences.getString("animationspeed", "1")));
			backgroundPreference = Integer.parseInt((sharedPreferences.getString("background", "0")));
			maxMonsters = sharedPreferences.getInt("maxmonsters", 5);
			background = null;
		}
		
		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);

			// By default we don't get touch events, so enable them.
			setTouchEventsEnabled(true);
		}
		
		@Override
		public void onDestroy() {
			super.onDestroy();
			mHandler.removeCallbacks(mDrawCube);
		}
		
		@Override
        public void onOffsetsChanged(float xOffset, float yOffset,
                float xStep, float yStep, int xPixels, int yPixels) {
            mOffset = xOffset;
        }

		@Override
		public void onVisibilityChanged(boolean visible) {
			mVisible = visible;
			if (visible) {
				drawFrame();
			} else {
				mHandler.removeCallbacks(mDrawCube);
			}
		}
		
		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			
			super.onSurfaceChanged(holder, format, width, height);
			this.threadedWidth = width;
			this.threadedHeight = height;
			background = null;
			drawFrame();
		}
		
		@Override
		public void onTouchEvent(MotionEvent event) {

			if (event.getAction() == MotionEvent.ACTION_DOWN && powerUps) {
				mTouchX = (int) event.getX() + (int)(mOffset * width);
				mTouchY = (int) event.getY();
				newTouchEvent = true;
			}
			super.onTouchEvent(event);
		}
		
		WallpaperEngine() {			
			random = new Random(System.currentTimeMillis());
			
			SharedPreferences sharedPreferences = getSharedPreferences("com.gittins.livewallpaper.doom", 0);
			sharedPreferences.registerOnSharedPreferenceChangeListener(this);
			
			if (!sharedPreferences.contains("godmode")) {
				Editor editor = sharedPreferences.edit();
				editor.putBoolean("godmode", false);
				editor.putBoolean("touchscreen", true);
				editor.putBoolean("randomWaves", false);
				editor.putString("animationspeed", "1");
				editor.putString("background", "0");
				editor.putInt("maxmonsters", 5);
				editor.commit();
			}
			
			godMode = sharedPreferences.getBoolean("godmode", false);
			powerUps = sharedPreferences.getBoolean("touchscreen", true);
			randomWaves = sharedPreferences.getBoolean("randomWaves", false);
			animationSpeed = Integer.parseInt((sharedPreferences.getString("animationspeed", "1")));
			backgroundPreference = Integer.parseInt((sharedPreferences.getString("background", "0")));
			maxMonsters = sharedPreferences.getInt("maxmonsters", 5);
		}

	}

}
