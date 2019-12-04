/*
 * @Title:     ISaveType.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.storage;

import com.t2mobile.logman.storage.LogSaveType.SaveType;

/**
 * 
 *
 * @author songlin.ji
 */
public interface ILogSaveType {
	SaveType getCallSaveType();

	SaveType getMessageSaveType();

	SaveType getContactSaveType();

	SaveType getNetwordSaveType();

	SaveType getWifiSaveType();

	SaveType getCameraSaveType();

	SaveType getAppSaveType();

	SaveType getPowerSaveType();

	SaveType getOtherSaveType();
}
