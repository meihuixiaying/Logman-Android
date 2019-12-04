/*
 * @Title:     StageConfig.java
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

public class StageConfig implements IStageConfig {

	private static final String STAGE_PREFERENCE_NAME = "logman_stage";

	private static final String STAGE_ID = "id";
	private static final String STAGE_MODEL = "model";
	private static final String STAGE_IMEI = "imei";
	private static final String STAGE_OPERATOR = "operator";
	private static final String STAGE_PHONE = "phone";
	private static final String STAGE_PLAT = "plat";
	private static final String STAGE_BRANCH = "branch";
	private static final String STAGE_PERSO = "perso";
	private static final String STAGE_OPERATOR_LONG_NAME = "operatorLongName";
	private static final String STAGE_OPERATOR_SHORT_NAME = "operatorShortName";

	private SharedPreferences sp;

	private int stageID;

	private Stage stage;

	protected StageConfig(Context context) {
		this.sp = context.getSharedPreferences(STAGE_PREFERENCE_NAME, Context.MODE_PRIVATE);

		this.stageID = this.sp.getInt(STAGE_ID, 0);

		this.stage = new Stage();

		stage.setModel(this.sp.getString(STAGE_MODEL, ""));
		stage.setImei(this.sp.getString(STAGE_IMEI, ""));
		stage.setOperator(this.sp.getString(STAGE_OPERATOR, ""));
		stage.setPhone(this.sp.getString(STAGE_PHONE, ""));
		stage.setPlat(this.sp.getString(STAGE_PLAT, ""));
		stage.setBranch(this.sp.getString(STAGE_BRANCH, ""));
		stage.setPerso(this.sp.getString(STAGE_PERSO, ""));
		stage.setOperatorLongName(this.sp.getString(STAGE_OPERATOR_LONG_NAME, ""));
		stage.setOperatorShortName(this.sp.getString(STAGE_OPERATOR_SHORT_NAME, ""));
	}

	public int getStageID() {
		return this.stageID;
	}

	public void setStageID(int stageID) {

		if (this.stageID != stageID) {
			Editor editor = this.sp.edit();
			editor.putInt(STAGE_ID, stageID);
			if (editor.commit()) {
				this.stageID = stageID;
			}
		}
	}

	public Stage getStage() {
		return this.stage;
	}

	public void setStage(Stage stage) {
		if (!this.stage.equals(stage)) {

			Editor editor = this.sp.edit();
			editor.putString(STAGE_MODEL, stage.model);
			editor.putString(STAGE_IMEI, stage.imei);
			editor.putString(STAGE_OPERATOR, stage.operator);
			editor.putString(STAGE_PHONE, stage.phone);
			editor.putString(STAGE_PLAT, stage.plat);
			editor.putString(STAGE_BRANCH, stage.branch);
			editor.putString(STAGE_PERSO, stage.perso);
			editor.putString(STAGE_OPERATOR_LONG_NAME, stage.operatorLongName);
			editor.putString(STAGE_OPERATOR_SHORT_NAME, stage.operatorShortName);

			if (editor.commit()) {
				this.stage = stage;
			}
		}
	}

	@Override
	public void setModel(String model) {
		if (!this.stage.model.equals(model)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_MODEL, model);
			if (editor.commit()) {
				this.stage.setModel(model);
			}
		}
	}

	@Override
	public void setImei(String imei) {
		if (!this.stage.imei.equals(imei)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_IMEI, imei);
			if (editor.commit()) {
				this.stage.setImei(imei);
			}
		}
	}

	@Override
	public void setOperator(String operator) {
		if (!this.stage.operator.equals(operator)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_OPERATOR, operator);
			if (editor.commit()) {
				this.stage.setOperator(operator);
			}
		}
	}

	@Override
	public void setPhone(String phone) {
		if (!this.stage.phone.equals(phone)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_PHONE, phone);
			if (editor.commit()) {
				this.stage.setPhone(phone);
			}
		}
	}

	@Override
	public void setPlat(String plat) {
		if (!this.stage.plat.equals(plat)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_PLAT, plat);
			if (editor.commit()) {
				this.stage.setPlat(plat);
			}
		}
	}

	@Override
	public void setBranch(String branch) {
		if (!this.stage.branch.equals(branch)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_BRANCH, branch);
			if (editor.commit()) {
				this.stage.setBranch(branch);
			}
		}

	}

	@Override
	public void setPerso(String perso) {
		if (!this.stage.perso.equals(perso)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_PERSO, perso);
			if (editor.commit()) {
				this.stage.setPerso(perso);
			}
		}
	}

	@Override
	public void setOperatorLongName(String operatorLongName) {
		if (!this.stage.operatorLongName.equals(operatorLongName)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_OPERATOR_LONG_NAME, operatorLongName);
			if (editor.commit()) {
				this.stage.setOperatorLongName(operatorLongName);
			}
		}
	}

	@Override
	public void setOperatorShortName(String operatorShortName) {
		if (!this.stage.operatorShortName.equals(operatorShortName)) {
			Editor editor = this.sp.edit();
			editor.putString(STAGE_OPERATOR_SHORT_NAME, operatorShortName);
			if (editor.commit()) {
				this.stage.setOperatorShortName(operatorShortName);
			}
		}
	}

	/**
	 * 
	 * 
	 *
	 * @author songlin.ji
	 */
	public class Stage {
		private String model;

		private String imei;

		private String operator;

		private String phone;

		private String plat;

		private String branch;

		private String perso;

		private String operatorLongName;

		private String operatorShortName;

		public String getModel() {
			return this.model;
		}

		public String getImei() {
			return this.imei;
		}

		public String getOperator() {
			return this.operator;
		}

		public String getPhone() {
			return this.phone;
		}

		public String getPlat() {
			return this.plat;
		}

		public String getBranch() {
			return this.branch;
		}

		public String getPerso() {
			return this.perso;
		}

		public String getOperatorLongName() {
			return this.operatorLongName;
		}

		public String getOperatorShortName() {
			return this.operatorShortName;
		}

		private void setModel(String model) {
			this.model = model;
		}

		private void setImei(String imei) {
			this.imei = imei;
		}

		private void setOperator(String operator) {
			this.operator = operator;
		}

		private void setPhone(String phone) {
			this.phone = phone;
		}

		private void setPlat(String plat) {
			this.plat = plat;
		}

		private void setBranch(String branch) {
			this.branch = branch;
		}

		private void setPerso(String perso) {
			this.perso = perso;
		}

		private void setOperatorLongName(String operatorLongName) {
			this.operatorLongName = operatorLongName;
		}

		private void setOperatorShortName(String operatorShortName) {
			this.operatorShortName = operatorShortName;
		}
	}
}
