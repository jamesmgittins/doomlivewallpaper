package com.jamesmgittins.livewallpaper.doom;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class SettingsTabActivity extends TabActivity{
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tablayout);
	    
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, Preferences.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("Buy").setContent(intent);
	    spec.setIndicator("Buy");
//	    spec.setIndicator("Buy", getResources().getDrawable(R.drawable.buy));
	    
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);	    
	}
}
