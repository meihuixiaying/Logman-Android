/*
 * @Title:     SettingManager.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.storage;

import android.content.Context;

public class SettingManager {

	private static IRunningConfig runningConfig;

	private static IStageConfig stageConfig;

	private static ILogSaveType logSaveType;

	public synchronized static final IRunningConfig runningConfigInstance(Context context) {

		if (runningConfig == null) {
			runningConfig = new RunningConfig(context);
		}

		return runningConfig;
	}

	public synchronized static final IStageConfig stageConfigInstance(Context context) {
		if (stageConfig == null) {
			stageConfig = new StageConfig(context);
		}

		return stageConfig;
	}

	public synchronized static final ILogSaveType logSaveTypeInstance(Context context) {
		if (logSaveType == null) {
			logSaveType = new LogSaveType(context);
		}

		return logSaveType;
	}
}
