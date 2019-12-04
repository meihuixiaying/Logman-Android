/*
 * @Title:     SettingPreference.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    songlin.ji
 */
package com.t2mobile.logman.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 
 *
 * @author songlin.ji
 */
class RunningConfig implements IRunningConfig {
	private static final int DEFAULT_QXDM_SIZE = 50;

	private static final String RUNNING_PREFERENCE_NAME = "logman_setting";

	private static final String SETTING_NOTIFICATION = "notification";

	private static final String SETTING_STORAGE_INTERNAL = "stroageInternal";

	private static final String SETTING_QXDM_DEFAULT = "qxdmDefault";
	private static final String SETTING_QXDM_SIZE = "qxdmSize";
	private static final String SETTING_QXDM_CFG = "qxdmUserCFG";

	private static final String SETTING_LOGCAT_DEFAULT = "logcatDefault";
	private static final String SETTING_MMS_DEFAULT = "mmsDefault";
	private static final String SETTING_FOTA_DEFAULT = "fotaDefault";

	private SharedPreferences sp;

	private boolean notification;

	private boolean qxdmDefault;

	private boolean isInternal;

	private int qxdmSize;

	private boolean userDiagCFG;

	private boolean logcatDefault;

	private boolean mmsDefault;

	private boolean fotaDeault;

	protected RunningConfig(Context context) {
		this.sp = context.getSharedPreferences(RUNNING_PREFERENCE_NAME, Context.MODE_PRIVATE);

		this.notification = this.sp.getBoolean(SETTING_NOTIFICATION, false);

		this.isInternal = this.sp.getBoolean(SETTING_LOGCAT_DEFAULT, true);

		this.qxdmDefault = this.sp.getBoolean(SETTING_QXDM_DEFAULT, true);
		this.qxdmSize = this.sp.getInt(SETTING_QXDM_SIZE, DEFAULT_QXDM_SIZE);
		this.userDiagCFG = this.sp.getBoolean(SETTING_QXDM_CFG, false);

		this.logcatDefault = this.sp.getBoolean(SETTING_LOGCAT_DEFAULT, true);
		this.mmsDefault = this.sp.getBoolean(SETTING_MMS_DEFAULT, false);
		this.fotaDeault = this.sp.getBoolean(SETTING_FOTA_DEFAULT, false);
	}

	public boolean isNotification() {
		return this.notification;
	}

	public boolean setNotification(boolean notification) {
		boolean result = true;

		if (this.notification != notification) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_NOTIFICATION, notification);
			if (result = editor.commit()) {
				this.notification = notification;
			}
		}

		return result;
	}

	public boolean isInternal() {
		return this.isInternal;
	}

	public boolean setInternal(boolean isInternal) {
		boolean result = true;

		if (this.isInternal != isInternal) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_STORAGE_INTERNAL, isInternal);
			if (result = editor.commit()) {
				this.isInternal = isInternal;
			}
		}

		return result;
	}

	public boolean isQxdmDefault() {
		return this.qxdmDefault;
	}

	public boolean setQxdmDefault(boolean qxdmDefault) {
		boolean result = true;

		if (this.qxdmDefault != qxdmDefault) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_QXDM_DEFAULT, qxdmDefault);
			if (result = editor.commit()) {
				this.qxdmDefault = qxdmDefault;
			}
		}

		return result;
	}

	public int getQxdmSize() {
		return this.qxdmSize;
	}

	public boolean setQxdmSize(int qxdmSize) {
		boolean result = true;

		if (this.qxdmSize != qxdmSize) {
			Editor editor = this.sp.edit();
			editor.putInt(SETTING_QXDM_SIZE, qxdmSize);
			if (result = editor.commit()) {
				this.qxdmSize = qxdmSize;
			}
		}

		return result;
	}

	public boolean isUserDiagCFG() {
		return this.userDiagCFG;
	}

	public boolean setUserDiagCFG(boolean userDiagCFG) {
		boolean result = true;

		if (this.userDiagCFG != userDiagCFG) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_QXDM_CFG, userDiagCFG);
			if (result = editor.commit()) {
				this.userDiagCFG = userDiagCFG;
			}
		}

		return result;
	}

	public boolean isLogcatDefault() {
		return this.logcatDefault;
	}

	public boolean setLogcatDefault(boolean logcatDefault) {
		boolean result = true;

		if (this.logcatDefault != logcatDefault) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_LOGCAT_DEFAULT, logcatDefault);
			if (result = editor.commit()) {
				this.logcatDefault = logcatDefault;
			}
		}

		return result;
	}

	public boolean isMmsDefault() {
		return this.mmsDefault;
	}

	public boolean setMmsDefault(boolean mmsDefault) {
		boolean result = true;

		if (this.mmsDefault != mmsDefault) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_MMS_DEFAULT, mmsDefault);
			if (result = editor.commit()) {
				this.mmsDefault = mmsDefault;
			}
		}

		return result;
	}

	public boolean isFotaDeault() {
		return this.fotaDeault;
	}

	public boolean setFotaDeault(boolean fotaDeault) {
		boolean result = true;

		if (this.fotaDeault != fotaDeault) {
			Editor editor = this.sp.edit();
			editor.putBoolean(SETTING_FOTA_DEFAULT, fotaDeault);
			if (result = editor.commit()) {
				this.fotaDeault = fotaDeault;
			}
		}

		return result;
	}
}
