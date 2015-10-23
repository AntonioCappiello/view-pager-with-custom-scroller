package antoniocappiello.com.viewpagerwithcustomscroller;/*
 * Created by a.cappiello on 23-10-2015 - 15:53.
 * Copyright (c) 2015. Coolblue. All rights reserved.
 */

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomScroller extends Scroller {

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
}