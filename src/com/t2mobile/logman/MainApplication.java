package com.t2mobile.logman;

import android.app.Application;

import com.t2mobile.logman.storage.ILogSaveType;
import com.t2mobile.logman.storage.IRunningConfig;
import com.t2mobile.logman.storage.IStageConfig;
import com.t2mobile.logman.storage.SettingManager;

public class MainApplication extends Application {

	private IRunningConfig runningConfig;

	private IStageConfig stageConfig;

	private ILogSaveType logsavetype;

	@Override
	public void onCreate() {
		
		super.onCreate();

		this.runningConfig = SettingManager.runningConfigInstance(getApplicationContext());

		this.stageConfig = SettingManager.stageConfigInstance(getApplicationContext());

		this.logsavetype = SettingManager.logSaveTypeInstance(getApplicationContext());
	}

	public IRunningConfig getRunningConfig() {
		return runningConfig;
	}

	public IStageConfig getStageConfig() {
		return stageConfig;
	}

	public ILogSaveType getLogsavetype() {
		return logsavetype;
	}
}
