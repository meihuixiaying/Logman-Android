/*
 * @Title:     ActionViewAdapter.java
 * @Package:   com.t2mobile.logman.adapter
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 */
package com.t2mobile.logman.adapter;

import java.util.List;

import com.t2mobile.logman.component.ActionTextView;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 *
 * @author songlin.ji
 */
public class ActionViewAdapter implements OnPageChangeListener, OnClickListener {

	private ViewPager viewPager;

	private List<ActionTextView> actionTextViews;

	public ActionViewAdapter(final ViewPager viewPager, final List<ActionTextView> actionTextViews) {
		this.viewPager = viewPager;

		this.viewPager.setOnPageChangeListener(this);

		this.actionTextViews = actionTextViews;

		for (ActionTextView actionTextView : actionTextViews) {
			actionTextView.setOnClickListener(this);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		if (arg1 == 0) {
			setActionSelected(arg0);
		} else {
			this.setActionIntermedial(arg0);
		}
	}

	@Override
	public void onPageSelected(int arg0) {
		// setActionSelected(arg0);
	}

	private void setActionSelected(int index) {
		for (int i = 0; i < actionTextViews.size(); i++) {
			if (i == index) {
				actionTextViews.get(i).setViewStatus(ActionTextView.STATUS_SELECTED);
			} else {
				actionTextViews.get(i).setViewStatus(ActionTextView.STATUS_UNSELECTED);
			}
		}
	}

	private void setActionIntermedial(int index) {
		for (int i = 0; i < actionTextViews.size(); i++) {
			if (i == index || i == index + 1) {
				actionTextViews.get(i).setViewStatus(ActionTextView.STATUS_INTERMEDIAL);
			} else {
				actionTextViews.get(i).setViewStatus(ActionTextView.STATUS_UNSELECTED);
			}
		}
	}

	@Override
	public void onClick(View v) {
		int index = this.actionTextViews.indexOf(v);
		if (index > -1 && index < this.actionTextViews.size()) {
			this.viewPager.setCurrentItem(index);
		}
	}
}
