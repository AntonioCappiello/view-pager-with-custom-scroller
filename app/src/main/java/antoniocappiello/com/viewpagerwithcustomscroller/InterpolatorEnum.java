/*
 * Copyright (c) 2015. Antonio Cappiello
 * www.antoniocappiello.com
 */

package antoniocappiello.com.viewpagerwithcustomscroller;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by antoniocappiello on 24/10/15.
 * Selanto Apps © All right reserved
 */
public enum InterpolatorEnum {
    AccelerateDecelerate ("AccelerateDecelerate", new AccelerateDecelerateInterpolator()),
    Accelerate ("Accelerate", new AccelerateInterpolator()),
    Anticipate ("Anticipate", new AnticipateInterpolator()),
    AnticipateOvershoot ("AnticipateOvershoot", new AnticipateOvershootInterpolator()),
    Bounce ("Bounce", new BounceInterpolator()),
    Cycle ("Cycle", new CycleInterpolator((float)0.6)),
    Decelerate ("Decelerate", new DecelerateInterpolator()),
    FastOutLinearIn ("FastOutLinearIn", new FastOutLinearInInterpolator()),
    FastOutSlowIn ("FastOutSlowIn", new FastOutSlowInInterpolator()),
    Linear ("Linear", new LinearInterpolator()),
    LinearOutSlowIn ("LinearOutSlowIn", new LinearOutSlowInInterpolator()),
    Overshoot ("Overshoot", new OvershootInterpolator());
    
    private final String description;
    private final Interpolator interpolator;

    InterpolatorEnum (String description, Interpolator interpolator) {
        this.description = description;
        this.interpolator = interpolator;
    }

    public String getDescription() {
        return description;
    }

    public Interpolator getInterpolator() {
        return interpolator;
    }
}

