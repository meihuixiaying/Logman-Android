package com.t2mobile.logman.activity;

import android.R.anim;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.t2mobile.logman.R;

/**
 * 闪屏界面
 * 
 *
 * @author songlin.ji
 */
public class SplashActivity extends Activity {
	private static final int SPLASH_TIME = 2000;

	@SuppressLint("HandlerLeak")
	private Handler splashHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.setAction(MainActivity.ACTION);
			startActivity(intent);
			overridePendingTransition(anim.fade_in, anim.fade_out);
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		splashHandler.sendEmptyMessageDelayed(0, SPLASH_TIME);
	}

	@Override
	public void onBackPressed() {
	}
}
