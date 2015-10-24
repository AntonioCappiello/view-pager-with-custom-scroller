/*
 * Copyright (c) 2015. Antonio Cappiello
 * www.antoniocappiello.com
 */

package antoniocappiello.com.viewpagerwithcustomscroller;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private CustomScroller customScroller;
    private TextView durationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager); // The pager widget which allows swiping horizontally
        setCustomScrollerToViewPager(mPager);

        PagerAdapter mAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        durationView = (TextView) findViewById(R.id.duration_view);

    }

    private void setCustomScrollerToViewPager(ViewPager mPager) {
        try {
            customScroller = new CustomScroller(this, new LinearInterpolator(), 0);
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(mPager, customScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void addDelay(View view){
        customScroller.setCustomDuration(customScroller.getCustomDuration() + 100);
        durationView.setText(customScroller.getCustomDuration() + " ms");
    }

    public void reduceDelay(View view){
        customScroller.setCustomDuration(customScroller.getCustomDuration() - 100);
        durationView.setText(customScroller.getCustomDuration() + " ms");
    }

}
