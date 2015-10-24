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
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private CustomScroller customScroller;
    private TextView durationView;
    private Spinner animationSpinner;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.pager);
        durationView = (TextView) findViewById(R.id.duration_view);
        animationSpinner = (Spinner) findViewById(R.id.animation_spinner);

        setCustomScrollerToViewPager();

        PagerAdapter mAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        initSpinner();

    }

    private void initSpinner() {
        ArrayAdapter<InterpolatorEnum> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, InterpolatorEnum.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animationSpinner.setAdapter(adapter);
        animationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setCustomScrollerToViewPager(InterpolatorEnum.values()[i].getInterpolator(), customScroller.getCustomDuration());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setCustomScrollerToViewPager() {
        setCustomScrollerToViewPager(new LinearInterpolator(), 500);
    }

    private void setCustomScrollerToViewPager(Interpolator interpolator, int duration) {
        try {
            customScroller = new CustomScroller(this, interpolator, duration);
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(mPager, customScroller);
            durationView.setText(customScroller.getCustomDuration() + " ms");
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
