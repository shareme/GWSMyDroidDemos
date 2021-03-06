/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Asylbek Isakov
 * Modifications Copyright (C) 2015 Fred Grott(GrottWorkShop)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package com.grottworkshop.gwsarcanimations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * ArcDebugView class
 * Created by fgrott on 9/16/2015.
 */
@SuppressWarnings("unused")
public class ArcDebugView extends View {

    private ArcMetric mArcMetric;

    private Paint mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static final int BLUE = 0xFF2196F3;
    private static final int PURPLE = 0xFF9C27B0;
    private static final int LIGHTGREEN = 0xFF64DD17;

    private static final int STARTPOINT = 0xFFF44336;// red
    private static final int ENDPOINT = 0xFFFF9800;//orange
    private static final int MIDPOINT = 0xFF795548;//brown
    private static final int AXISPOINT = 0xFF4CAF50;//green
    private static final int AXISPOINT1 = 0xFF9C27B0;//purple
    private static final int ABSOLUTEPOINT = 0xFF424242;//grey

    public void drawArcAnimator(ArcAnimator arcAnimator){
        mArcMetric = arcAnimator.mArcMetric;
        invalidate();
    }

    public ArcDebugView(Context context) {
        this(context, null);
    }

    public ArcDebugView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcDebugView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaintStroke.setStyle(Paint.Style.STROKE);
        mPaintStroke.setStrokeWidth(dpToPx(1));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mArcMetric != null){
            drawElements(canvas);
        }
    }

    private void drawElements(Canvas canvas){
        drawLines(canvas);
        drawCircles(canvas);
        drawPoints(canvas);
    }

    private void drawPoints(Canvas canvas){
        mPaintFill.setColor(STARTPOINT);
        canvas.drawCircle(mArcMetric.mStartPoint.x, mArcMetric.mStartPoint.y, dpToPx(2), mPaintFill);
        mPaintFill.setColor(ENDPOINT);
        canvas.drawCircle(mArcMetric.mEndPoint.x, mArcMetric.mEndPoint.y, dpToPx(2), mPaintFill);
        mPaintFill.setColor(MIDPOINT);
        canvas.drawCircle(mArcMetric.mMidPoint.x, mArcMetric.mMidPoint.y, dpToPx(2), mPaintFill);
        mPaintFill.setColor(AXISPOINT);
        canvas.drawCircle(mArcMetric.mAxisPoint[Side.RIGHT.value].x, mArcMetric.mAxisPoint[Side.RIGHT.value].y, dpToPx(3), mPaintFill);
        mPaintFill.setColor(AXISPOINT1);
        canvas.drawCircle(mArcMetric.mAxisPoint[Side.LEFT.value].x, mArcMetric.mAxisPoint[Side.LEFT.value].y, dpToPx(3), mPaintFill);
        mPaintFill.setColor(ABSOLUTEPOINT);
        canvas.drawCircle(mArcMetric.mZeroPoint.x, mArcMetric.mZeroPoint.y, dpToPx(2), mPaintFill);
    }

    private void drawLines(Canvas canvas){
        mPaintStroke.setColor(PURPLE);
        canvas.drawLine(mArcMetric.mStartPoint.x, mArcMetric.mStartPoint.y,
                mArcMetric.mEndPoint.x, mArcMetric.mEndPoint.y, mPaintStroke);
        canvas.drawLine(mArcMetric.mStartPoint.x, mArcMetric.mStartPoint.y,
                mArcMetric.mAxisPoint[mArcMetric.mSide.value].x, mArcMetric.mAxisPoint[mArcMetric.mSide.value].y, mPaintStroke);
        canvas.drawLine(mArcMetric.mEndPoint.x, mArcMetric.mEndPoint.y,
                mArcMetric.mAxisPoint[mArcMetric.mSide.value].x, mArcMetric.mAxisPoint[mArcMetric.mSide.value].y, mPaintStroke);
    }

    private void drawCircles(Canvas canvas){
        mPaintStroke.setColor(BLUE);
        canvas.drawCircle(mArcMetric.mStartPoint.x, mArcMetric.mStartPoint.y, mArcMetric.mRadius, mPaintStroke);
        canvas.drawCircle(mArcMetric.mEndPoint.x, mArcMetric.mEndPoint.y, mArcMetric.mRadius, mPaintStroke);
        mPaintStroke.setColor(LIGHTGREEN);
        canvas.drawCircle(mArcMetric.mAxisPoint[mArcMetric.mSide.value].x,
                mArcMetric.mAxisPoint[mArcMetric.mSide.value].y, mArcMetric.mRadius, mPaintStroke);
    }

    public int dpToPx(int dp){
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}