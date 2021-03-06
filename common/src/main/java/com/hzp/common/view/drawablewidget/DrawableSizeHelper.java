/*
 * Date: 15-1-30
 * Project: DrawableWidget
 */
package com.hzp.common.view.drawablewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hzp.common.R;


/**
 * Author: msdx (645079761@qq.com)
 * Time: 15-1-30 下午5:05
 */
public class DrawableSizeHelper {
    private Drawable left;
    private Drawable top;
    private Drawable right;
    private Drawable bottom;

    private int mDrawableWidth;
    private int mDrawableHeight;

    public void readAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawableSize);
        mDrawableWidth = typedArray.getDimensionPixelSize(R.styleable.DrawableSize_drawableWidth, 0);
        mDrawableHeight = typedArray.getDimensionPixelSize(R.styleable.DrawableSize_drawableHeight, 0);
        typedArray.recycle();
    }

    public void setDrawable(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public boolean isNotSet() {
        return mDrawableWidth <= 0 && mDrawableHeight <= 0;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(TextView widget) {
        if (left != null) {
            left.setBounds(0, 0, calculateWidth(left), calculateHeight(left));
        }
        if (right != null) {
            right.setBounds(0, 0, calculateWidth(right), calculateHeight(right));
        }
        if (top != null) {
            top.setBounds(0, 0, calculateWidth(top), calculateHeight(top));
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, calculateWidth(bottom), calculateHeight(bottom));
        }
        widget.setCompoundDrawables(left, top, right, bottom);
    }

    public int calculateWidth(Drawable d) {
        if(mDrawableWidth == 0) {
            return d.getIntrinsicWidth() * mDrawableHeight / d.getIntrinsicHeight();
        }
        return mDrawableWidth;
    }

    public int calculateHeight(Drawable d) {
        if(mDrawableHeight == 0) {
            return  d.getIntrinsicHeight() * mDrawableWidth / d.getIntrinsicWidth();
        }
        return mDrawableHeight;
    }

    @TargetApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView widget) {
        if (left != null) {
            left.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        widget.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    }
}
