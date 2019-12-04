/*
 * @Title:     InterfaceSetting.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.storage;

public interface IRunningConfig {

	boolean isNotification();

	boolean setNotification(boolean notification);

	boolean isQxdmDefault();

	boolean setQxdmDefault(boolean qxdmDefault);

	boolean isLogcatDefault();

	boolean setLogcatDefault(boolean logcatDefault);

	boolean isInternal();

	boolean setInternal(boolean isInternal);

	int getQxdmSize();

	boolean setQxdmSize(int qxdmSize);

	boolean isUserDiagCFG();

	boolean setUserDiagCFG(boolean userDiagCFG);

	boolean isMmsDefault();

	boolean setMmsDefault(boolean mmsDefault);

	boolean isFotaDeault();

	boolean setFotaDeault(boolean fotaDeault);
}
