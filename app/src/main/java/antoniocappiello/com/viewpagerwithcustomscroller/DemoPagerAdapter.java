/*
 * Copyright (c) 2015. Antonio Cappiello
 * www.antoniocappiello.com
 */

package antoniocappiello.com.viewpagerwithcustomscroller;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 10; // number of pages for this example

    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle extras = new Bundle();
        extras.putInt(DemoPageFragment.POSITION, position+1);
        DemoPageFragment fragment = new DemoPageFragment();
        fragment.setArguments(extras);
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}

