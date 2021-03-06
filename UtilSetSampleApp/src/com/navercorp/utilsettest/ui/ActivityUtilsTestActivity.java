package com.navercorp.utilsettest.ui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.navercorp.utilset.ui.ActivityUtils;
import com.navercorp.utilset.ui.ScreenUtils;
import com.navercorp.utilsettest.R;

public class ActivityUtilsTestActivity extends FragmentActivity implements ActionBar.TabListener {

	private ActivityUtilsPagerAdapter pagerAdapter;
	private ViewPager viewPager;
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activityutils);
		
		pagerAdapter = new ActivityUtilsPagerAdapter(getSupportFragmentManager());
		
		actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		viewPager = (ViewPager) findViewById(R.id.viewPagerActivityUtils);
		viewPager.setAdapter(pagerAdapter);
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if (position == 0) {
					ScreenUtils.setScreenOn(ActivityUtilsTestActivity.this);
				}
				else if (position == 1) {
					ScreenUtils.clearScreenOn(ActivityUtilsTestActivity.this);
				}
				 actionBar.setSelectedNavigationItem(position);
			}
			
		});
		
		for (int i=0;i<pagerAdapter.getCount();++i) {
			actionBar.addTab(actionBar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(this));
		}
		
		ScreenUtils.setScreenOn(this);
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}
	
}