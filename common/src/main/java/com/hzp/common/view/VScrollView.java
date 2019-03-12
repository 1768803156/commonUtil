package com.hzp.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author HZP
 * @version created at 2018-06-12 10:09
 *          https://github.com/Aeiric/CustomScrollView
 */
public class VScrollView extends ScrollView {
    /**
     * Runnable延迟执行的时间
     */
    private long delayMillis = 100;

    /**
     * 上次滑动的时间
     */
    private long lastScrollUpdate = -1;

    private Runnable scrollerTask = new Runnable() {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - lastScrollUpdate) > 100) {
                lastScrollUpdate = -1;
                if (mListener != null) mListener.onScrollEnd();
            } else {
                postDelayed(this, delayMillis);
            }
        }
    };

    public VScrollView(Context context) {
        this(context, null);
    }

    public VScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mListener != null) mListener.onScroll(getScrollY());

        if (lastScrollUpdate == -1) {
            if (mListener != null) mListener.onScrollStart();
            postDelayed(scrollerTask, delayMillis);
        }
        // 更新ScrollView的滑动时间
        lastScrollUpdate = System.currentTimeMillis();
    }

    private OnVScrollListener mListener;

    public void setOnOnVScrollListener(VScrollView.OnVScrollListener listener) {
        this.mListener = listener;
    }

    public interface OnVScrollListener {

        void onScroll(int scrollY);

        /**
         * 滑动开始
         */
        void onScrollStart();
        /**
         * 滑动结束
         */
        void onScrollEnd();
    }
}
