/*
 * Copyright (c) 2015. Antonio Cappiello
 * www.antoniocappiello.com
 */

package antoniocappiello.com.viewpagerwithcustomscroller;


import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomScroller extends Scroller {

    private static final int MIN = 0;
    private static final int MAX = 3000;
    private int mDuration = 0;

    public CustomScroller(Context context, Interpolator interpolator, int duration) {
        super(context, interpolator);
        mDuration = duration;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public int getCustomDuration() {
        return mDuration;
    }

    public void setCustomDuration(int customDuration) {
        if(customDuration <= MIN) {
            mDuration = MIN;
        }
        else if (customDuration >= MAX) {
            mDuration = MAX;
        }
        else {
            mDuration = customDuration;
        }
    }
}