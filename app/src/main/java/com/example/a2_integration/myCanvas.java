package com.example.a2_integration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/** This class is used to draw the PDR trajectory on a canvas so it can be visualised.
 */
public class myCanvas extends View {

    private Paint mPaint;
    private List<PointF> mPoints;
    private PointF mInitialPosition;

    public myCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public myCanvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public myCanvas(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10f);

        mPoints = new ArrayList<>();
        mInitialPosition = new PointF();
    }

    public void clearPoints() {
        mPoints.clear();
        invalidate();
    }

    public void addPoint(float x, float y) {
        mPoints.add(new PointF(x, -y));
        invalidate();
    }

    public void drawInitialPosition(float x, float y) {
        // Load the x and y positions into the initial position pointF
        mInitialPosition.x = x;
        mInitialPosition.y = -y;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Move the canvas origin to the bottom left corner
        // The positive y-axis still points down
        canvas.translate(0, getHeight());
        //canvas.scale(1,-1);

        // Draw the trajectory path
        if (mPoints.size() > 1) {
            for (int i = 0; i < mPoints.size() - 1; i++) {
                PointF p1 = mPoints.get(i);
                PointF p2 = mPoints.get(i + 1);
                canvas.drawLine(p1.x, p1.y, p2.x, p2.y, mPaint);
            }
        }

        // Draw the initial position
        canvas.drawCircle(mInitialPosition.x,mInitialPosition.y,5,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 1000; // set your desired width here
        int desiredHeight = 1000; // set your desired height here

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }
}
