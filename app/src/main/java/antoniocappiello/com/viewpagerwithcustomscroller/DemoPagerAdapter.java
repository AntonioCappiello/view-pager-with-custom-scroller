package antoniocappiello.com.viewpagerwithcustomscroller;/*
 * Created by a.cappiello on 23-10-2015 - 16:23.
 * Copyright (c) 2015. Coolblue. All rights reserved.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 5; // number of pages for this example

    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new DemoPageFragment(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}

