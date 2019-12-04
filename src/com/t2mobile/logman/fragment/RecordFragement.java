/*
 * @Title:     RecordFragement.java
 * @Package:   com.t2mobile.logman.fragment
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.fragment;

import com.t2mobile.logman.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecordFragement extends Fragment {

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		System.out.println("record");
		View view = inflater.inflate(R.layout.fragment_record, container, false);

		return view;
	}
}
