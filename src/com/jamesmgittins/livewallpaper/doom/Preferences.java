package com.jamesmgittins.livewallpaper.doom;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity implements
		OnSharedPreferenceChangeListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		getPreferenceManager().setSharedPreferencesName(
                DoomLiveWallpaper.PREFERENCES);
        addPreferencesFromResource(R.xml.settings);
        
        
        getPreferenceManager().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub

	}
	
	@Override
    protected void onDestroy() {
        getPreferenceManager().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

}
