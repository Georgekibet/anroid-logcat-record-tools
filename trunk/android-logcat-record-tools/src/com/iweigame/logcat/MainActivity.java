package com.iweigame.logcat;

import java.io.File;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.iweigame.logcat.R;
import com.iweigame.logcat.util.LogCatUtil;

public class MainActivity extends Activity {

	LogCatUtil logUtil = new LogCatUtil("droidlog", "tag", "D");

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.v("tag", ">>>>>>>>>>>>>>>>>>>>"
				+ Environment.getExternalStorageDirectory().getPath()
						.toString());

		logUtil.writeLogToFile();
		

//
		

	
	}

}