package com.blacknovamedia.cameratimer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;

import com.blacknovamedia.cameratimer.R;

public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);

		ImageView img = (ImageView) findViewById(R.id.bnmLogo);
		img.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.blacknovamedia.com"));
				startActivity(Intent.createChooser(viewIntent, "Black Nova Media Limited"));
				
				return false;
			}
		});
		
	}

	// sets FLAG_ACTIVITY_NO_HISTORY so exiting and relaunching won't go back to help screen
	public static Intent startIntent(Context parent) {
    	Intent aboutIntent = new Intent(parent, AboutActivity.class);
    	aboutIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
    	parent.startActivity(aboutIntent);
    	return aboutIntent;
	}
	
	@Override
	public void onBackPressed() {
		Intent newAct = new Intent();
	       newAct.setClass( this, MainActivity.class );
	       newAct.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);	    	
	       startActivity( newAct );		
	}
}
