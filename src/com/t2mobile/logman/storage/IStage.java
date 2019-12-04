/*
 * @Title:     IStage.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    songlin.ji
 */
package com.t2mobile.logman.storage;

public interface IStage {
	void setModel(String model);

	void setImei(String imei);

	void setOperator(String operator);

	void setPhone(String phone);

	void setPlat(String plat);

	void setBranch(String branch);

	void setPerso(String perso);

	void setOperatorLongName(String operatorLongName);

	void setOperatorShortName(String operatorShortName);
}
