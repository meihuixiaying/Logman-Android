package com.t2mobile.logman.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.t2mobile.logman.R;
import com.t2mobile.logman.adapter.ActionViewAdapter;
import com.t2mobile.logman.component.ActionTextView;
import com.t2mobile.logman.fragment.ConfigFragment;
import com.t2mobile.logman.fragment.MyFragment;
import com.t2mobile.logman.fragment.RecordFragement;
import com.t2mobile.logman.fragment.SelectFragment;

/**
 *
 *
 * @author jinlong.wang
 */
public class MainActivity extends FragmentActivity {
	public static final String ACTION = "Main";

	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_main);

		this.initViewPager();

		this.initActionBar();

		this.viewPager.setCurrentItem(1);
	}

	private void initViewPager() {
		this.viewPager = (ViewPager) this.findViewById(R.id.viewpager);

		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new SelectFragment());
		fragments.add(new ConfigFragment());
		fragments.add(new RecordFragement());
		fragments.add(new MyFragment());

		this.viewPager.setAdapter(new mainPagerAdapter(getSupportFragmentManager(), fragments));
	}

	private void initActionBar() {
		List<ActionTextView> actionTextViews = new ArrayList<ActionTextView>();
		actionTextViews.add((ActionTextView) this.findViewById(R.id.action_selecte));
		actionTextViews.add((ActionTextView) this.findViewById(R.id.action_config));
		actionTextViews.add((ActionTextView) this.findViewById(R.id.action_record));
		actionTextViews.add((ActionTextView) this.findViewById(R.id.action_my));
		new ActionViewAdapter(this.viewPager, actionTextViews);
	}

	private static class mainPagerAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragments;

		public mainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}
	}
}
