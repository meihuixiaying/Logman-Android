/*
 * @Title:     IStageConfig.java
 * @Package:   com.t2mobile.logman.storage
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.storage;

import com.t2mobile.logman.storage.StageConfig.Stage;

/**
 * 
 *
 * @author songlin.ji
 */
public interface IStageConfig extends IStage {
	int getStageID();

	void setStageID(int stageID);

	Stage getStage();

	void setStage(Stage stage);
}
