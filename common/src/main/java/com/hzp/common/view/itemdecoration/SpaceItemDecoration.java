package com.hzp.common.view.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by eve on 2016/7/6 0006.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space, spanCount = 2;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    public SpaceItemDecoration(int spanCount, int space) {
        this.spanCount = spanCount;
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (parent.getChildLayoutPosition(view) % spanCount == 0) {
            outRect.left = space;
        } else outRect.right = space;
    }

}
