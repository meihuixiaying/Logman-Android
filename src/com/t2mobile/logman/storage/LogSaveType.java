/*
 * @Title:     SaveType.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class LogSaveType implements ILogSaveType {

	private static final String SAVETYPE_PREFERENCE_NAME = "logman_savetype";

	private static final String SAVETYPE_CALL = "call_";
	private static final String SAVETYPE_MESSGE = "message_";
	private static final String SAVETYPE_CONTACT = "contact_";
	private static final String SAVETYPE_NETWORK = "network_";
	private static final String SAVETYPE_WIFI = "wifi_";
	private static final String SAVETYPE_CAMERA = "camera_";
	private static final String SAVETYPE_APP = "app_";
	private static final String SAVETYPE_POWER = "power_";
	private static final String SAVETYPE_OTHER = "other_";

	private SaveType callSaveType;

	private SaveType messageSaveType;

	private SaveType contactSaveType;

	private SaveType networdSaveType;

	private SaveType wifiSaveType;

	private SaveType cameraSaveType;

	private SaveType appSaveType;

	private SaveType powerSaveType;

	private SaveType otherSaveType;

	protected LogSaveType(Context context) {
		SharedPreferences sp = context.getSharedPreferences(SAVETYPE_PREFERENCE_NAME, Context.MODE_PRIVATE);

		this.callSaveType = new SaveType(sp, SAVETYPE_CALL);
		this.messageSaveType = new SaveType(sp, SAVETYPE_MESSGE);
		this.contactSaveType = new SaveType(sp, SAVETYPE_CONTACT);
		this.networdSaveType = new SaveType(sp, SAVETYPE_NETWORK);
		this.wifiSaveType = new SaveType(sp, SAVETYPE_WIFI);
		this.cameraSaveType = new SaveType(sp, SAVETYPE_CAMERA);
		this.appSaveType = new SaveType(sp, SAVETYPE_APP);
		this.powerSaveType = new SaveType(sp, SAVETYPE_POWER);
		this.otherSaveType = new SaveType(sp, SAVETYPE_OTHER);

	}

	public SaveType getCallSaveType() {
		return this.callSaveType;
	}

	public SaveType getMessageSaveType() {
		return this.messageSaveType;
	}

	public SaveType getContactSaveType() {
		return this.contactSaveType;
	}

	public SaveType getNetwordSaveType() {
		return this.networdSaveType;
	}

	public SaveType getWifiSaveType() {
		return this.wifiSaveType;
	}

	public SaveType getCameraSaveType() {
		return this.cameraSaveType;
	}

	public SaveType getAppSaveType() {
		return this.appSaveType;
	}

	public SaveType getPowerSaveType() {
		return this.powerSaveType;
	}

	public SaveType getOtherSaveType() {
		return this.otherSaveType;
	}

	public class SaveType {
		private static final String SAVETYPE_QXDM = "qxdm";

		private static final String SAVETYPE_LOGCAT = "logcat";

		private SharedPreferences sp;

		private String typeString;

		private boolean qxdm;

		private boolean logcat;

		public SaveType(SharedPreferences sp, String typeString) {
			this.sp = sp;
			this.typeString = typeString;

			this.qxdm = this.sp.getBoolean(this.typeString + SAVETYPE_QXDM, true);
			this.logcat = this.sp.getBoolean(this.typeString + SAVETYPE_LOGCAT, true);
		}

		public boolean isQxdm() {
			return this.qxdm;
		}

		public boolean setQxdm(boolean qxdm) {
			boolean result = true;

			if (this.qxdm != qxdm) {
				Editor editor = this.sp.edit();
				editor.putBoolean(this.typeString + SAVETYPE_QXDM, qxdm);
				if (result = editor.commit()) {
					this.qxdm = qxdm;
				}
			}

			return result;
		}

		public boolean isLogcat() {
			return this.logcat;
		}

		public boolean setLogcat(boolean logcat) {
			boolean result = true;

			if (this.logcat != logcat) {
				Editor editor = this.sp.edit();
				editor.putBoolean(this.typeString + SAVETYPE_LOGCAT, logcat);
				if (result = editor.commit()) {
					this.logcat = logcat;
				}
			}

			return result;
		}
	}
}
