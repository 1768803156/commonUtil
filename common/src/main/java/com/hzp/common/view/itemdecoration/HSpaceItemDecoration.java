package com.hzp.common.view.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by eve on 2016/7/6 0006.
 */
public class HSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public HSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = space;

        if (parent.getChildLayoutPosition(view) == parent.getAdapter().getItemCount() - 1) {
            outRect.right = space*2;
        }else{
            outRect.right = space;
        }

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.left = space*2;
        }else  outRect.left = 0;
    }

}
