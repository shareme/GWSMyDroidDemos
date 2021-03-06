/*
 * Copyright 2014 Niek Haarman
 * Modifications Copyright (C) Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grottworkshop.gwslistviewanimations.appearance.simple;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.grottworkshop.gwslistviewanimations.appearance.AnimationAdapter;

/**
 * ScaleInAnimationAdapter class
 * Created by fgrott on 9/2/2015.
 */
@SuppressWarnings("unused")
public class ScaleInAnimationAdapter extends AnimationAdapter {

    private static final float DEFAULT_SCALE_FROM = 0.8f;

    private static final String SCALE_X = "scaleX";
    private static final String SCALE_Y = "scaleY";

    private final float mScaleFrom;

    public ScaleInAnimationAdapter(@NonNull final BaseAdapter baseAdapter) {
        this(baseAdapter, DEFAULT_SCALE_FROM);
    }

    public ScaleInAnimationAdapter(@NonNull final BaseAdapter baseAdapter, final float scaleFrom) {
        super(baseAdapter);
        mScaleFrom = scaleFrom;
    }

    @NonNull
    @Override
    public Animator[] getAnimators(@NonNull final ViewGroup parent, @NonNull final View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, SCALE_X, mScaleFrom, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, SCALE_Y, mScaleFrom, 1f);
        return new ObjectAnimator[]{scaleX, scaleY};
    }
}
