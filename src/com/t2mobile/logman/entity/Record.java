/*
 * @Title:     ActionTextView.java
 * @Package:   com.t2mobile.logman.component
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.entity;

import java.util.Date;

public class Record {
	public final static String RECORD_ID = "_id";
	public final static String RECORD_MODULE = "module";
	public final static String RECORD_TITLE = "title";
	public final static String RECORD_BATTERY_LEVEL = "batteryLevel";
	public final static String RECORD_NETWORK_TYPE = "networkType";
	public final static String RECORD_NETWORK_VALUE = "networkValue";
	public final static String RECORD_CPU = "cpu";
	public final static String RECORD_DESCRIPTION = "description";
	public final static String RECORD_CREATE_TIME = "createTime";
	public final static String RECORD_TOKEN_ID = "tokenId";
	public final static String RECORD_LOG_PATH = "logPath";
	public final static String RECORD_SAVE_TYPE = "saveType";

	private long id;
	private String module;
	private String title;
	private int batteryLevel;
	private String networkType;
	private int networkValue;
	private int cpu;
	private String description;
	private String createTime;
	private String tokenId;
	private int logPath;
	private String saveType;

	@SuppressWarnings("deprecation")
	public Record() {
		module = null;
		title = null;
		batteryLevel = 0;
		networkType = "wifi";
		networkValue = 0;
		cpu = 0;
		description = null;
		createTime = new Date().toLocaleString();
		tokenId = null;
		logPath = 0;
		saveType = null;

	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModule() {
		return module;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkValue(int networkValue) {
		this.networkValue = networkValue;
	}

	public int getNetworkValue() {
		return networkValue;
	}

	public void setCPU(int cpu) {
		this.cpu = cpu;
	}

	public int getCPU() {
		return cpu;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setLogPath(int logPath) {
		this.logPath = logPath;
	}

	public int getLogPath() {
		return logPath;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getSaveType() {
		return saveType;
	}
}
