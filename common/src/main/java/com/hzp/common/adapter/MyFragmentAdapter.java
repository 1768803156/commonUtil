package com.hzp.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragmentAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> list;
	private ArrayList<String> mTitle=new ArrayList<>();

	public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
		super(fm);
		this.list = list;
	}

	public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> mTitle) {
		super(fm);
		this.list = list;
		this.mTitle = mTitle;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (mTitle.size() > position) {
			return mTitle.get(position);
		} else
			return "";
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}

}
