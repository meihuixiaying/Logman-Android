/*
 * @Title:     RecordDBImpl.java
 * @Package:   com.t2m.logman.db.impl
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.storage;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.t2mobile.logman.entity.Record;

/**
 * 
 * @author jinlong.wang
 */
public class RecordDB extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "logman";
	private final static int DATABASE_VERSION = 1;
	private final static String TABLE_NAME = "record";

	public RecordDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + TABLE_NAME + " (" + Record.RECORD_ID + " INTEGER primary key autoincrement, "
				+ Record.RECORD_MODULE + " TEXT, " + Record.RECORD_TITLE + " TEXT, " + Record.RECORD_BATTERY_LEVEL
				+ " INTEGER, " + Record.RECORD_NETWORK_TYPE + " TEXT, " + Record.RECORD_NETWORK_VALUE + " INTEGER, "
				+ Record.RECORD_CPU + " INTEGER, " + Record.RECORD_DESCRIPTION + " TEXT, " + Record.RECORD_CREATE_TIME
				+ " TEXT, " + Record.RECORD_TOKEN_ID + " TEXT, " + Record.RECORD_LOG_PATH + " INTEGER, "
				+ Record.RECORD_SAVE_TYPE + " TEXT)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
		db.execSQL(sql);
		onCreate(db);
	}

	/*
	 * 
	 * @see com.t2m.logman.db.RecordDB#save(com.t2m.logman.entity.Record)
	 */
	public long add(Record record) throws Exception {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		long row = -1;
		if (record != null) {
			cv.put(Record.RECORD_MODULE, record.getModule());
			cv.put(Record.RECORD_TITLE, record.getTitle());
			cv.put(Record.RECORD_BATTERY_LEVEL, record.getBatteryLevel());
			cv.put(Record.RECORD_NETWORK_TYPE, record.getNetworkType());
			cv.put(Record.RECORD_NETWORK_VALUE, record.getNetworkValue());
			cv.put(Record.RECORD_CPU, record.getCPU());
			cv.put(Record.RECORD_DESCRIPTION, record.getDescription());
			cv.put(Record.RECORD_CREATE_TIME, record.getCreateTime() + "");
			cv.put(Record.RECORD_TOKEN_ID, record.getTokenId() != null ? record.getTokenId() : null);
			cv.put(Record.RECORD_LOG_PATH, record.getLogPath());
			cv.put(Record.RECORD_SAVE_TYPE, record.getSaveType());
			row = db.insert(TABLE_NAME, null, cv);
		}
		db.close();
		return row;
	}

	/*
	 * 
	 * @see com.t2m.logman.db.RecordDB#findAll()
	 */
	public List<Record> findAll() throws Exception {
		SQLiteDatabase db = this.getReadableDatabase();
		List<Record> recordList = new ArrayList<Record>();
		Record record = null;
		Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
		}
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			record = new Record();
			record.setId(cursor.getLong(cursor.getColumnIndex(Record.RECORD_ID)));
			record.setModule(cursor.getString(cursor.getColumnIndex(Record.RECORD_MODULE)));
			record.setTitle(cursor.getString(cursor.getColumnIndex(Record.RECORD_TITLE)));
			record.setBatteryLevel(cursor.getInt(cursor.getColumnIndex(Record.RECORD_BATTERY_LEVEL)));
			record.setNetworkType(cursor.getString(cursor.getColumnIndex(Record.RECORD_NETWORK_TYPE)));
			record.setNetworkValue(cursor.getInt(cursor.getColumnIndex(Record.RECORD_NETWORK_VALUE)));
			record.setCPU(cursor.getInt(cursor.getColumnIndex(Record.RECORD_CPU)));
			record.setDescription(cursor.getString(cursor.getColumnIndex(Record.RECORD_DESCRIPTION)));
			record.setCreateTime(cursor.getString(cursor.getColumnIndex(Record.RECORD_CREATE_TIME)));
			record.setTokenId(cursor.getString(cursor.getColumnIndex(Record.RECORD_TOKEN_ID)));
			record.setLogPath(cursor.getInt(cursor.getColumnIndex(Record.RECORD_LOG_PATH)));
			record.setSaveType(cursor.getString(cursor.getColumnIndex(Record.RECORD_SAVE_TYPE)));
			recordList.add(record);
		}
		db.close();
		return recordList;
	}

	/*
	 * 
	 * @see com.t2m.logman.db.RecordDB#findById(int)
	 */
	public Record findById(long id) throws Exception {
		SQLiteDatabase db = this.getReadableDatabase();
		Record record = new Record();
		String selection = Record.RECORD_ID + "=?";
		String[] selectionArgs = { Long.toString(id) };
		Cursor cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
		}
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			record.setId(cursor.getLong(cursor.getColumnIndex(Record.RECORD_ID)));
			record.setModule(cursor.getString(cursor.getColumnIndex(Record.RECORD_MODULE)));
			record.setTitle(cursor.getString(cursor.getColumnIndex(Record.RECORD_TITLE)));
			record.setBatteryLevel(cursor.getInt(cursor.getColumnIndex(Record.RECORD_BATTERY_LEVEL)));
			record.setNetworkType(cursor.getString(cursor.getColumnIndex(Record.RECORD_NETWORK_TYPE)));
			record.setNetworkValue(cursor.getInt(cursor.getColumnIndex(Record.RECORD_NETWORK_VALUE)));
			record.setCPU(cursor.getInt(cursor.getColumnIndex(Record.RECORD_CPU)));
			record.setDescription(cursor.getString(cursor.getColumnIndex(Record.RECORD_DESCRIPTION)));
			record.setCreateTime(cursor.getString(cursor.getColumnIndex(Record.RECORD_CREATE_TIME)));
			record.setTokenId(cursor.getString(cursor.getColumnIndex(Record.RECORD_TOKEN_ID)));
			record.setLogPath(cursor.getInt(cursor.getColumnIndex(Record.RECORD_LOG_PATH)));
			record.setSaveType(cursor.getString(cursor.getColumnIndex(Record.RECORD_SAVE_TYPE)));
		}
		db.close();
		return record;
	}

	/*
	 * 
	 * @see com.t2m.logman.db.RecordDB#delete(int)
	 */
	public long delete(long id) throws Exception {
		SQLiteDatabase db = this.getWritableDatabase();
		long row = -1;
		String whereClause = Record.RECORD_ID + "=?";
		String[] whereArgs = { Long.toString(id) };
		row = db.delete(TABLE_NAME, whereClause, whereArgs);
		db.close();
		return row;
	}

	/*
	 * 
	 * @see com.t2m.logman.db.RecordDB#update(com.t2m.logman.db.RecordDB)
	 */
	public long update(Record record) throws Exception {
		SQLiteDatabase db = this.getWritableDatabase();
		String whereClause = Record.RECORD_ID + "=?";
		String[] whereArgs = { Long.toString(record.getId()) };
		long row = -1;
		ContentValues cv = new ContentValues();
		if (record != null) {
			cv.put(Record.RECORD_MODULE, record.getModule());
			cv.put(Record.RECORD_TITLE, record.getTitle());
			cv.put(Record.RECORD_BATTERY_LEVEL, record.getBatteryLevel());
			cv.put(Record.RECORD_NETWORK_TYPE, record.getNetworkType());
			cv.put(Record.RECORD_NETWORK_VALUE, record.getNetworkValue());
			cv.put(Record.RECORD_CPU, record.getCPU());
			cv.put(Record.RECORD_DESCRIPTION, record.getDescription());
			cv.put(Record.RECORD_CREATE_TIME, record.getCreateTime());
			cv.put(Record.RECORD_TOKEN_ID, record.getTokenId());
			cv.put(Record.RECORD_LOG_PATH, record.getLogPath());
			cv.put(Record.RECORD_SAVE_TYPE, record.getSaveType());
		}
		row = db.update(TABLE_NAME, cv, whereClause, whereArgs);
		db.close();
		return row;
	}
}
