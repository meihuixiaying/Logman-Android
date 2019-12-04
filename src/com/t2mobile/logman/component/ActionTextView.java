/*
 * @Title:     ActionTextView.java
 * @Package:   com.t2mobile.logman.component
 * @Project:   Logman
 * @Version:   1.0.0
 * @CopyRight: @2015 T2M-VAL
 * @author:    jinlong.wang
 */
package com.t2mobile.logman.component;

import com.t2mobile.logman.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ActionTextView extends TextView {
	public static final int STATUS_SELECTED = 0;
	public static final int STATUS_INTERMEDIAL = 1;
	public static final int STATUS_UNSELECTED = 2;

	private int status = -1;

	private int selectedColor;

	private int intermedialColor;

	private int unselectedColor;

	private Drawable selectedDrawable;

	private Drawable intermedialDrawable;

	private Drawable unselectedDrawable;

	public ActionTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ActionView);

		this.intermedialColor = array.getInt(R.styleable.ActionView_intermedialColor, R.color.intermedial_color);
		this.selectedColor = array.getInt(R.styleable.ActionView_selectedColor, R.color.selected_color);
		this.unselectedColor = array.getInt(R.styleable.ActionView_unselectedColor, R.color.unselected_color);

		this.selectedDrawable = array.getDrawable(R.styleable.ActionView_selectedIcon);
		this.intermedialDrawable = array.getDrawable(R.styleable.ActionView_intermedialIcon);
		this.unselectedDrawable = array.getDrawable(R.styleable.ActionView_unselectedIcon);

		int userstatus = array.getInt(R.styleable.ActionView_actionStatus, STATUS_UNSELECTED);

		this.setViewStatus(userstatus);

		array.recycle();

	}

	public void setViewStatus(int status) {
		if (this.status == status) {
			return;
		} else {
			this.status = status;
		}

		switch (this.status) {
		case STATUS_SELECTED:
			this.setTextColor(this.getResources().getColor(this.selectedColor));
			this.setCompoundDrawablesWithIntrinsicBounds(null, this.selectedDrawable, null, null);
			break;
		case STATUS_INTERMEDIAL:
			this.setTextColor(this.getResources().getColor(this.intermedialColor));
			this.setCompoundDrawablesWithIntrinsicBounds(null, this.intermedialDrawable, null, null);
			break;
		case STATUS_UNSELECTED:
			this.setTextColor(this.getResources().getColor(this.unselectedColor));
			this.setCompoundDrawablesWithIntrinsicBounds(null, this.unselectedDrawable, null, null);
			break;
		default:
			this.setTextColor(this.getResources().getColor(this.unselectedColor));
			this.setCompoundDrawablesWithIntrinsicBounds(null, this.unselectedDrawable, null, null);
			break;
		}
	}
}
